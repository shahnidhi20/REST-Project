package org.npu.movieDhamaka.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public String getPersonList(ModelMap model) {

		// Client
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new TestHandler());
		// localhost:8080/movieDhamaka/webservices/movies
		String fooResourceUrl = "http://localhost:8080/movieDhamaka/webservices/movies";
		// "localhost:8080/movieDhamaka/webservices/movies";
		ResponseEntity<Movie[]> response = restTemplate.getForEntity(fooResourceUrl, Movie[].class);

		List<Movie> list = Arrays.asList(response.getBody());

		System.out.println("List retireved using restTemplate" + list.size());
		model.addAttribute("movieList", list);
		// int count = movieService.listMovie().size();
		 //System.out.println("Count of the movies found: " + count );
		 //model.addAttribute("movieList", movieService.listMovie());
		return "output";
	}
	
	@RequestMapping(value="/movie/details",  method=RequestMethod.GET)
	public ModelAndView getMovie(@RequestParam("name") String name) {
	
	    final String uri = "http://localhost:8080/movieDhamaka/webservices/movies/{name}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("name", name);
	     
	    RestTemplate restTemplate = new RestTemplate();
	    Movie movieResult = restTemplate.getForObject(uri, Movie.class, params);
	    //EmployeeVO result = restTemplate.getForObject(uri, EmployeeVO.class, params);
	    
	    ModelAndView result = new ModelAndView("detail", "movie", movieResult);
		return result;
	    
	  
	}

	/*@RequestMapping(value = "/movie/save", method = RequestMethod.POST)
	public View createPerson(@ModelAttribute Movie movie, ModelMap model) {
		if (StringUtils.hasText(movie.getId())) {
			
			
			
			movieService.updateMovie(movie);
		} else {

			// POST
			try {

				//RestTemplate restTemplate = new RestTemplate();
		
				System.out.println("Calling the POst service");
			
				//String fooResourceUrl = "http://localhost:8080/movieDhamaka/webservices/movies/movie";

			//	HttpHeaders headers = new HttpHeaders();
				//headers.setContentType(MediaType.APPLICATION_JSON);

				//restTemplate.setErrorHandler(new TestHandler());
				//HttpEntity entity = new HttpEntity(movie, headers);

				//ResponseEntity<Movie> response = restTemplate.exchange(fooResourceUrl, HttpMethod.POST, entity,
					//	Movie.class);

				//Movie account = response.getBody();
				
				movieService.addMovie(movie);

			} catch (Exception ex) {
				System.out.println("Error in post: " + ex.getMessage());
			}
		}
		return new RedirectView("/movieDhamaka/movie");
	} */

	@RequestMapping(value = "/movie/delete", method = RequestMethod.GET)
	public View deletePerson(@ModelAttribute Movie movie, ModelMap model) {
		System.out.println(movie.getId());

		movieService.deleteMovie(movie.getId());
		return new RedirectView("/movieDhamaka/movie");
	}

}
