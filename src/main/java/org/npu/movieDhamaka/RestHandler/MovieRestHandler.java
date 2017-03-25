package org.npu.movieDhamaka.RestHandler;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.npu.movieDhamaka.model.Movie;
import org.npu.movieDhamaka.service.CommentService;
import org.npu.movieDhamaka.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Path("/")
public class MovieRestHandler {
	
	//MovieService service = new MovieService();
	
	@Autowired
	@Qualifier("movieService")
	private MovieService service;
	
	@Autowired
	@Qualifier("commentService")
	private CommentService cService;
	
	@GET
	@Path("/movies")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Movie> getAllMovies(){
		
		return service.listMovie() ;
	}
	
	
	@GET
	@Path("/movies/{name}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Movie getMovie(@PathParam("name") String name){
		
		
		
		return service.findMovie(name);
	}
	
	
	@POST
	@Path("/movies/movie")
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
	
	@PUT
	@Path("{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateMovie(Movie mo){
		try{
			if(mo!=null){
			System.out.println(mo.getName());
			System.out.println(mo.getYear());
			service.updateMovie(mo);
			}else{
				System.out.println("Mo is null");
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return Response.ok().entity(mo).build();
		
	}
	
	
	@DELETE
	@Path("{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response deleteMovie(@PathParam ("movieId") String movieId){
		service.deleteMovie(movieId);
		return Response.ok().build();
		
	}
	

}
