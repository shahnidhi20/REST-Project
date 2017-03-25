package org.npu.movieDhamaka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.npu.movieDhamaka.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MovieService {
	
	//@Autowired
	//private MongoTemplate mongoTemplate;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "moviedetails";
	
	public void addMovie(Movie movie) {
		if (!mongoTemplate.collectionExists(Movie.class)) {
			//mongoTemplate.createCollection(Movie.class);
		}		
		movie.setId(UUID.randomUUID().toString());
		
		//Set the actors: 
		//List<String> actcast = new ArrayList<String>();
		//actcast.add("Tom Cruise");
		//actcast.add("Angelina");
		//movie.setStarCast(actcast);
		
		mongoTemplate.insert(movie, COLLECTION_NAME);
		System.out.println("saved movie id:"+movie.getId());
	//	mongoTemplate.remove(movie, COLLECTION_NAME);
		
	}
	
	public List<Movie> listMovie() {
		try{
			return	mongoTemplate.findAll(Movie.class, COLLECTION_NAME);
		}catch(Exception ex){
			System.out.println(ex);
			return null;
		}
		
	}
	
	public void deleteMovie(String movieId) {
		System.out.println("Deleting the movie" +movieId ) ;
		
		mongoTemplate.remove(new Query(Criteria.where("id").is("movieId")), Movie.class);
		//mongoTemplate.remove(movie, COLLECTION_NAME);
		System.out.println(mongoTemplate.getDb().getLastError());
	}
	
	
	public void updateMovie(Movie movie) {
		mongoTemplate.insert(movie, COLLECTION_NAME);		
	}
	
	public Movie findMovie(String name) {
		Query query = new Query();
		System.out.println("Finding the movie whose name is" + name);
		query.addCriteria(Criteria.where("name").is(name));
		
		System.out.println(query.toString());
		Movie mo = new Movie();
		mo.setName("Mission Impossible");
		mo.setRating(3);
		
		//Movie mo = mongoTemplate.findOne(Query.query(Criteria.where("name").is("Mission Impossible")), Movie.class);
		/*List<Movie> movies = mongoTemplate.find(query, Movie.class);
		System.out.println("Found movies " + movies.size());*/
		return mo;
		
	}

}
