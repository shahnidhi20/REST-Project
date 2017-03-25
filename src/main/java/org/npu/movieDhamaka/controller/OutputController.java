package org.npu.movieDhamaka.controller;

import java.util.HashMap;
import java.util.Map;

import org.npu.movieDhamaka.model.Movie;
import org.npu.movieDhamaka.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class OutputController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/movie/save", method = RequestMethod.POST)
	public View createMovie(@ModelAttribute Movie movie, ModelMap model) {
		//Find the movie 
		final String uri = "http://localhost:8080/movieDhamaka/webservices/movies/{name}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("name", movie.getName());
	     
	    RestTemplate restTemplate = new RestTemplate();
	    Movie movieResult = restTemplate.getForObject(uri, Movie.class, params);
			if(movieResult != null){
				movieService.updateMovie(movie);
			}
		
		 else {

			// POST
			try {

				//RestTemplate restTemplate = new RestTemplate();
		
				System.out.println("Calling the POst service");
			
				String fooResourceUrl = "http://localhost:8080/movieDhamaka/webservices/movies/movie";

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);

				restTemplate.setErrorHandler(new TestHandler());
				HttpEntity entity = new HttpEntity(movie, headers);

				ResponseEntity<Movie> response = restTemplate.exchange(fooResourceUrl, HttpMethod.POST, entity,
						Movie.class);

				Movie account = response.getBody();

			} catch (Exception ex) {
				System.out.println("Error in post: " + ex.getMessage());
			}
		}
		return new RedirectView("/movieDhamaka/movie");
	}

}
