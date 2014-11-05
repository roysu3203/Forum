package test.dao;

import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.constants.ConstUser;
import com.forum.dao.IUserDao;
import com.forum.entity.User;

public class TestUserDao {

	public static void main(String[] args) {
		ApplicationContext config = TestConfig.getApplicationContext();
		IUserDao userDao = (IUserDao) config.getBean("userDao");
		
		// Test Save
		
		User user = new User();
		user.setAccount("Test082001");
		user.setPassword("123456");
		user.setIdentity(ConstUser.IDENTITY_USER);
		
		userDao.saveOrUpdate(user);
		
		
		// Test Update
		/*
		User user = new User();
		user.setId(12);
		user.setAccount("Test082002");
		user.setPassword("123456");
		user.setIdentity(ConstUser.IDENTITY_ADMIN);
		
		userDao.saveOrUpdate(user);
		*/
		
		// Test Delete
		/*
		User user = new User();
		user.setId(9);
		
		userDao.delete(user);
		*/
	}

}
