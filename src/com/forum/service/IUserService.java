package com.forum.service;

import java.util.List;

import com.forum.entity.User;
import com.forum.exception.DataValidateException;

public interface IUserService {

	/**
	 * 註冊
	 * @param user
	 * @throws DataValidateException
	 */
	public void register(User user) throws DataValidateException;
	
	/**
	 * 驗證帳號是否有效（未重覆）
	 * @param account
	 * @return
	 */
	public boolean validateAccount(String account);
	
	public void saveOrUpdate(User user);
	
	public void delete(User user);
	
	public List<User> getAllUser();
	
	public User getUserById(Integer id);

    public User getUserByAccount(String account);
    
    public User getUserByEmail(String email);

}
