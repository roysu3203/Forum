package test.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.dao.IForumsDao;
import com.forum.dao.IThemeDao;
import com.forum.entity.Forums;
import com.forum.entity.Theme;
import com.forum.service.IHitsService;

public class TestHitsService {
	ApplicationContext config = TestConfig.getApplicationContext();
	IHitsService hitsService = (IHitsService) config.getBean("hitsService");
	IForumsDao forumsDao = (IForumsDao) config.getBean("forumsDao");
	IThemeDao themeDao = (IThemeDao) config.getBean("themeDao");

	@Test
	public void testAddHitsForForums() {
		Forums beforeForums = forumsDao.findById(1);
		hitsService.addHitsForForums(1);
		Forums afterForums = forumsDao.findById(1);

		Integer beforeHitsAddOne = beforeForums.getHits() + 1;
		
		assertEquals(beforeHitsAddOne, afterForums.getHits());
	}

	@Test
	public void testAddHitsForTheme() {
		Theme beforeTheme = themeDao.findById(1);
		hitsService.addHitsForTheme(1);
		Theme afterTheme = themeDao.findById(1);

		Integer beforeHitsAddOne = beforeTheme.getHits() + 1;
		
		assertEquals(beforeHitsAddOne, afterTheme.getHits());
	}

	@Test
	public void testAddHitsForForumsAndTheme() {
		Forums beforeForums = forumsDao.findById(1);
		Theme beforeTheme = themeDao.findById(1);
		
		hitsService.addHitsForForumsAndTheme(1, 1);
		
		Forums afterForums = forumsDao.findById(1);
		Theme afterTheme = themeDao.findById(1);

		Integer beforeForumsHitsAddOne = beforeForums.getHits() + 1;
		Integer beforeThemeHitsAddOne = beforeTheme.getHits() + 1;

		assertEquals(beforeForumsHitsAddOne, afterForums.getHits());
		assertEquals(beforeThemeHitsAddOne, afterTheme.getHits());
	}

}
