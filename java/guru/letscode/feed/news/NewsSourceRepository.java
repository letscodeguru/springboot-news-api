package guru.letscode.feed.news;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsSourceRepository  extends MongoRepository<NewsSources, Long> {

}
