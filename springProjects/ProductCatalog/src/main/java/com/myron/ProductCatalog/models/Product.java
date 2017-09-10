package com.myron.ProductCatalog.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Long id;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Desc")
	private String desc;
	
	@JsonProperty("Price")
	private float price;
	
	@JsonProperty("TimeStamp")
	private Date timeStamp;
	
	public Product() {
		
	}
	
	public Product(String name, String desc, float price, Date timeStamp) {
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.timeStamp = timeStamp;
	}
	
	@JsonAnyGetter
	public String getName() {
		return name;
	}
	@JsonAnySetter
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonAnyGetter
	public String getDesc() {
		return desc;
	}
	@JsonAnySetter
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@JsonAnyGetter
	public float getPrice() {
		return price;
	}
	@JsonAnySetter
	public void setPrice(float price) {
		this.price = price;
	}
	@JsonAnyGetter
	public Date getTimeStamp() {
		return timeStamp;
	}
	@JsonAnySetter
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	@JsonAnyGetter
	public Long getId() {
		return id;
	}
	@JsonAnySetter
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
