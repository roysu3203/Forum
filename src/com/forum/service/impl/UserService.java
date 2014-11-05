package com.forum.service.impl;

import java.util.List;

import com.forum.dao.IUserDao;
import com.forum.entity.User;
import com.forum.exception.DataValidateException;
import com.forum.service.IUserService;

public class UserService implements IUserService {
	private IUserDao userDao;

	@Override
	public void register(User user) throws DataValidateException {		
		// 驗證是否有相同帳號
		User validateAccountUser = userDao.findByAccount(user.getAccount());
		if(validateAccountUser != null) {
			throw new DataValidateException(1);
		}			
		// 驗證是否有相同Email
		User validateEmailUser = userDao.findByEmail(user.getEmail());
		if(validateEmailUser != null) {
			throw new DataValidateException(2);
		}

		userDao.saveOrUpdate(user);
	}

	@Override
	public boolean validateAccount(String account) {
		return userDao.findByAccount(account) == null;
	}

	@Override
	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public User getUserByAccount(String account) {
		return userDao.findByAccount(account);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
