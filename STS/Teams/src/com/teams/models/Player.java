package com.teams.models;

public class Player {
	private String first;
	private String last;
	private int age;
	
	public Player() {
		
	}
	
	public Player(String first, String last, int age) {
		this.first = first;
		this.last = last;
		this.age = age;
	}
	
	public String getFirst() {
		return this.first;
	}
	
	public String getLast() {
		return this.last;
	}
	
	public int getAge() {
		return this.age;
	}
}