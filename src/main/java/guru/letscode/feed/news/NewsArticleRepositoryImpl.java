package guru.letscode.feed.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.MongoCollectionUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.data.mongodb.core.query.Update;

public class NewsArticleRepositoryImpl implements NewsArticleCustomeRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<NewsArticle> search(NewsArticle feed) {
		Query query = new Query();

		if (null != feed.getUrl()) {
			query.addCriteria(Criteria.where(NewsArticle.KEY_URL).is(feed.getUrl()));
		}

		if (null != feed.getCategory()) {
			query.addCriteria(Criteria.where(NewsArticle.KEY_CATEGORY).is(feed.getCategory()));
		}

		if (null != feed.getName()) {
			query.addCriteria(Criteria.where(NewsArticle.KEY_NAME).is(feed.getName()));
		}

		return mongoTemplate.find(query, NewsArticle.class);
	}

	@Override
	public boolean update(String url, String content) {
		Query query = new Query();
		query.addCriteria(Criteria.where(NewsArticle.KEY_URL).is(url));
		Update update = Update.update(NewsArticle.KEY_CONTENT, content);
		mongoTemplate.updateFirst(query, update, MongoCollectionUtils.getPreferredCollectionName(NewsArticle.class));
		return false;
	}

	@Override
	public List<NewsArticle> searchByText(String searchText) {
		// TODO Auto-generated method stub
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(searchText);
		Query query = TextQuery.queryText(criteria).sortByScore().with(new PageRequest(0, 5));
		return mongoTemplate.find(query, NewsArticle.class);
	}
	
	@Override
	public List<String> getCategories() {
		// TODO Auto-generated method stub
		return null;//mongoTemplate.getCollection("newsarticles").distinct(NewsArticle.KEY_CATEGORY);
	}
}
