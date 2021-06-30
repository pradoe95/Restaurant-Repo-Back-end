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

import org.hibernate.validator.constraints.Range;

@Entity
public class Restaurant implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2429894143033475478L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long restaruant_id;
	
	@NotNull
	@Column(name = "address")
	private String address;
	
	@Column
	private String description;
	
	@Range(min = 0, max = 5)
	@Column
	private Double average_rating;
	
	@OneToMany(mappedBy = "restaurant")
	private List<Review> reviews;
	

	public Restaurant() {
		this(-1L, "n/a", "n/a", -1.0, new ArrayList<>());
	}
	
	public Restaurant(Long restaruant_id, @NotNull String address, String description,
			@Range(min = 0, max = 5) Double average_rating, List<Review> reviews) {
		super();
		this.restaruant_id = restaruant_id;
		this.address = address;
		this.description = description;
		this.average_rating = average_rating;
		this.reviews = reviews;
	}

	public Long getRestaruant_id() {
		return restaruant_id;
	}

	public void setRestaruant_id(Long restaruant_id) {
		this.restaruant_id = restaruant_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAverage_rating() {
		return average_rating;
	}

	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}

	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		reviews.forEach(a -> addReview(a));
	}
	
	public void addReview(Review review) {
		review.setRestaurant(this);
		this.reviews.add(review);
	}
	
	
}

