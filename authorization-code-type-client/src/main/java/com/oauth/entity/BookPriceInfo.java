package com.oauth.entity;

public class BookPriceInfo {
	private Integer bookId;
	 private double price;
	 private double offer; 

	
	public BookPriceInfo() {}
	
	public BookPriceInfo(Integer bookId, double offer, double price) {
		super();
		this.bookId = bookId;
		this.offer = offer;
		this.price = price;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return bookId + ", " + offer + ", " + price;
	}
	
	
}
