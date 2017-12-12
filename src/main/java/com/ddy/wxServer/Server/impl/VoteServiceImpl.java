package com.ddy.wxServer.Server.impl;

import com.ddy.wxServer.Dao.VoteDao;
import com.ddy.wxServer.Model.roles.VoteResult;
import com.ddy.wxServer.Server.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService {
    private static Logger log= LoggerFactory.getLogger(VoteServiceImpl.class);
    @Autowired
    private VoteDao voteDao;
    @Override
    public void anonymityVoteroject(String project) {
        VoteResult voteResult=new VoteResult();
        voteResult.setPsn_project_name(project);
        voteDao.insertAnonymity(voteResult);
        log.info("匿名投票成功:"+project);
    }

    @Override
    public List<Map> countAllResult() {
        List list= voteDao.selectAll();
        log.info("VoteDao查询出来的结果集为："+list);
        return list;
    }
}
