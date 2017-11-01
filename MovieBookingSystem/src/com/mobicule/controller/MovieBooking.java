package com.mobicule.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mobicule.dao.CityDao;
import com.mobicule.dao.MovieDao;
import com.mobicule.dao.TheaterDao;
import com.mobicule.dao.UserDao;
import com.mobicule.pojo.City;
import com.mobicule.pojo.Movie;
import com.mobicule.pojo.Theater;
import com.mobicule.pojo.User;

@Controller


public class MovieBooking {
	
	@Autowired
	private UserDao userdao;
	@Autowired
	private CityDao citydao;
	@Autowired
	private TheaterDao theaterdao;
	@Autowired
	private MovieDao moviedao;

	
	
	
	@RequestMapping(value = "/logIn", method = RequestMethod.GET)
	private String LogIn(){
		return "logIn";
		
	}
	
//-------------------------------------- REGISTRATION --------------------------------------------------------//
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	private ModelAndView UserRegistration(HttpServletRequest request){
		ModelAndView model = new ModelAndView("registerForm");
		return model;
	}
	
	@RequestMapping(value = "/registerMesg", method = RequestMethod.GET)
	private ModelAndView UserRegistrationMesg(@ModelAttribute(value="user") User user , HttpServletRequest request,
							@RequestParam("userName") String userName,
							HttpServletResponse response){
		
		userdao.saveUser(user);
		ModelAndView model = new ModelAndView("registerMesg");
		String message = " Registration Successful!";
		model.addObject("message", message);
		model.addObject("userName",userName);
	
		return model;
		
	}
	
//-------------------------------------------- LOGIN --------------------------------------------------------//
	
	@RequestMapping(value = "/successfulLogIn", method = RequestMethod.POST)
	public ModelAndView UserLogIn(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {

		if (userdao.verifyCredentials(userName, password)) {
			String message = userName;
			ModelAndView model = new ModelAndView("successfulLogIn");
			model.addObject("userName",userName);

			return model;
		} else {

			return new ModelAndView("failLogIn");
		}
	}
	
//------------------------------------------ CITY ------------------------------------------------------------//

	@RequestMapping(value = "/selectCity", method = RequestMethod.GET)
	private ModelAndView getCityList(HttpServletRequest request) {

		List<City> cityList = citydao.getCity();
		String userName = request.getParameter("userName");

		ModelAndView model = new ModelAndView("selectCity");
		model.addObject("lists", cityList);
		model.addObject("userName",userName);
		return model;
	}

//-------------------------------------------THEATER ----------------------------------------------------------//
	
	@RequestMapping(value = "/selectTheater", method = RequestMethod.GET)
	private ModelAndView getTheaterList(HttpServletRequest request, HttpServletResponse response) {

		String userName = request.getParameter("userName");
		String cityname = request.getParameter("cityName");
		List<Theater> theaterList = theaterdao.getTheater(cityname);
		ModelAndView model = new ModelAndView("selectTheater");
		model.addObject("lists", theaterList);
		model.addObject("city" ,cityname);
		model.addObject("userName",userName);
		return model;
	}
	
//-------------------------------------------- MOVIE -------------------------------------------------------//
	
	@RequestMapping(value = "/selectMovie", method = RequestMethod.GET)
	private ModelAndView getMoviesList(HttpServletRequest request, HttpServletResponse response) {

		String userName = request.getParameter("userName");
		String cityName = request.getParameter("cityName");

		int theaterId = theaterdao.getTheaterId(request.getParameter("theaterName"), request.getParameter("cityName"));

		List<Movie> moviesList = moviedao.getMovies(theaterId);

		ModelAndView model = new ModelAndView("selectMovie");
		model.addObject("lists", moviesList);
		model.addObject("theaterId", theaterId);
		model.addObject("userName", userName);

		return model;
	}
	
	@RequestMapping(value = "/billPage", method = RequestMethod.GET)
	private ModelAndView generateBill(HttpServletRequest request, @ModelAttribute(value="movie") Movie movie) {
		
		int totalBill;
		String userName = request.getParameter("userName");
		String movieName = request.getParameter("movieName");
		
		
		int theaterId = Integer.parseInt(request.getParameter("theaterId"));
		
		
		int seats = Integer.parseInt(request.getParameter("seatAvailable"));
		
		int movieId = moviedao.getId(movieName,theaterId);
		int price = moviedao.getPrice(movieId,seats);
		totalBill = seats*price;
		
		boolean varifySeats = moviedao.seatValidation(movieId,seats);
		System.out.println(varifySeats);
		
		if(varifySeats==false){
			ModelAndView model = new ModelAndView("errorSeats");
			model.addObject("userName",userName);
			return model;
		}
		else{
		
		ModelAndView model = new ModelAndView("billPage");
		model.addObject("name", movieName);
		model.addObject("seat", seats);
		model.addObject("price", price);
		model.addObject("bill", totalBill);
		model.addObject("userName",userName);
		return model;
		}
		
	}
	
	
	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	private Object LogOut(HttpServletRequest request){
		ModelAndView model = new ModelAndView("logOut");
		String userName = request.getParameter("userName");
		model.addObject("userName",userName);
		
		
		return model;
		
		
	}
	

	
	
}


