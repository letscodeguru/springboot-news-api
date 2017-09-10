package guru.letscode.feed.news;

import java.util.List;

public interface NewsArticleCustomeRepository {
	public List<NewsArticle> search(NewsArticle feed);
	public boolean update(String url, String content);
	public List<NewsArticle> searchByText(String searchText);
	public List<String> getCategories();
}
