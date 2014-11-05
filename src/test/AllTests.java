package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.dao.*;
import test.service.*;

@RunWith(Suite.class)
@SuiteClasses({TestUserDaoFind.class, TestUserServiceGet.class,
				TestForumsDaoFind.class, TestForumsServiceGet.class,
				TestThemeDaoFind.class, TestThemeServiceGet.class,
				TestArticleDaoFind.class, TestArticleServiceGet.class,
				TestHitsDao.class, TestHitsService.class})
public class AllTests {

}
