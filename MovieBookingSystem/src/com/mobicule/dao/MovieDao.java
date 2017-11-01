package com.mobicule.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mobicule.pojo.Movie;

public class MovieDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void addMovie(Movie t) {
		template.save(t);
	}

	public void deleteMovie(Movie t) {
		template.delete(t);
	}

	public void updateMovie(Movie t) {
		template.update(t);
	}

	@SuppressWarnings("unchecked")
	public List getMovies(int theaterId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Movie.class);
		//DetachedCriteria criteria = DetachedCriteria.forClass(Movie.class);
		criteria.add(Restrictions.eq("theaterId", theaterId));
		List<Movie> moviesList = template.findByCriteria(criteria);

		return moviesList;
	}

	public boolean seatValidation(int movieId, int seat) {

		int seats, remainingSeats;

		DetachedCriteria criteria = DetachedCriteria.forClass(Movie.class);
		criteria.add(Restrictions.eq("movieId", movieId));
		List<Movie> moviesList = template.findByCriteria(criteria);

		Iterator iterator = moviesList.iterator();

		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			Movie movie = (Movie) object;
			seats = movie.getSeatAvailable();

			if (seat > seats) {
				// System.out.println(varifySeats);
				return false;
			}
		}

		return true;
	}

	public int getPrice(int movieId, int seat) {

		int price;
		int seats, remainingSeats;
		int emptySeats = 0;

		DetachedCriteria criteria = DetachedCriteria.forClass(Movie.class);
		criteria.add(Restrictions.eq("movieId", movieId));
		List<Movie> movieList = template.findByCriteria(criteria);

		Iterator iterator = movieList.iterator();

		while (iterator.hasNext()) {

			Object object = (Object) iterator.next();
			Movie movie = (Movie) object;
			price = movie.getPrice();
			seats = movie.getSeatAvailable();

			remainingSeats = seats - seat;
			if (remainingSeats < 0) {
				movie.setSeatAvailable(emptySeats);
				// deleteMovie(movie);
			} else {
				movie.setSeatAvailable(remainingSeats);
				updateMovie(movie);
			}

			return price;

		}

		return 0;

	}
	
	public int getId(String movieName, int theaterId) {

		int id = 0;
		DetachedCriteria criteria = DetachedCriteria.forClass(Movie.class);
		criteria.add(Restrictions.eq("movieName", movieName)).add(Restrictions.eq("theaterId", theaterId));
		// criteria.add(Restrictions.eq("theaterId", theaterId));
		List<Movie> moviesId = template.findByCriteria(criteria);

		Iterator iterator = moviesId.iterator();

		while (iterator.hasNext()) {

			Object object = (Object) iterator.next();
			Movie movie = (Movie) object;
			id = movie.getMovieId();
		}

		return id;
	}
}
