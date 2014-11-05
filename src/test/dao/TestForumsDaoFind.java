package test.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.dao.IForumsDao;
import com.forum.entity.Forums;

public class TestForumsDaoFind {
	ApplicationContext config = TestConfig.getApplicationContext();
	IForumsDao forumsDao = (IForumsDao) config.getBean("forumsDao");

	@Test
	public void testFindAll() {
		List<Forums> forumsGroup = forumsDao.findAll();
		assertEquals(new Integer(1), forumsGroup.get(0).getId());
		assertEquals(new Integer(1), forumsGroup.get(0).getUser().getId());
		assertEquals("Java SE", forumsGroup.get(0).getTitle());
		assertEquals(Timestamp.valueOf("2014-08-20 19:40:42"), forumsGroup.get(0).getCreateTime());
	}
	
	@Test
	public void testFindByIdSuccess() {
		Forums forums = forumsDao.findById(1);
		assertEquals(new Integer(1), forums.getId());
		assertEquals(new Integer(1), forums.getUser().getId());
		assertEquals("Java SE", forums.getTitle());
		assertEquals(Timestamp.valueOf("2014-08-20 19:40:42"), forums.getCreateTime());
	}

	@Test
	public void testFindByIdFail() {
		Forums forums = forumsDao.findById(0);
		assertEquals(forums, null);
	}
	
	@Test
	public void testFindByTitleSuccess() {
		Forums forums = forumsDao.findByTitle("Java SE");
		assertEquals(new Integer(1), forums.getId());
		assertEquals(new Integer(1), forums.getUser().getId());
		assertEquals("Java SE", forums.getTitle());
		assertEquals(Timestamp.valueOf("2014-08-20 19:40:42"), forums.getCreateTime());
	}

	@Test
	public void testFindByTitleFail() {
		Forums forums = forumsDao.findByTitle("fail");
		assertEquals(forums, null);
	}

}
