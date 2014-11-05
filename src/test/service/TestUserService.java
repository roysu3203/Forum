package test.service;

import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.constants.ConstUser;
import com.forum.entity.User;
import com.forum.service.IUserService;

public class TestUserService {

	public static void main(String[] args) {
		ApplicationContext config = TestConfig.getApplicationContext();
		IUserService userService = (IUserService) config.getBean("userService");
		
		// Test Save
		
		User user = new User();
		user.setAccount("Test082003");
		user.setPassword("123456");
		user.setIdentity(ConstUser.IDENTITY_USER);
		
		userService.saveOrUpdate(user);
		
		
		// Test Update
		/*
		User user = new User();
		user.setId(13);
		user.setAccount("Test082004");
		user.setPassword("123456");
		user.setIdentity(ConstUser.IDENTITY_USER);
		
		userService.saveOrUpdate(user);
		*/
		
		// Test Delete
		/*
		User user = new User();
		user.setId(7);
		
		userService.delete(user);
		*/
	}

}
