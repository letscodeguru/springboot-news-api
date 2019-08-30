package guru.letscode.feed;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FeedFetcher {

	public Document fetch(final String url) throws IOException {
		Document document = Jsoup.connect(url).timeout(0).get();
		return document;
	}
		
}
