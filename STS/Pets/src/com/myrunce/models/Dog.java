package com.myrunce.models;

public class Dog extends Animal implements PetIntereface{
	
	public Dog() {
	}
	
	public Dog(String name, String breed, int weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getBreed() {
		return this.breed;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String showAffection() {
		if (weight < 10) {
			return this.name +  " is SUPER happy to see you!";
		}
		else {
			return this.name + " is so fat but they're still happy to see you.";
		}
	}
	
	
}
