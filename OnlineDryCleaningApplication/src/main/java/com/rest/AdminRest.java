package com.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.IAdminService;

@RestController
public class AdminRest {

	@Autowired
	IAdminService adminService;

	@Autowired
	LoginRest logCon;

	@PostMapping("/registeradmin/{username}/{password}")
	public HttpStatus registerAdmin(@PathVariable String username, @PathVariable String password) throws Exception {
		try {
			adminService.registerAdmin(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return HttpStatus.CREATED;
		
	}

}

