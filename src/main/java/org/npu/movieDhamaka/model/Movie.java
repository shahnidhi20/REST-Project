package org.npu.movieDhamaka.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@XmlRootElement
public class Movie {
	
	@Id
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String director;
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	private int rating;
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	private int year;
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	private String storyLine;
	private List<String> starCast = new ArrayList<String>();

	public String getStoryLine() {
		return storyLine;
	}

	public void setStoryLine(String storyLine) {
		this.storyLine = storyLine;
	}

	public List<String> getStarCast() {
		return starCast;
	}

	public void setStarCast(List<String> starCast) {
		this.starCast = starCast;
	}
	

	

	
	
	
	

}
