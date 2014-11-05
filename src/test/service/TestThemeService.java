package test.service;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.entity.Forums;
import com.forum.entity.Theme;
import com.forum.entity.User;
import com.forum.service.IThemeService;

public class TestThemeService {

	public static void main(String[] args) {
		ApplicationContext config = TestConfig.getApplicationContext();
		IThemeService themeService = (IThemeService) config.getBean("themeService");
		
		User user = new User(1);
		Forums forums = new Forums(1);
		
		// Test Save
		
		Theme theme = new Theme();
		theme.setUser(user);
		theme.setForums(forums);
		theme.setTitle("TestThemeService測試文章主題");
		theme.setCreateTime(new Timestamp(System.currentTimeMillis()));
		theme.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		
		themeService.saveOrUpdate(theme);
		
		
		// Test Update
		/*
		Theme theme = new Theme();
		theme.setId(6);
		theme.setUser(user);
		theme.setForums(forums);
		theme.setTitle("TestThemeService測試文章主題");
		theme.setCreateTime(new Timestamp(System.currentTimeMillis()));
		theme.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		
		themeService.saveOrUpdate(theme);
		*/
		
		// Test Delete
		/*
		Theme theme = new Theme();
		theme.setId(6);
		
		themeService.delete(theme);
		*/
	}
	
}
