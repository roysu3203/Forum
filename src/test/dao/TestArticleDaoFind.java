package test.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.dao.IArticleDao;
import com.forum.entity.Article;

public class TestArticleDaoFind {
	ApplicationContext config = TestConfig.getApplicationContext();
	IArticleDao articleDao = (IArticleDao) config.getBean("articleDao");

	@Test
	public void testFindAll() {
		List<Article> forumsList = articleDao.findAll();
		assertEquals(new Integer(1), forumsList.get(0).getId());
		assertEquals(new Integer(1), forumsList.get(0).getUser().getId());
		assertEquals(new Integer(1), forumsList.get(0).getTheme().getId());
		assertEquals("Java的Lambda語法…", forumsList.get(0).getText());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), forumsList.get(0).getCreateTime());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), forumsList.get(0).getUpdateTime());
	}
	
	@Test
	public void testFindByIdSuccess() {
		Article article = articleDao.findById(1);
		assertEquals(new Integer(1), article.getId());
		assertEquals(new Integer(1), article.getUser().getId());
		assertEquals(new Integer(1), article.getTheme().getId());
		assertEquals("Java的Lambda語法…", article.getText());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), article.getCreateTime());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), article.getUpdateTime());
	}

	@Test
	public void testFindByIdFail() {
		Article article = articleDao.findById(0);
		assertEquals(article, null);
	}

}
