package guru.letscode.feed;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FeedContent {

	public String getFeedContent(Document documents) {

		StringBuilder feedContentBuilder = new StringBuilder();

		Elements paraElements = documents.getElementsByTag("p");
		
		for(Element element : paraElements){
			feedContentBuilder.append(element.ownText());
		}
		
		return feedContentBuilder.toString();
	}
}
