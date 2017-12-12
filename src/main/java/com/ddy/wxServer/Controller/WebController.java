package com.ddy.wxServer.Controller;

import com.ddy.wxServer.Server.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {

    private static Logger log = LoggerFactory.getLogger(CoreController.class);

    @Autowired
    VoteService voteService;
    @GetMapping("/getMode")
    public String getModelAndView(){
        return "votepage";
    }
    @GetMapping("/gettotal")
    public String getTotalModelAndView(@RequestParam(name = "choessname", required = false) String choessname,Model model){
        model.addAttribute("choose","ddy");
        log.info("开始拆分前的值"+choessname);
        if (choessname!=null&&!"".equals(choessname)) {
            String cn[] = choessname.split(",");
            for (String cns:cn
                 ) {
                voteService.anonymityVoteroject(cns);
            }
            log.info("拆分结束后的值"+cn.toString());
        }

        return "voteResult";
    }
    @GetMapping("/get/index")
    public String gotoName(Model model){
        model.addAttribute("myname","ddy");
        return "index";
    }
}
