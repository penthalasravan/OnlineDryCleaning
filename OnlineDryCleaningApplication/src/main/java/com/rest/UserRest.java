package com.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.User;
import com.service.IUserService;
import com.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserRest {
	@Autowired
	UserServiceImpl userService;

	@Autowired
	IUserService userService1;
	
	@Autowired
	LoginRest logCon;

	@GetMapping(path="/getUser")
	public ResponseEntity<List<User>> getUser()
	{
		List<User> le=userService.getUser();
		
		ResponseEntity re=new ResponseEntity<List<User>>(le,HttpStatus.OK);
		return re;
	}
	
	//@PostMapping("/validate/{username}/{password}")
	public HttpStatus validateUser(@PathVariable String username, @PathVariable String password) {
		try {
			return userService1.validateUser(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping(value="/adduser")
	public User addUser(@RequestBody User user) {
		
		User e1=userService.addUser(user);
	
	ResponseEntity<User> re=new ResponseEntity<User>(e1,HttpStatus.OK);
	return e1;
	}

	@DeleteMapping("/removeuser")
	public User removeUser(@RequestBody User user){
		User user2 = userService.removeUser(user);
		return user2;
	}

}
