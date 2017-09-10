package guru.letscode;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import guru.letscode.feed.Feed;
import guru.letscode.feed.FeedContent;
import guru.letscode.feed.FeedFetcher;
import guru.letscode.feed.FeedMetaProperties;
import guru.letscode.feed.FeedMetaTags;
import guru.letscode.feed.FeedRepository;

@RestController
@RequestMapping("/api")
public class FeedController {

	@Autowired
	private FeedRepository feedRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	public FeedController() {
		// TODO Auto-generated constructor stub
	}

	@CrossOrigin
	@RequestMapping(value = "/feed", method = RequestMethod.GET)
	public List<Feed> getFeed(@RequestParam(value = "name", defaultValue = "World") String name) {

		return feedRepository.findAll();
	}

	@CrossOrigin
	@RequestMapping(value = "/feed", method = RequestMethod.POST)
	public Feed postFeed(@RequestBody Feed feed) throws IOException {
		String url = feed.getUrl();
		FeedFetcher fetcher = new FeedFetcher();
		Document document = fetcher.fetch(url);
		Elements metaElements = document.getElementsByTag("meta");
		FeedMetaTags metaTags = new FeedMetaTags(metaElements);
		FeedMetaProperties feedproperties = new FeedMetaProperties();
		FeedContent content = new FeedContent();
		Feed feed1 = new Feed();
		feed1.setUrl(url);
		feed1.setFeedMetaProperties(feedproperties.convertMetaTagsToMetaProperties(metaTags));
		feed1.setContent(content.getFeedContent(document));
		feedRepository.insert(feed1);
		return feed1;
	}

	@CrossOrigin
	@RequestMapping(value = "/feed/search", method = RequestMethod.POST)
	public List<Feed> searchFeed(@RequestBody Feed feed) throws IOException {
		return feedRepository.search(feed);
	}
	

}
