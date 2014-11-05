package test.service;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.entity.Forums;
import com.forum.entity.User;
import com.forum.service.IForumsService;

public class TestForumsService {

	public static void main(String[] args) {
		ApplicationContext config = TestConfig.getApplicationContext();
		IForumsService forumsService = (IForumsService) config.getBean("forumsService");
		
		// Test Save
		
		User user = new User();
		user.setId(1);
		
		Forums forums = new Forums();
		forums.setUser(user);
		forums.setTitle("Servlet");
		forums.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		forumsService.saveOrUpdate(forums);
		
		
		// Test Update
		/*
		User user = new User();
		user.setId(1);
		
		Forums forums = new Forums();
		forums.setId(4);
		forums.setUser(user);
		forums.setTitle("Java ME");
		forums.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		forumsService.saveOrUpdate(forums);
		*/
		
		// Test Delete
		/*
		Forums forums = new Forums();
		forums.setId(4);
		
		forumsService.delete(forums);
		*/
	}

}
