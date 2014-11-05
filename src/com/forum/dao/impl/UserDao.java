package com.forum.dao.impl;

import com.forum.dao.IUserDao;
import com.forum.entity.User;

public class UserDao extends BaseDao<User> implements IUserDao {
	
	public UserDao() {
		super(User.class);
	}

	@Override
	public User findByAccount(String account) {
		return super.findBy("account", account);
	}

	@Override
	public User findByEmail(String email) {
		return super.findBy("email", email);
	}
	
}
