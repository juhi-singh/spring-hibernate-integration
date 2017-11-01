package com.mobicule.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mobicule.pojo.City;
import com.mobicule.pojo.Theater;
import com.mobicule.pojo.User;

public class TheaterDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void addTheater(Theater t) {
		template.save(t);
	}

	public void deleteTheater(Theater t) {
		template.delete(t);
	}

	public List<Theater> getTheater(String cityName) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Theater.class);
		criteria.add(Restrictions.eq("cityName", cityName));
		List<Theater> theater = template.findByCriteria(criteria);

		return theater;
	}

	public int getTheaterId(String theaterName, String cityName) {

		List<Theater> cityList = template.loadAll(Theater.class);
		Iterator<Theater> itr = cityList.iterator();

		while (itr.hasNext()) {
			Theater p = (Theater) itr.next();
			if (p.getTheaterName().equals(theaterName) && p.getCityName().equals(cityName)) {
				return p.getTheaterId();
			}
		}
		return 0;
	}

}
