package org.npu.movieDhamaka;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.npu.movieDhamaka.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getPersonList(ModelMap model) {

		// Client
		RestTemplate restTemplate = new RestTemplate();
		// localhost:8080/movieDhamaka/webservices/movies
		String fooResourceUrl = "http://localhost:8080/movieDhamaka/webservices/movies";
		// "localhost:8080/movieDhamaka/webservices/movies";
		ResponseEntity<Movie[]> response = restTemplate.getForEntity(fooResourceUrl, Movie[].class);

		List<Movie> list = Arrays.asList(response.getBody());

		System.out.println("List retireved using restTemplate" + list.size());
		model.addAttribute("movieList", list);
		// int count = movieService.listMovie().size();
		// System.out.println("Count of the movies found: " + count );
		// model.addAttribute("movieList", movieService.listMovie());
		return "home";
	}
	
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String getMovie(ModelMap model) {

		// Client
		RestTemplate restTemplate = new RestTemplate();
		// localhost:8080/movieDhamaka/webservices/movies
		String fooResourceUrl = "http://localhost:8080/movieDhamaka/webservices/movies";
		// "localhost:8080/movieDhamaka/webservices/movies";
		ResponseEntity<Movie[]> response = restTemplate.getForEntity(fooResourceUrl, Movie[].class);

		List<Movie> list = Arrays.asList(response.getBody());

		System.out.println("List retireved using restTemplate" + list.size());
		model.addAttribute("movieList", list);
		
		// int count = movieService.listMovie().size();
		// System.out.println("Count of the movies found: " + count );
		// model.addAttribute("movieList", movieService.listMovie());
		return "home";
	}
	
}
