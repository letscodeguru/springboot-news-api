package guru.letscode.feed.schedulers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import guru.letscode.feed.FeedContent;
import guru.letscode.feed.news.NewsArticle;
import guru.letscode.feed.news.NewsArticleRepository;

@Component
public class FeedContentScheduleTask {/*

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	NewsArticleRepository newsArticleRepository;

	@Scheduled(fixedRate = 10000)
	public void fetchNewsContent() {
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_1).build();

		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
		List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();

		logger.debug("Number o messages recived: "+messages.size());
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<NewsArticle>>() {
		}.getType();
		for (Message message : messages) {
			List<NewsArticle> articles = gson.fromJson(message.getBody(), listType);

			articles.forEach(article -> {
				final String url = article.getUrl();
				logger.debug("Fetching feeds for url: " + url);
				guru.letscode.feed.FeedFetcher fetcher = new guru.letscode.feed.FeedFetcher();
				Document doc = null;
				try {
					doc = fetcher.fetch(article.getUrl());
					FeedContent content = new FeedContent();
					String con = content.getFeedContent(doc);
					boolean status= newsArticleRepository.update(article.getUrl(), con);				
					logger.info("content update status :  "+status);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}

			});
		}

	}*/
}
