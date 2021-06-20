package com.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bean.User;
import com.dao.IUserRepository;
import com.service.IUserService;
import com.service.UserServiceImpl;

@SpringBootTest
public class UserServicetTest {

	@Autowired
	IUserService iuserservice;
	
	@MockBean
	IUserRepository urepo;
	
	@Autowired
	UserServiceImpl uimpl;
	
	@Test
	void testaddUser()
	{
		User u1=new User();
		u1.setid(100);
		u1.setUserId("Anief123");
		u1.setRole("Admin");
		//u1.setPassword("Aniefshaik12");
		
		
		Mockito.when(urepo.save(u1)).thenReturn(u1);
		User response=iuserservice.addUser(u1);
		assertThat(response.getid()).isEqualTo(100);
		assertThat(response.getUserId()).isEqualTo("Anief123");
		assertThat(response.getRole()).isEqualTo("Admin");
		//assertThat(response.getPassword()).isEqualTo("Aniefshaik123");
			}
	
	
	
	@Test
	void testgetUser()
	{
		User u1=new User();
		u1.setid(100);
		u1.setUserId("Anief123");
		u1.setRole("Admin");
		
		User u2=new User();
		u1.setid(101);
		u1.setUserId("Sanju123");
		u1.setRole("customer");
		
		List<User> ls=new ArrayList<>();
		ls.add(u1);
		ls.add(u2);
		Mockito.when(urepo.findAll()).thenReturn(ls);
		assertThat(uimpl.getUser()).isEqualTo(ls);
	}
	
	
	@Test
	void testremoveUser()
	{
		
		User u1=new User();
		u1.setid(100);
		u1.setUserId("Anief123");
		u1.setRole("Admin");
		
Optional<User> u2=Optional.of(u1);
		
		Mockito.when(urepo.findById(100)).thenReturn(u2);
		Mockito.when(urepo.existsById(u1.getid())).thenReturn(false);
		assertFalse(urepo.existsById(u1.getid()));
	}
	
}
