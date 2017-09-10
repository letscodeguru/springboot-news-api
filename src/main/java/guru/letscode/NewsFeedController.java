package guru.letscode;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import guru.letscode.feed.Feed;
import guru.letscode.feed.news.NewsArticle;
import guru.letscode.feed.news.NewsArticleRepository;

@RestController
@RequestMapping("/api")
public class NewsFeedController {

	@Autowired
	private NewsArticleRepository articleRepository;

	@CrossOrigin
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public Page<NewsArticle> getFeed(@RequestParam(name = "page") int page, @RequestParam(name = "size") int pageSize) {
		
		Sort sort = new Sort(new Order(Direction.DESC, NewsArticle.KEY_PUBLISHED_AT));
		PageRequest pageRequest = new PageRequest(page, pageSize,sort);
		return articleRepository.findAll(pageRequest);
	}

	@CrossOrigin
	@RequestMapping(value = "/news/search", method = RequestMethod.POST)
	public List<NewsArticle> searchFeed(@RequestBody NewsArticle feed) throws IOException {
	
		return articleRepository.search(feed);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/news/textsearch", method = RequestMethod.GET)
	public List<NewsArticle> textSearchFeed(@RequestParam(name="name", required=true) String text) throws IOException {
		return articleRepository.searchByText(text);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public List<String> getCategories() throws IOException {
		return articleRepository.getCategories();
	}
}
