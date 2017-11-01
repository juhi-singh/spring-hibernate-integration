package com.mobicule.pojo;

import java.util.Set;

public class City {

	
	private String cityName;
	private Set children;

	

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
		return cityName ;
	}
	
	

}
