package com.ddy.wxServer.Utils.WeiXinInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class WeiXInMenuView {
    static public String getMenuView() {
        //这是微信菜单栏的底部按钮栏的部署
        Map buttonMap = new HashMap();
        List secondMenu = new ArrayList();
        Map secondMenuButton_menu = new LinkedHashMap();//设置包含2级菜单的“我的菜单”的按钮
        secondMenuButton_menu.put("name", "我的菜单");
        List secondMenuButton_menu_three = new ArrayList();
        Map secondMenuButton_menu_three_menu_first = new LinkedHashMap();
        //在这里设置二级菜单
        secondMenuButton_menu_three_menu_first.put("type", "view");
        secondMenuButton_menu_three_menu_first.put("name", "公司主页");
        secondMenuButton_menu_three_menu_first.put("url", "http://www.irissz.com/cn/");
        secondMenuButton_menu_three.add(secondMenuButton_menu_three_menu_first);  //添加二级菜单中的第一个按钮
        Map secondMenuButton_menu_three_menu_second = new LinkedHashMap();
        secondMenuButton_menu_three_menu_second.put("type", "click");
        secondMenuButton_menu_three_menu_second.put("name", "赞一下");
        secondMenuButton_menu_three_menu_second.put("key", "menu_secret_praise_key");
        secondMenuButton_menu_three.add(secondMenuButton_menu_three_menu_second);   //添加二级菜单中的第二个按钮
        secondMenuButton_menu.put("sub_button", secondMenuButton_menu_three);
        secondMenu.add(secondMenuButton_menu);
        Map secondMenuButton_vote = new LinkedHashMap();//设置“投票”的按钮
        secondMenuButton_vote.put("type", "click");
        secondMenuButton_vote.put("name", "投票");
        secondMenuButton_vote.put("key", "menu_secret_ballot_key");
        secondMenu.add(secondMenuButton_vote);  //这是一级菜单添加的按钮
        Map secondMenuButton_else = new LinkedHashMap();//设置“其他”按钮,一级菜单中的第三个按钮（一级菜单最多可设置3个按钮）
        secondMenuButton_else.put("name", "其他");
        List secondMenuButton_else_list = new ArrayList();
        Map secondMenuButton_else_list_map = new LinkedHashMap();//一级菜单中第三个按钮的二级菜单的第一个按钮
        secondMenuButton_else_list_map.put("type", "click");
        secondMenuButton_else_list_map.put("name", "关于我");
        secondMenuButton_else_list_map.put("key", "menu_secret_about_me");
        secondMenuButton_else_list.add(secondMenuButton_else_list_map);//添加第一个按钮
        Map secondMenuButton_else_list_map2 = new LinkedHashMap();//一级菜单中第三个按钮的二级菜单的第二个按钮
        secondMenuButton_else_list_map2.put("type", "view_limited");
        secondMenuButton_else_list_map2.put("name", "图文消息");
        secondMenuButton_else_list_map2.put("media_id", "id_image_message");
        secondMenuButton_else_list.add(secondMenuButton_else_list_map2);//添加第二个按钮
        Map secondMenuButton_else_list_map3 = new LinkedHashMap();//一级菜单中第三个按钮的二级菜单的第三个按钮
        secondMenuButton_else_list_map3.put("type", "scancode_push");
        secondMenuButton_else_list_map3.put("name", "扫码推事件");
        secondMenuButton_else_list_map3.put("key", "scan_code_push_key");
        List secondMenuButton_else_list_map3_list = new ArrayList();
        secondMenuButton_else_list_map3.put("sub_button", secondMenuButton_else_list_map3_list);
        secondMenuButton_else_list.add(secondMenuButton_else_list_map3);//添加第三个按钮进去
        Map secondMenuButton_else_list_map4 = new LinkedHashMap();
        secondMenuButton_else_list_map4.put("type", "miniprogram");
        secondMenuButton_else_list_map4.put("name", "微信小程序（测试中）");
        secondMenuButton_else_list_map4.put("url", "http://mp.weixin.qq.com");
        secondMenuButton_else_list_map4.put("appid", "wx286b93c14bbf93aa");
        secondMenuButton_else_list_map4.put("pagepath", "pages/lunar/index");
        secondMenuButton_else_list.add(secondMenuButton_else_list_map4);
        secondMenuButton_else.put("sub_button", secondMenuButton_else_list); //一级菜单中第三个按钮的二级菜单
        secondMenu.add(secondMenuButton_else);
        buttonMap.put("button", secondMenu);
        return buttonMap.toString();
    }

    static public String getCreateMenuOnJSONString() throws JSONException {
        JSONObject theButton = new JSONObject();
        JSONArray theFirstMenuButton=new JSONArray();
        JSONObject theFirstButton=new JSONObject();//第一个按钮
        theFirstButton.put("name","我的菜单");
        JSONArray theFirstButtonMenu=new JSONArray();
        JSONObject theFirstButtonMenuButton1=new JSONObject();
        theFirstButtonMenuButton1.put("type","view");
        theFirstButtonMenuButton1.put("name","公司主页");
        theFirstButtonMenuButton1.put("url","http: //www.irissz.com/cn/");
        theFirstButtonMenu.put(theFirstButtonMenuButton1);
        JSONObject theFirstButtonMenuButton2=new JSONObject();
        theFirstButtonMenuButton2.put("type","click");
        theFirstButtonMenuButton2.put("name","赞一下");
        theFirstButtonMenuButton2.put("key","menu_secret_praise_key");
        theFirstButtonMenu.put(theFirstButtonMenuButton2);
        theFirstButton.put("sub_button",theFirstButtonMenu);
        theFirstMenuButton.put(theFirstButton);//添加了第一个
        JSONObject theSecondMenuButton=new JSONObject();
        theSecondMenuButton.put("type","click");
        theSecondMenuButton.put("name","投票");
        theSecondMenuButton.put("key","menu_secret_ballot_key");
        theFirstMenuButton.put(theSecondMenuButton);//添加了第二个
        JSONObject theThreeMenuButton=new JSONObject();
        theThreeMenuButton.put("name","其他");
        JSONArray theThreeMenuButtonMenu=new JSONArray();
        JSONObject theThreeMenuButtonMenuButton1=new JSONObject();
        theThreeMenuButtonMenuButton1.put("type","click");
        theThreeMenuButtonMenuButton1.put("name","关于我");
        theThreeMenuButtonMenuButton1.put("key","menu_secret_about_me");
        theThreeMenuButtonMenu.put(theThreeMenuButtonMenuButton1);
        JSONObject theThreeMenuButtonMenuButton2=new JSONObject();
        theThreeMenuButtonMenuButton2.put("type","view_limited");
        theThreeMenuButtonMenuButton2.put("name","图文消息");
        theThreeMenuButtonMenuButton2.put("media_id","id_image_message");
        theThreeMenuButtonMenu.put(theThreeMenuButtonMenuButton2);
        JSONObject theThreeMenuButtonMenuButton3=new JSONObject();
        theThreeMenuButtonMenuButton3.put("type","scancode_push");
        theThreeMenuButtonMenuButton3.put("name","扫码推事件");
        theThreeMenuButtonMenuButton3.put("key","scan_code_push_key");
        theThreeMenuButtonMenuButton3.put("sub_button",new JSONArray());
        theThreeMenuButtonMenu.put(theThreeMenuButtonMenuButton3);
        theThreeMenuButton.put("sub_button",theThreeMenuButtonMenu);
        theFirstMenuButton.put(theThreeMenuButton);
        theButton.put("button",theFirstMenuButton);
        return theButton.toString();
    }
}
