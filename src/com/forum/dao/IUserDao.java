package com.forum.dao;

import com.forum.entity.User;

public interface IUserDao extends IBaseDao<User> {

    public User findByAccount(String account);
    
    public User findByEmail(String email);

}
