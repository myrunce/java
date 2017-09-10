package com.myron.Lookify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Song {
	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	@Size(min=5)
	private String name;
	
	@Column
	@Size(min=5)
	private String artist;
	
	@Column
	private int rating;
	
	public Song() {
		
	}
	
	public Song(String name, String artist, int rating) {
		this.name = name;
		this.artist = artist;
		this.rating = rating;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
