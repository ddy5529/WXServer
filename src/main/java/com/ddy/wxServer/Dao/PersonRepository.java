package com.ddy.wxServer.Dao;

import com.ddy.wxServer.Model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonRepository extends JpaRepository<User,Long> {
    User findByName(String name);

    @Query(value = "")
    User findUser(@Param("name") String name);
}
