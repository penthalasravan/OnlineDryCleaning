package com.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.IUserRepository;
import com.dao.QueryClassPersisitContext;
import com.validators.InputValidator;

@Service

public class UserServiceImpl implements IUserService {

	List<User> le;
	@Autowired
	IUserRepository userRepository;
	InputValidator validate;
	@Autowired
	QueryClassPersisitContext qcp;
	
	public List<User> getUser()
	{
		le=new ArrayList<>();
		le=userRepository.findAll();
		return le;
	}
	public User addUser(User ls){
		User e1=userRepository.save(ls);
		return e1;
	}

	public User removeUser(User user) {
		
			User user2 = qcp.findByUserName(user.getUserId());
			userRepository.delete(user2);
			return user2;
		}
	@Override
	public HttpStatus validateUser(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}

