package com.SpringBoot.Restful_web.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users=new ArrayList<User>();
	private static int userCount=0;
	static {
		users.add(new User(userCount++,"Adam",LocalDate.now()));
		users.add(new User(userCount++,"Eve",LocalDate.now()));
		users.add(new User(userCount++,"Marco",LocalDate.now()));
		users.add(new User(userCount++,"Peta",LocalDate.now()));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User findById(int id) {
		
	User resUser= 	users.stream()
			.filter(user -> user.getId().equals(id))
			.findFirst()
			.orElse(null);
		
	return resUser;
	}

	public User save(User user) {
		
		user.setId(userCount++);
		users.add(user);
		return user;
	}
	
	
	
	public void deleteById(int id) {
		
		User resUser= 	users.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst()
				.orElse(null);
			
		if(resUser!=null) {
			users.remove(resUser);
		}
		
		}
}
