package test.service;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.entity.Article;
import com.forum.service.IArticleService;

public class TestArticleServiceGet {
	ApplicationContext config = TestConfig.getApplicationContext();
	IArticleService articleService = (IArticleService) config.getBean("articleService");

	@Test
	public void testFindAll() {
		List<Article> articleList = articleService.getAllArticle();
		assertEquals(new Integer(1), articleList.get(0).getId());
		assertEquals(new Integer(1), articleList.get(0).getUser().getId());
		assertEquals(new Integer(1), articleList.get(0).getTheme().getId());
		assertEquals("Java的Lambda語法…", articleList.get(0).getText());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), articleList.get(0).getCreateTime());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), articleList.get(0).getUpdateTime());
	}
	
	@Test
	public void testFindByIdSuccess() {
		Article article = articleService.getArticleById(1);
		assertEquals(new Integer(1), article.getId());
		assertEquals(new Integer(1), article.getUser().getId());
		assertEquals(new Integer(1), article.getTheme().getId());
		assertEquals("Java的Lambda語法…", article.getText());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), article.getCreateTime());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), article.getUpdateTime());
	}

	@Test
	public void testFindByIdFail() {
		Article article = articleService.getArticleById(0);
		assertEquals(article, null);
	}

}
