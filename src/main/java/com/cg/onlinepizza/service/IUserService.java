package com.cg.onlinepizza.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.repository.IUserRepository;
import com.cg.onlinepizza.util.OnlinePizzaConstants;
import com.cg.onlinepizza.dto.User;
import com.cg.onlinepizza.exceptions.UserNotFoundException;
import com.cg.onlinepizza.exceptions.ValidateUserException;

@Service
public class IUserService {
	@Autowired
	IUserRepository iur;

	public User addNewUser(User user) throws ValidateUserException {
		validateUser(user);
		return iur.save(user);
	}

	private boolean validateUser(User user) throws ValidateUserException {
		if (!user.getUserName().matches("[A-Za-z0-9]+")) {
			throw new ValidateUserException(OnlinePizzaConstants.USERNAME_CANNOT_BE_EMPTY);
		}
		if (!user.getPassword().matches("[A-Za-z0-9]+")) {
			throw new ValidateUserException(OnlinePizzaConstants.PASSWORD_CANNOT_BE_EMPTY);
		}
		return true;
	}

	public String signin(User user) throws UserNotFoundException {
		try {
			if (iur.existsById(user.getUserId()) && user.isLoggedIn() == false
					&& (iur.checkpassword(user.getUserId())).equals(user.getPassword())
					&& (iur.checkusername(user.getUserId())).equals(user.getUserName())) {
				user.setLoggedIn(true);
				iur.save(user);
				return "successfully signed in";
			}
			return "Username or Password is Invalid";
		} catch (Exception e) {
			throw new UserNotFoundException("User not Exists");
		}
	}

	public String signOut(User user) {
		Optional<User> u = iur.findById(user.getUserId());
		if (u.isPresent()) {
			User obj = u.get();
			if (obj.isLoggedIn() == true) {
				obj.setLoggedIn(false);
				iur.save(obj);
				return "successfully signed out";
			} else {
				return "failed to sign out";
			}
		}
		return "failed to sign out";

	}

	public boolean forgotPassword(int id, String oldPassword, String newPassword) throws UserNotFoundException {
		try {
			if (iur.existsById(id)) {
				if (oldPassword.equals(newPassword)) {
					return false;
				} else {
					if (newPassword.matches("[A-Za-z0-9]+")) {
						throw new ValidateUserException(OnlinePizzaConstants.PASSWORD_CANNOT_BE_EMPTY);
					}
					iur.replace(id, oldPassword, newPassword);
					return true;
				}
			} else {
				throw new UserNotFoundException();
			}
		} catch (Exception e) {
			throw new UserNotFoundException("User not Exists");
		}
	}
}
