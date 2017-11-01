package com.mobicule.pojo;

import java.util.Set;

public class Theater {
	private int theaterId;
	private String theaterName;
	private String cityName;
	private Set children;

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return theaterName;
	}
	

	
	

}
