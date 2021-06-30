package com.cognixia.jump.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Range;

@Entity
public class Review implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5282162034953485370L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long review_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	
	@Column
	private String comment;
	
	@Column
	private Date date;
	
	@Range(min = 0, max = 5)
	@Column
	private Double rating;

	public Review() {
		this(-1L, new User(), new Restaurant(), "n/a", -1);
	}
	
	public Review(Long review_id, User user, Restaurant restaurant, String comment,
			@Range(min = 0, max = 5) double rating) {
		super();
		this.review_id = review_id;
		this.user = user;
		this.restaurant = restaurant;
		this.comment = comment;
		this.date = new Date(System.currentTimeMillis());
		this.rating = rating;
	}

	public Long getReview_id() {
		return review_id;
	}

	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	
	
	
	

}
