package guru.letscode.document;

import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "docstore")
public class FeedDocument {

	public static final String KEY_AUTHOR = "author";
	public static final String KEY_CATEGORY = "category";
	public static final String KEY_CONTENT = "content";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_NAME = "name";
	public static final String KEY_PUBLISHED_AT = "publishedAt";
	public static final String KEY_TITLE = "title";
	public static final String KEY_URL = "url";
	public static final String KEY_URL_TO_IMAGE = "urlToImage";

	private String author;
	private String category;
	@TextIndexed(weight = 5)
	private String content;
	@TextIndexed(weight = 10)
	private String description;
	private String name;
	private Map<String, String> properties;
	private String publishedAt;
	@TextIndexed(weight = 10)
	private String title;
	@Indexed(unique = true)
	private String url;

	private String urlToImage;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	private String version;

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
}
