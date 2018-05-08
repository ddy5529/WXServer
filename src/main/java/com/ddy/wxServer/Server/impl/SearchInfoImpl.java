package com.ddy.wxServer.Server.impl;

import com.ddy.wxServer.Dao.SearchDao;
import com.ddy.wxServer.Server.SearchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
public class SearchInfoImpl implements SearchInfo{

    @Autowired
    SearchDao searchDao;

    @Override
    public String getInfo(String name){
        return searchDao.get(name);
    }
}
