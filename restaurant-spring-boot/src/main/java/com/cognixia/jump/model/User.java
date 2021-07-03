package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7150865904809734848L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;

	@NotNull
	@Column(name = "username", unique = true)
	private String username;
	
	@NotNull
	@Column(name = "password", unique = true)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;

	
	
	public User() {
		this(-1L, "n/a", "n/a", new ArrayList<>());
	}

	public User(Long user_id, String username, String password, List<Review> reviews) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.reviews = reviews;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		reviews.forEach(a -> addReview(a));
	}
	
	public void addReview(Review review) {
		review.setUser(this);
		this.reviews.add(review);
	}


	
	
}
