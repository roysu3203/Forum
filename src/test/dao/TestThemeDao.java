package test.dao;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.dao.IThemeDao;
import com.forum.entity.Forums;
import com.forum.entity.Theme;
import com.forum.entity.User;

public class TestThemeDao {

	public static void main(String[] args) {
		ApplicationContext config = TestConfig.getApplicationContext();
		IThemeDao themeDao = (IThemeDao) config.getBean("themeDao");
		
		User user = new User(1);
		Forums forums = new Forums(1);
		
		// Test Save
		
		Theme theme = new Theme();
		theme.setUser(user);
		theme.setForums(forums);
		theme.setTitle("測試主題");
		theme.setCreateTime(new Timestamp(System.currentTimeMillis()));
		theme.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		
		themeDao.saveOrUpdate(theme);
		
		
		// Test Update
		/*
		Theme theme = new Theme();
		theme.setId(4);
		theme.setUser(user);
		theme.setForums(forums);
		theme.setTitle("測試修改主題");
		theme.setCreateTime(new Timestamp(System.currentTimeMillis()));
		theme.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		
		themeDao.saveOrUpdate(theme);
		*/
		
		// Test Delete
		/*
		Theme theme = new Theme();
		theme.setId(4);
		
		themeDao.delete(theme);
		*/		
	}
	
}
