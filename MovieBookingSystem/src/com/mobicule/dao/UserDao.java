package com.mobicule.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mobicule.pojo.User;

public class UserDao {
	
	HibernateTemplate template; 
	User user;
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	public void saveUser(User e){  
	    template.save(e);  
	}  

	 
	public void updateUser(User e){  
	    template.update(e);  
	}  

	public void deleteUser(User e){  
	    template.delete(e);  
	}  
	 
	public User getByName(String name){  
		User e=(User)template.get(User.class,name);  
	    return e;  
	} 
	
	public List<User> getUser(){  
	    List<User> list=new ArrayList<User>();  
	    list=template.loadAll(User.class);  
	    return list;  
	} 
	
	public boolean verifyCredentials(String userName, String password) {

		List<User> user = getUser();
		Iterator<User> iterator = user.iterator();
		boolean userStatus = false;

		while (iterator.hasNext()) {
			User tempUser = iterator.next();

			if (tempUser.getUserName().equals(userName) && tempUser.getPassword().equals(password)) {
				userStatus = true;
			}
		}

		return userStatus;

	}
	

}
