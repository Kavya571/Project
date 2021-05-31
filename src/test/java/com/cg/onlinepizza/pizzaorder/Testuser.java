package com.cg.onlinepizza.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlinepizza.dto.User;
import com.cg.onlinepizza.exceptions.UserNotFoundException;
import com.cg.onlinepizza.exceptions.ValidateUserException;
import com.cg.onlinepizza.service.IUserService;

public class Testuser extends OnlinePizzaApplicationTests {
	@Autowired
	IUserService ius;

	@Test
	void testIUserService() {
		assertTrue(ius instanceof IUserService);
	}

	@Test
	void testAddNewUser() throws ValidateUserException {
		User u = new User(6, "vaishnav", "Vaishu@22", false);
		u = ius.addNewUser(u);
		assertEquals(u.getUserName(), "vaishnav");
	}

	@Test
	void testSignIn() throws UserNotFoundException, ValidateUserException {
		User u = new User(5, "vaishnavi", "Vaishu@22", false);
		String p = ius.signin(u);
		assertEquals("successfully signed in", p);
	}

	@Test
	void testSignOut() throws ValidateUserException {
		User u = new User(5, "vaishnavi", "Vaishu@22", true);
		String p = ius.signOut(u);
		assertEquals("successfully signed out", p);
	}

	@Test
	void testForgotPassword() throws UserNotFoundException, ValidateUserException {
		boolean b = ius.forgotPassword(3, "harini", "H@rini897");
		assertEquals(true, b);
	}

}
