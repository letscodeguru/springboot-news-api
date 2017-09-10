package guru.letscode.feed.schedulers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import guru.letscode.feed.news.NewsSourceFeed;
import guru.letscode.feed.news.NewsSourceRepository;

@Component
public class NewsSourceFeedScheduledTasks {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	NewsSourceRepository newsSourceRepository;

	@Value("newsapi.article.url")
	String newsUrl;
	
	@Scheduled(fixedRate = 500000)
	public void fetchNewsSources() {
		System.out.println("The time is now " + dateFormat.format(new Date()));
		final String url = "https://newsapi.org/v1/sources";
		//Todo explore resttemplate
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse response = httpclient.execute(httpGet);
			BufferedReader rd = new BufferedReader(
			        new InputStreamReader(response.getEntity().getContent()));
			Gson gson = new Gson();
			NewsSourceFeed feed = gson.fromJson(rd, NewsSourceFeed.class);
			newsSourceRepository.deleteAll();
			newsSourceRepository.insert(feed.getSources());
			System.out.println(feed.getStatus());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
