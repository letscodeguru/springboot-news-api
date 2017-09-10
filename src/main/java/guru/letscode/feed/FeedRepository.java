package guru.letscode.feed;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends MongoRepository<Feed, Long>, FeedCustomeRepository {

	   Feed findFirstByUrl(String url);
}
