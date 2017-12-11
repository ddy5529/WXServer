package com.ddy.wxServer.Dao;

import com.ddy.wxServer.Model.roles.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserDao {

    @Select("SELECT * FROM USERS")
    @Results({
            @Result(property = "user_sex",  column = "user_sex"),
            @Result(property = "role_name", column = "role_name"),
            @Result(property = "userPhone", column = "userPhone")
})
    List<UserEntity> getAll();

    @Select("SELECT * FROM USERS WHERE user_id = #{id}")
    @Results({
            @Result(property = "user_sex",  column = "user_sex" ),
            @Result(property = "role_name", column = "role_name")
    })
    UserEntity getOne(int id);

    @Select("SELECT * FROM USERS WHERE role_name = #{roleName}")
    @Results({
            @Result(property = "user_id",  column = "user_id" ),
            @Result(property = "user_sex",  column = "user_sex" ),
            @Result(property = "role_name",  column = "role_name" ),
            @Result(property = "userPhone",  column = "userPhone" )
    })
    UserEntity getUsers(String roleName);

    @Insert("INSERT INTO USERS(user_sex,role_name,userName,passWord,userPhone) VALUES(#{user_sex},#{role_name} ,#{userName}, #{passWord}, #{userPhone})")
    void insert(UserEntity user);

    @Update("UPDATE USERS SET userName=#{userName},role_name=#{role_name} WHERE user_id =#{user_id}")
    void update(UserEntity user);

    @Delete("DELETE FROM USERS WHERE user_id =#{id}")
    void delete(int id);
}
