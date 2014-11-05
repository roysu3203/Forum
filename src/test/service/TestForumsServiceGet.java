package test.service;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.entity.Forums;
import com.forum.service.IForumsService;

public class TestForumsServiceGet {
	ApplicationContext config = TestConfig.getApplicationContext();
	IForumsService forumsService = (IForumsService) config.getBean("forumsService");

	@Test
	public void testGetAllForums() {
		List<Forums> forumsGroup = forumsService.getAllForums();
		assertEquals(new Integer(1), forumsGroup.get(0).getId());
		assertEquals(new Integer(1), forumsGroup.get(0).getUser().getId());
		assertEquals("Java SE", forumsGroup.get(0).getTitle());
		assertEquals(Timestamp.valueOf("2014-08-20 19:40:42"), forumsGroup.get(0).getCreateTime());
	}
	
	@Test
	public void testGetForumsByIdSuccess() {
		Forums forums = forumsService.getForumsById(1);
		assertEquals(new Integer(1), forums.getId());
		assertEquals(new Integer(1), forums.getUser().getId());
		assertEquals("Java SE", forums.getTitle());
		assertEquals(Timestamp.valueOf("2014-08-20 19:40:42"), forums.getCreateTime());
	}
	
	@Test
	public void testGetForumsByIdFail() {
		Forums forums = forumsService.getForumsById(0);
		assertEquals(forums, null);
	}
	
	@Test
	public void testGetForumsByTitleSuccess() {
		Forums forums = forumsService.getForumsByTitle("Java SE");
		assertEquals(new Integer(1), forums.getId());
		assertEquals(new Integer(1), forums.getUser().getId());
		assertEquals("Java SE", forums.getTitle());
		assertEquals(Timestamp.valueOf("2014-08-20 19:40:42"), forums.getCreateTime());
	}
	
	@Test
	public void testGetForumsByTitleFail() {
		Forums forums = forumsService.getForumsByTitle("無此討論版");
		assertEquals(forums, null);
	}

}
