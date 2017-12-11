package com.ddy.wxServer.Server.impl;


import com.ddy.wxServer.Dao.UserDao;
import com.ddy.wxServer.Model.roles.UserEntity;
import com.ddy.wxServer.Server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public UserEntity getPerson(String name) {
        return (userDao.getUsers(name)==null)?new UserEntity():userDao.getUsers(name);
    }


}
