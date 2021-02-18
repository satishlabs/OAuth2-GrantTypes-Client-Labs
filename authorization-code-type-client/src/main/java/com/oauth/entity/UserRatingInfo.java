package com.oauth.entity;

public class UserRatingInfo {
	private String userId;
	private Integer bookId;
	private double rating;
	private String review;

	public UserRatingInfo() {}
	public UserRatingInfo(String userId, Integer bookId, double rating, String review) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.rating = rating;
		this.review = review;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return userId + ", " + bookId + ", " + rating + ", " + review;
	}


}
