package com.ddy.wxServer.Server;


import com.ddy.wxServer.Model.roles.UserEntity;
import org.springframework.stereotype.Service;


public interface UserService {
    UserEntity getPerson(String name);

}
