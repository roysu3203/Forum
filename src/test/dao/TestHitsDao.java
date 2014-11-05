package test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.dao.IForumsDao;
import com.forum.dao.IHitsDao;
import com.forum.dao.IThemeDao;
import com.forum.entity.Forums;
import com.forum.entity.Theme;

public class TestHitsDao {
	ApplicationContext config = TestConfig.getApplicationContext();
	IHitsDao hitsDao = (IHitsDao) config.getBean("hitsDao");
	IForumsDao forumsDao = (IForumsDao) config.getBean("forumsDao");
	IThemeDao themeDao = (IThemeDao) config.getBean("themeDao");

	@Test
	public void testAddHitsForForums() {
		Forums beforeForums = forumsDao.findById(1);
		hitsDao.addHitsForForums(1);
		Forums afterForums = forumsDao.findById(1);

		Integer beforeHitsAddOne = beforeForums.getHits() + 1;
		
		assertEquals(beforeHitsAddOne, afterForums.getHits());
	}

	@Test
	public void testAddHitsForTheme() {
		Theme beforeTheme = themeDao.findById(1);
		hitsDao.addHitsForTheme(1);
		Theme afterTheme = themeDao.findById(1);

		Integer beforeHitsAddOne = beforeTheme.getHits() + 1;
		
		assertEquals(beforeHitsAddOne, afterTheme.getHits());
	}

}
