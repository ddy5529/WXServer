package com.ddy.wxServer.Dao;

import com.ddy.wxServer.Model.roles.UserEntity;
import com.ddy.wxServer.Model.roles.VoteResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface VoteDao {
    @Insert("INSERT INTO votetable(psn_code,psn_project_name,vote_person_id) VALUES(#{psn_code},#{psn_project_name} ,#{vote_person_id} )")
    void insert(VoteResult voteResult);

    @Insert("INSERT INTO votetable(psn_project_name) VALUES(#{psn_project_name} )")
    void insertAnonymity(VoteResult voteResult);

    @Select("SELECT * FROM votetable")
    List selectAll();

    @Select("SELECT COUNT(0) FROM votetable WHERE ")
    int countName();

}
