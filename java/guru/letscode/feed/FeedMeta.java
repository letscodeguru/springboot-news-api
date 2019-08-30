package guru.letscode.feed;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FeedMeta {

	private String url;
	private String image;
	private String description;
	private String title;
	@Override
	public String toString() {
		return "FeedMeta [url=" + url + ", image=" + image + ", description=" + description + ", title=" + title + "]";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
