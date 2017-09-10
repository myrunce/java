package com.myron.BrightIdeas.models;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


import javax.persistence.JoinColumn;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue
    private Long id;
    @Email
    private String username;
    @Size(min=1)
    private String name;
    @Size(min=1)
    private String alias;
    @Size(min=10)
    private String password;
    @Transient
    private String passwordConfirmation;
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "idea_id")
    )
    private List<Idea> ideasLiked;
    
    @OneToMany(mappedBy="author", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Idea> ideas;
    
    public User() {
    }
    
    public User(String email, String name, String alias, String password) {
    	this.username = email;
    	this.name = name;
    	this.alias = alias;
    	this.password = password;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public List<Idea> getIdeasLiked() {
		return ideasLiked;
	}

	public void setIdeasLiked(List<Idea> ideasLiked) {
		this.ideasLiked = ideasLiked;
	}

	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

	@PrePersist
    protected void onCreate(){
    this.setCreatedAt(new Date());
    }

    @PreUpdate
    protected void onUpdate(){
    this.setUpdatedAt(new Date());
    }
}
