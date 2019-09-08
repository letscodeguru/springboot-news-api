package guru.letscode;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import guru.letscode.document.FeedDocument;
import guru.letscode.document.FeedDocumentRepository;
import guru.letscode.document.FeedDocumentRequest;
import guru.letscode.feed.FeedContent;
import guru.letscode.feed.FeedMeta;
import guru.letscode.feed.FeedMetaProperties;


@RestController
@RequestMapping("/api")
public class DocumentStoreController {

	@Autowired
	private FeedDocumentRepository repository;

	@RequestMapping(value = "/docstore", method = RequestMethod.GET)
	public List<FeedDocument> getDocuments() {
		return repository.findAll();
	}

	@RequestMapping(value = "/docstore", method = RequestMethod.POST)
	public FeedDocument saveDocuments(@RequestBody FeedDocumentRequest request) {
		Document doc = null;
		guru.letscode.feed.FeedFetcher fetcher = new guru.letscode.feed.FeedFetcher();
		try {
			doc = fetcher.fetch(request.getUrl());
			FeedContent content = new FeedContent();
			String con = content.getFeedContent(doc);
			Elements metaElements = doc.getElementsByTag("meta");
			FeedMeta metaTags = new FeedMetaProperties()
					.convertMetaTagsToMetaProperties(new guru.letscode.feed.FeedMetaTags(metaElements));
			
			FeedDocument document = new FeedDocument();
			document.setUrl(metaTags.getUrl());
			document.setUrlToImage(metaTags.getImage());
			document.setTitle(metaTags.getTitle());
			document.setDescription(metaTags.getDescription());
			document.setContent(con);
			return repository.save(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
