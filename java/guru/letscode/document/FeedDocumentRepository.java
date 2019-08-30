package guru.letscode.document;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedDocumentRepository extends MongoRepository<FeedDocument, Long>{

}
