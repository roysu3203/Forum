package test;

import org.springframework.context.ApplicationContext;

import com.forum.dao.IThemeDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext config = TestConfig.getApplicationContext();
		IThemeDao themeDao = (IThemeDao) config.getBean("themeDao");

		System.out.println(themeDao.findByForumsIdRow(1));
	}

}
