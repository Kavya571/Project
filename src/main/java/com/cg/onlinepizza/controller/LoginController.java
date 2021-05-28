package com.cg.onlinepizza.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.dto.User;
import com.cg.onlinepizza.exceptions.UserNotFoundException;
import com.cg.onlinepizza.service.IUserService;
@RestController
public class LoginController {
	@Autowired
	IUserService ius;
	@PostMapping("/signin")
	private String usersignin(@RequestBody User user) throws UserNotFoundException {
		return ius.signin(user);
	}
	@PostMapping("/signout")
	private String signout(@RequestBody User user) {
		return ius.signOut(user);
	}
	@PostMapping("/User")
	private int SaveUser(@RequestBody User user) {
		ius.addNewUser(user);
		return user.getUserId();
	}
	@PostMapping("/forgot/{id}/{old}/{new1}")
	private boolean forgotPassword(@PathVariable("id") int id,@PathVariable("old") String old, @PathVariable("new1") String new1) throws UserNotFoundException {
		return ius.forgotPassword(id, old,new1);
		
	}
}