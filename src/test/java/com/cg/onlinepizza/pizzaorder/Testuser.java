package com.cg.onlinepizza.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.onlinepizza.dto.User;
import com.cg.onlinepizza.exceptions.UserNotFoundException;
//import com.cg.onlinepizza.dao.IUserRepository;
import com.cg.onlinepizza.service.IUserService;

public class Testuser extends OnlinePizzaApplicationTests{
	@Autowired
	IUserService ius;
	@Test
	void testIUserService() {
	    assertTrue(ius instanceof IUserService);
	}

    @Test
	void testAddNewUser() {
		User u = new User(1,"harshini","harshini811", false);
		u = ius.addNewUser(u);
		assertEquals(u.getUserName(), "harshini");
	}
    @Test
	void testSignIn() {
		User u = new User(1,"harshini","harshini811", false);
		ius.addNewUser(u);
		String p = ius.signin(u);
		assertEquals("success",p);
	}

	@Test
	void testSignOut() {
		User u = new User(1,"harshini","harshini811", true);
		ius.addNewUser(u);
		String p = ius.signOut(u);
		assertEquals("success",p);
	}
	@Test
	void testForgotPassword() throws UserNotFoundException {
		boolean b = ius.forgotPassword(1, "harshini811", "harshini81");
		assertEquals(true,b);
		
		
	}
	


}
