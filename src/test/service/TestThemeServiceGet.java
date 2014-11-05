package test.service;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.entity.Theme;
import com.forum.service.IThemeService;

public class TestThemeServiceGet {
	ApplicationContext config = TestConfig.getApplicationContext();
	IThemeService themeService = (IThemeService) config.getBean("themeService");

	@Test
	public void testFindAll() {
		List<Theme> themeList = themeService.getAllTheme();
		assertEquals(new Integer(1), themeList.get(0).getId());
		assertEquals(new Integer(1), themeList.get(0).getUser().getId());
		assertEquals(new Integer(1), themeList.get(0).getForums().getId());
		assertEquals("Java8教學心得", themeList.get(0).getTitle());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), themeList.get(0).getCreateTime());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), themeList.get(0).getUpdateTime());
	}
	
	@Test
	public void testFindByIdSuccess() {
		Theme theme = themeService.getThemeById(1);
		assertEquals(new Integer(1), theme.getId());
		assertEquals(new Integer(1), theme.getUser().getId());
		assertEquals(new Integer(1), theme.getForums().getId());
		assertEquals("Java8教學心得", theme.getTitle());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), theme.getCreateTime());
		assertEquals(Timestamp.valueOf("2014-08-22 17:55:46"), theme.getUpdateTime());
	}

	@Test
	public void testFindByIdFail() {
		Theme theme = themeService.getThemeById(0);
		assertEquals(theme, null);
	}
	
	@Test
	public void testFindByForumsIdSuccess() {
		List<Theme> themeList = themeService.getThemeListByForumsId(1);
		assertEquals(new Integer(19), themeList.get(0).getId());
		assertEquals(new Integer(15), themeList.get(0).getUser().getId());
		assertEquals(new Integer(1), themeList.get(0).getForums().getId());
		assertEquals("對對對", themeList.get(0).getTitle());
		assertEquals(Timestamp.valueOf("2014-08-25 22:10:24"), themeList.get(0).getCreateTime());
		assertEquals(Timestamp.valueOf("2014-08-25 22:10:24"), themeList.get(0).getUpdateTime());
		assertEquals(9, themeList.size());
	}

	@Test
	public void testFindByForumsIdFail() {
		List<Theme> themeList = themeService.getThemeListByForumsId(0);
		assertEquals(0, themeList.size());
	}

}
