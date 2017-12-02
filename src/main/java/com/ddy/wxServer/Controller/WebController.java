package com.ddy.wxServer.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebController {
    @GetMapping("/getMode")
    public ModelAndView getModelAndView(Model model){
//        ModelAndView modelAndView=new ModelAndView("index");
        ModelAndView modelAndView=new ModelAndView("votepage");
        Map<String,Object> map = new HashMap<>();
        map.put("hello","hello,word");
        modelAndView.addAllObjects(map);
        model.addAttribute("Author","叶星源");
        return modelAndView;
    }
    @GetMapping("/gettotal")
    public ModelAndView getTotalModelAndView(String choessname){
        ModelAndView modelAndView=new ModelAndView("voteResult");
//        model.addAttribute("choose","叶星源");
        String cn[]=choessname.split(",");

        return modelAndView;
    }
}
