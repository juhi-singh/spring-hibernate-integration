package com.mobicule.pojo;

public class Movie {
	
	private int movieId;
	private String movieName;
	private int seatAvailable;

	private int price;
	private int theaterId;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	
	@Override
	public String toString() {
		return movieName +" || \t " +seatAvailable +" || \t " +price ;
	}
	
	
	
	
	
	

}
