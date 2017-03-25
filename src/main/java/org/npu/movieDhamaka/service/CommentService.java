package org.npu.movieDhamaka.service;

import java.util.UUID;

import org.npu.movieDhamaka.model.Comment;
import org.npu.movieDhamaka.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "comments";
	
	
	public void addComment(Comment cmt) {
		if (!mongoTemplate.collectionExists(Comment.class)) {
			//mongoTemplate.createCollection(Movie.class);
		}		
		cmt.setId(UUID.randomUUID().toString());
		
		
		
		mongoTemplate.insert(cmt, COLLECTION_NAME);
		System.out.println("saved comments id:"+cmt.getId());
	//	mongoTemplate.remove(movie, COLLECTION_NAME);
		
	}

}
