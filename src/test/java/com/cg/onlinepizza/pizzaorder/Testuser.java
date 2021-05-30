package com.cg.onlinepizza.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlinepizza.dto.User;
import com.cg.onlinepizza.exceptions.UserNotFoundException;
import com.cg.onlinepizza.exceptions.ValidateUserException;
import com.cg.onlinepizza.service.IUserService;

public class Testuser extends OnlinePizzaApplicationTests{
	@Autowired
	IUserService ius;
	@Test
	void testIUserService() {
	    assertTrue(ius instanceof IUserService);
	}

    @Test
	void testAddNewUser() throws ValidateUserException {
		User u = new User(15,"harshini","H@rshini811", false);
		u = ius.addNewUser(u);
		assertEquals(u.getUserName(), "harshini");
	}
    @Test
	void testSignIn() throws UserNotFoundException, ValidateUserException {
		User u = new User(15,"harshini","H@rshini811", false);
		ius.addNewUser(u);
		String p = ius.signin(u);
		assertEquals("successfully signed in",p);
	}

	@Test
	void testSignOut() throws ValidateUserException {
		User u = new User(7,"likitha","Likith@9", true);
		ius.addNewUser(u);
		String p = ius.signOut(u);
		assertEquals("successfully signed out",p);
	}
	@Test
	void testForgotPassword() throws UserNotFoundException {
		boolean b = ius.forgotPassword(1, "harshini811", "harshini81");
		assertEquals(true,b);	
	}
	


}
