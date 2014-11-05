package test.dao;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.dao.IForumsDao;
import com.forum.entity.Forums;
import com.forum.entity.User;

public class TestForumsDao {

	public static void main(String[] args) {
		ApplicationContext config = TestConfig.getApplicationContext();
		IForumsDao forumsDao = (IForumsDao) config.getBean("forumsDao");
		
		// Test Save
		
		User user = new User();
		user.setId(1);
		
		Forums forums = new Forums();
		forums.setUser(user);
		forums.setTitle("Java EE");
		forums.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		forumsDao.saveOrUpdate(forums);
		
		
		// Test Update
		/*
		User user = new User();
		user.setId(1);
		
		Forums forums = new Forums();
		forums.setId(2);
		forums.setUser(user);
		forums.setTitle("Java ME");
		forums.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		forumsDao.saveOrUpdate(forums);
		*/
		
		// Test Delete
		/*
		Forums forums = new Forums();
		forums.setId(2);
		
		forumsDao.delete(forums);
		*/
	}

}
