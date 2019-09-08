package guru.letscode.feed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class FeedRepositoryImpl implements FeedCustomeRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Feed> search(Feed feed) {
		Query query = new Query(Criteria.where("url").is(feed.getUrl()));

		return mongoTemplate.find(query, Feed.class);
	}

}
