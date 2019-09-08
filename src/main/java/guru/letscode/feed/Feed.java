package guru.letscode.feed;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feeds")
public class Feed {
		
	private String content;
	
	@Indexed(unique = true)
	private String url;
	
	private FeedMeta feedMetaProperties;
	
	public FeedMeta getFeedMetaProperties() {
		return feedMetaProperties;
	}
	public void setFeedMetaProperties(FeedMeta feedMetaProperties) {
		this.feedMetaProperties = feedMetaProperties;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
