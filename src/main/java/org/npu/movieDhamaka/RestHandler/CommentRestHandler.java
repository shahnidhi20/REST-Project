package org.npu.movieDhamaka.RestHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.npu.movieDhamaka.model.Movie;
import org.npu.movieDhamaka.service.CommentService;
import org.npu.movieDhamaka.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Path("/")
public class CommentRestHandler {
	@Autowired
	@Qualifier("movieService")
	private MovieService service;
	
	@Autowired
	@Qualifier("commentService")
	private CommentService cService;
	
	@POST
	@Path("/comments/comment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Movie createMovie(Movie mo){
		try{
			if(mo!=null){
			System.out.println(mo.getName());
			System.out.println(mo.getYear());
			service.addMovie(mo);
			}else{
				System.out.println("Mo is null");
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
		return mo;
		
	}

}
