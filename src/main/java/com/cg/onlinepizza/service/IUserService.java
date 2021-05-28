package com.cg.onlinepizza.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.repository.IUserRepository;
import com.cg.onlinepizza.dto.User;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.exceptions.UserNotFoundException;

@Service
public class IUserService {
	@Autowired
	IUserRepository iur;

	public User addNewUser(User user) {
		return iur.save(user);
	}

	public String signin(User user) throws UserNotFoundException {
		if (iur.existsById(user.getUserId()) && user.isLoggedIn() == false) {
			iur.setLoggedIn(true,user.getUserId());
			user.setLoggedIn(true);
			return "success";
		}else {
			return "failure"; 
		}
	}

	public String signOut(User user) {
		System.out.println(user.getUserId()+" "+user.isLoggedIn()+" "+iur.existsById(user.getUserId()));
		if (iur.existsById(user.getUserId()) && user.isLoggedIn() == true) {
			iur.setLoggedIn(false,user.getUserId());
			user.setLoggedIn(false);
			return "success";
		}else {
			return "failure"; 
		}
	}

	public boolean forgotPassword(int id, String oldPassword, String newPassword) throws UserNotFoundException {
		try {
			if (iur.existsById(id)) {
				if (oldPassword.equals(newPassword)) {
					return false;
				} else {
					iur.replace(id,oldPassword, newPassword);
					return true;
				}
			}
			else {
				throw new UserNotFoundException(); 
			}
		} catch (Exception e) {
			throw new UserNotFoundException("User not Exists");
		}
	}
}
