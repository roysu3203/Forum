package test.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.TestConfig;

import com.forum.constants.ConstUser;
import com.forum.entity.User;
import com.forum.service.IUserService;

public class TestUserServiceGet {
	ApplicationContext config = TestConfig.getApplicationContext();
	IUserService userService = (IUserService) config.getBean("userService");

	@Test
	public void testGetAllUser() {
		List<User> userGroup = userService.getAllUser();
		assertEquals(new Integer(1), userGroup.get(0).getId());
		assertEquals("roy", userGroup.get(0).getAccount());
		assertEquals("123456", userGroup.get(0).getPassword());
		assertEquals("su704erg@gmail.com", userGroup.get(0).getEmail());
		assertEquals(ConstUser.IDENTITY_ADMIN, userGroup.get(0).getIdentity());
	}

	@Test
	public void testGetUserByIdSuccess() {
		User user = userService.getUserById(1);
		assertEquals(new Integer(1), user.getId());
		assertEquals("roy", user.getAccount());
		assertEquals("123456", user.getPassword());
		assertEquals("su704erg@gmail.com", user.getEmail());
		assertEquals(ConstUser.IDENTITY_ADMIN, user.getIdentity());
	}

	@Test
	public void testGetUserByIdFail() {
		User user = userService.getUserById(0);
		assertEquals(user, null);
	}

	@Test
	public void testGetUserByAccountSuccess() {
		User user = userService.getUserByAccount("roy");
		assertEquals(new Integer(1), user.getId());
		assertEquals("roy", user.getAccount());
		assertEquals("123456", user.getPassword());
		assertEquals("su704erg@gmail.com", user.getEmail());
		assertEquals(ConstUser.IDENTITY_ADMIN, user.getIdentity());	
	}

	@Test
	public void testGetUserByAccountFail() {
		User user = userService.getUserByAccount("fail");
		assertEquals(user, null);
	}

	@Test
	public void testGetUserByEmailSuccess() {
		User user = userService.getUserByEmail("su704erg@gmail.com");
		assertEquals(new Integer(1), user.getId());
		assertEquals("roy", user.getAccount());
		assertEquals("123456", user.getPassword());
		assertEquals("su704erg@gmail.com", user.getEmail());
		assertEquals(ConstUser.IDENTITY_ADMIN, user.getIdentity());
	}

	@Test
	public void testGetUserByEmailFail() {
		User user = userService.getUserByEmail("fail@gmail.com");
		assertEquals(user, null);
	}

}
