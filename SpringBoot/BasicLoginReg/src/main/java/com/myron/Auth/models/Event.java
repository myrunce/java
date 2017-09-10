package com.myron.Auth.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Future
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	@NotNull
	private String Location;
	
	@NotNull
	private String State;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="Event")
	private List<Message> messages;
}
