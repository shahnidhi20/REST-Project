package org.npu.movieDhamaka.controller;

import java.util.Arrays;
import java.util.List;

import org.npu.movieDhamaka.model.Comment;
import org.npu.movieDhamaka.model.Movie;
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
public class CommentController {
	
	@RequestMapping(value = "comments/comment", method = RequestMethod.GET)
	public String getCommentsList(ModelMap model) {

		// Client
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new TestHandler());
		// localhost:8080/movieDhamaka/webservices/movies
		String fooResourceUrl = "http://localhost:8080/movieDhamaka/webservices/comments";
		// "localhost:8080/movieDhamaka/webservices/movies";
		ResponseEntity<Comment[]> response = restTemplate.getForEntity(fooResourceUrl, Comment[].class);

		List<Comment> list = Arrays.asList(response.getBody());

		System.out.println("List retireved using restTemplate" + list.size());
		model.addAttribute("commentList", list);
		// int count = movieService.listMovie().size();
		 //System.out.println("Count of the movies found: " + count );
		 //model.addAttribute("movieList", movieService.listMovie());
		return "detail";
	}
	
	
	@RequestMapping(value = "/comment/save", method = RequestMethod.POST)
	public View saveComment(@ModelAttribute Movie movie, ModelMap model) {
	

			// POST
			try {

				RestTemplate restTemplate = new RestTemplate();
		
				System.out.println("Calling the POst service");
			
				String fooResourceUrl = "http://localhost:8080/movieDhamaka/webservices/comments/comment";

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);

				restTemplate.setErrorHandler(new TestHandler());
				HttpEntity entity = new HttpEntity(movie, headers);

				ResponseEntity<Comment> response = restTemplate.exchange(fooResourceUrl, HttpMethod.POST, entity,
						Comment.class);

				Comment cmt = response.getBody();
				
				//movieService.addMovie(movie);

			} catch (Exception ex) {
				System.out.println("Error in post: " + ex.getMessage());
			}
		
		return new RedirectView("/movieDhamaka/detail");
	} 
}
