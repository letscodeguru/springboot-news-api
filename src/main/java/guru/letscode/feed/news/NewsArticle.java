package guru.letscode.feed.news;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "newsarticles")
public class NewsArticle {

	public static final String KEY_URL = "url";
	public static final String KEY_AUTHOR = "author";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_URL_TO_IMAGE = "urlToImage";
	public static final String KEY_PUBLISHED_AT = "publishedAt";
	public static final String KEY_CATEGORY = "category";
	public static final String KEY_TITLE = "title";
	public static final String KEY_NAME = "name";
	public static final String KEY_CONTENT = "content";
	
	
	private String author;
	@Indexed(unique = true)
	private String url;
	@TextIndexed(weight=10)
	private String description;
	private String urlToImage;
	private String publishedAt;
	private String category;	
	@TextIndexed(weight=10)
	private String title;
	private String name;
	
	@TextIndexed(weight=5)
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

}
