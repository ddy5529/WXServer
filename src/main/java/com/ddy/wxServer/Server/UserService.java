package com.ddy.wxServer.Server;


import com.ddy.wxServer.Model.roles.UserEntity;

public interface UserService {
    UserEntity getPerson(String name);

}
