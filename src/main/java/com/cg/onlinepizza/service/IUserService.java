package com.cg.onlinepizza.service;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.repository.IUserRepository;
import com.cg.onlinepizza.dto.User;
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
			user.setLoggedIn(true);
			iur.save(user);
			return "success";
		}else {
			return "failure"; 
		}
	}

	public String signOut(User user) {		
		Optional<User> u= iur.findById(user.getUserId());
		if(u.isPresent()) {
			User obj= u.get();
			if(obj.isLoggedIn()==true) {
				obj.setLoggedIn(false);
				iur.save(obj);
				return "success";
			}
			else {
				return "failure";
			}
		}
		return "failure";
		
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
