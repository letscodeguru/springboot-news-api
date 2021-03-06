package guru.letscode.feed.schedulers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import guru.letscode.feed.news.NewsArticle;
import guru.letscode.feed.news.NewsArticleRepository;
import guru.letscode.feed.news.NewsFeed;
import guru.letscode.feed.news.NewsSourceRepository;
import guru.letscode.feed.news.NewsSources;

@Component
public class NewsArticleFeedScheduleTask {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	NewsSourceRepository newsSourceRepository;

	@Autowired
	NewsArticleRepository newsArticleRepository;

	@Value("${newsapi.article.url}")
	private String newsArticleApi;


	@Scheduled(fixedRate = 60000)
	public void fetchCurrentNews() {
		
		List<NewsSources> newsSources = newsSourceRepository.findAll();
		for (NewsSources source : newsSources) {
			final String url = newsArticleApi + source.getId();
			HttpClient httpclient = HttpClientBuilder.create().build();
			HttpGet httpGet = new HttpGet(url);
			try {
				HttpResponse response = httpclient.execute(httpGet);
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				Gson gson = new Gson();
				NewsFeed feed = gson.fromJson(rd, NewsFeed.class);
				feed.getArticles().forEach(article -> {
					article.setCategory(source.getCategory());
					article.setName(source.getName());
				});
				List<NewsArticle> insertedArticle = newsArticleRepository.insert(feed.getArticles());

				//sqs.sendMessage(new SendMessageRequest(queueUrl, gson.toJson(insertedArticle)));

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

}
