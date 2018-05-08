package com.ddy.wxServer.Server;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface VoteService {
    void anonymityVoteroject(String project);

    List<Map> countAllResult();
}
