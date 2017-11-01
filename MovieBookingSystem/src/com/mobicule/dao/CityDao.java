package com.mobicule.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mobicule.pojo.City;
import com.mobicule.pojo.Theater;
import com.mobicule.pojo.User;

public class CityDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void addCity(City c) {
		template.save(c);
	}

	public void deleteCity(City c) {
		template.delete(c);
	}

	public List<City> getCity() {
		List<City> cityList=new ArrayList<City>(); 
		 cityList = template.loadAll(City.class);

		return cityList;
	}
	
	

}
