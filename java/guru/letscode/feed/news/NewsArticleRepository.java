package guru.letscode.feed.news;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewsArticleRepository extends MongoRepository<NewsArticle, Long>, NewsArticleCustomeRepository {

}
