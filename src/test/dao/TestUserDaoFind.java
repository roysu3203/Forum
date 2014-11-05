package test.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.constants.ConstUser;
import com.forum.dao.IUserDao;
import com.forum.entity.User;

public class TestUserDaoFind {
	ApplicationContext config = TestConfig.getApplicationContext();
	IUserDao userDao = (IUserDao) config.getBean("userDao");

	@Test
	public void testFindAll() {
		List<User> userGroup = userDao.findAll();
		assertEquals(new Integer(1), userGroup.get(0).getId());
		assertEquals("roy", userGroup.get(0).getAccount());
		assertEquals("123456", userGroup.get(0).getPassword());
		assertEquals("su704erg@gmail.com", userGroup.get(0).getEmail());
		assertEquals(ConstUser.IDENTITY_ADMIN, userGroup.get(0).getIdentity());
	}

	@Test
	public void testFindByIdSuccess() {
		User user = userDao.findById(1);
		assertEquals(new Integer(1), user.getId());
		assertEquals("roy", user.getAccount());
		assertEquals("123456", user.getPassword());
		assertEquals("su704erg@gmail.com", user.getEmail());
		assertEquals(ConstUser.IDENTITY_ADMIN, user.getIdentity());
	}

	@Test
	public void testFindByIdFail() {
		User user = userDao.findById(0);
		assertEquals(user, null);
	}

	@Test
	public void testFindByAccountSuccess() {
		User user = userDao.findByAccount("roy");
		assertEquals(new Integer(1), user.getId());
		assertEquals("roy", user.getAccount());
		assertEquals("123456", user.getPassword());
		assertEquals("su704erg@gmail.com", user.getEmail());
		assertEquals(ConstUser.IDENTITY_ADMIN, user.getIdentity());	
	}

	@Test
	public void testFindByAccountFail() {
		User user = userDao.findByAccount("fail");
		assertEquals(user, null);
	}

	@Test
	public void testFindByEmailSuccess() {
		User user = userDao.findByEmail("su704erg@gmail.com");
		assertEquals(new Integer(1), user.getId());
		assertEquals("roy", user.getAccount());
		assertEquals("123456", user.getPassword());
		assertEquals("su704erg@gmail.com", user.getEmail());
		assertEquals(ConstUser.IDENTITY_ADMIN, user.getIdentity());
	}

	@Test
	public void testFindByEmailFail() {
		User user = userDao.findByEmail("fail@gmail.com");
		assertEquals(user, null);
	}

}
