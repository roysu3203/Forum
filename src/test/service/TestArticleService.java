package test.service;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.entity.Article;
import com.forum.entity.Theme;
import com.forum.entity.User;
import com.forum.service.IArticleService;

public class TestArticleService {

	public static void main(String[] args) {
		ApplicationContext config = TestConfig.getApplicationContext();
		IArticleService articleService = (IArticleService) config.getBean("articleService");
		
		User user = new User(1);
		Theme theme = new Theme(1);
		
		// Test Save
		
		Article article = new Article();
		article.setUser(user);
		article.setTheme(theme);
		article.setText("測試文章內容…");
		article.setCreateTime(new Timestamp(System.currentTimeMillis()));
		article.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		
		articleService.saveOrUpdate(article);
		
		
		// Test Update
		/*
		Article article = new Article();
		article.setId(4);
		article.setUser(user);
		article.setTheme(theme);
		article.setText("測試修改文章內容…");
		article.setCreateTime(new Timestamp(System.currentTimeMillis()));
		article.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		
		articleDao.saveOrUpdate(article);
		*/
		
		// Test Delete
		/*
		Article article = new Article();
		article.setId(5);
		
		articleDao.delete(article);
		*/		
	}
	
}
