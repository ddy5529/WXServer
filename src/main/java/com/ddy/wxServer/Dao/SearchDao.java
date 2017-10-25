package com.ddy.wxServer.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SearchDao {

    String get(@Param("name") String name);
}
