package guru.letscode.feed.news;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

public class NewsSourceFeed {

	private String status;
	private List<NewsSources> sources;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<NewsSources> getSources() {
		return sources;
	}
	public void setSources(List<NewsSources> sources) {
		this.sources = sources;
	}
	
}
