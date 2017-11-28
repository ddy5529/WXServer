package com.ddy.wxServer.Controller;


import com.ddy.wxServer.Model.message.Menu;
import com.ddy.wxServer.Server.MenuService;
import com.ddy.wxServer.Thread.AccessTokenThread;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 对订阅号的菜单的操作
 *
 */

@RestController
@RequestMapping("/menu")

public class MenuController {
    @Autowired
    private MenuService menuService;


    private static Logger log = LoggerFactory.getLogger(MenuController.class);

    //查询全部菜单
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getMenu() {
        // 调用接口获取access_token
        String at = AccessTokenThread.accessToken.getToken();
        JSONObject jsonObject =null;
        if (at != null) {
            // 调用接口查询菜单
            jsonObject = menuService.getMenu(at);
            // 判断菜单创建结果
            return String.valueOf(jsonObject);
        }
        log.info("token为"+at);
        return "无数据";
    }

    //创建菜单
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public int createMenu() {
        // 调用接口获取access_token
        String at = AccessTokenThread.accessToken.getToken();
        int result=0;
        if (at != null) {

            // 调用接口创建菜单
            result = menuService.createMenu(getFirstMenu(),at);
            // 判断菜单创建结果
            if (0 == result) {
                log.info("菜单创建成功！");
            } else {
                log.info("菜单创建失败，错误码：" + result);
            }
        }
        return result ;
    }

    //删除菜单
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public int deleteMenu() {
        // 调用接口获取access_token
        String at = AccessTokenThread.accessToken.getToken();
        int result=0;
        if (at != null) {
            // 删除菜单
            result = menuService.deleteMenu(at);
            // 判断菜单删除结果
            if (0 == result) {
                log.info("菜单删除成功！");
            } else {
                log.info("菜单删除失败，错误码：" + result);
            }
        }
        return  result;
    }




    /**
     * 组装菜单数据
     */
    public static Map<String, Object> getFirstMenu(){
        //第一栏菜单
        Menu menu1=new Menu();
        menu1.setId("1100");
        menu1.setName("主菜单");//第一栏
        menu1.setType("click");
        menu1.setKey("menu_secret_main_page");

        Menu menu11=new Menu();
        menu11.setId("1101");
        menu11.setName("我的界面");//第一栏的第一个v3
        menu11.setType("click");
        menu11.setKey("menu_secret_mypage");

        Menu menu12=new Menu();
        menu12.setId("1102");
        menu12.setName("操作菜单");//第一栏的第二个
        menu12.setType("click");
        menu12.setKey("menu_secret_control_menu");

        //第二栏
        Menu menu2=new Menu();
        menu2.setId("1200");
        menu2.setName("投票");//第二栏
        menu2.setType("click");
        menu2.setKey("menu_secret_vote");

        Menu menu21=new Menu();
        menu21.setId("1201");
        menu21.setName("专项资金项目实施部");//第二栏的第一个
        menu21.setType("view");
        menu21.setUrl("https://12/ddy5529");

        Menu menu3=new Menu();
        menu3.setId("1300");
        menu3.setName("其他");//第三栏
        menu3.setType("click");
        menu3.setKey("menu_secret_else");

        Menu menu31=new Menu();
        menu31.setId("1301");
        menu31.setName("开源项目");//第三栏第一个
        menu31.setType("view");
        menu31.setUrl("https://github.com/ddy5529");

        Menu menu32=new Menu();
        menu32.setId("1302");
        menu32.setName("作者简介");//第三栏第二个
        menu32.setType("click");
        menu32.setKey("menu_secret_else_author");

        Menu menu33=new Menu();
        menu33.setId("1303");
        menu33.setName("赞一下");//第三栏第二个
        menu33.setType("click");
        menu33.setKey("menu_secret_praise_key");

        //最外一层大括号
        Map<String, Object> wechatMenuMap = new HashMap<String, Object>();

        //包装button的List
        List<Map<String, Object>> wechatMenuMapList = new ArrayList<Map<String, Object>>();

        //包装第一栏
        Map<String, Object> menuMap1 = new HashMap<String, Object>();
        Map<String, Object> menuMap11 = new HashMap<String, Object>();
        Map<String, Object> menuMap12 = new HashMap<String, Object>();
        List<Map<String, Object>> subMenuMapList1 = new ArrayList<Map<String, Object>>();

        //第一栏第一个
        menuMap11.put("name",menu11.getName());
        menuMap11.put("type",menu11.getType());
        menuMap11.put("key",menu11.getKey());
        subMenuMapList1.add(menuMap11);

        //第二栏第二个
        menuMap12.put("name",menu12.getName());
        menuMap12.put("type",menu12.getType());
        menuMap12.put("key",menu12.getKey());
        subMenuMapList1.add(menuMap12);

        menuMap1.put("name",menu1.getName());
        menuMap1.put("sub_button",subMenuMapList1);

        //包装第二栏
        Map<String, Object> menuMap2 = new HashMap<String, Object>();
        Map<String, Object> menuMap21 = new HashMap<String, Object>();
        List<Map<String, Object>> subMenuMapList2 = new ArrayList<Map<String, Object>>();

        //第二栏第一个
        menuMap21.put("name",menu21.getName());
        menuMap21.put("type",menu21.getType());
        menuMap21.put("key",menu21.getKey());
        subMenuMapList2.add(menuMap21);

        menuMap2.put("name",menu2.getName());
        menuMap2.put("sub_button",subMenuMapList2);

        //包装第三栏
        Map<String, Object> menuMap3 = new HashMap<String, Object>();
        Map<String, Object> menuMap31 = new HashMap<String, Object>();
        Map<String, Object> menuMap32 = new HashMap<String, Object>();
        Map<String, Object> menuMap33 = new HashMap<String, Object>();
        List<Map<String, Object>> subMenuMapList3 = new ArrayList<Map<String, Object>>();

        menuMap31.put("name",menu31.getName());
        menuMap31.put("type",menu31.getType());
        menuMap31.put("url",menu31.getUrl());
        subMenuMapList3.add(menuMap31);

        menuMap32.put("name",menu32.getName());
        menuMap32.put("type",menu32.getType());
        menuMap32.put("key",menu32.getKey());
        subMenuMapList3.add(menuMap32);

        menuMap33.put("name",menu33.getName());
        menuMap33.put("type",menu33.getType());
        menuMap33.put("key",menu33.getKey());
        subMenuMapList3.add(menuMap33);

        menuMap3.put("name",menu3.getName());
        menuMap3.put("sub_button",subMenuMapList3);

        wechatMenuMapList.add(menuMap1);
        wechatMenuMapList.add(menuMap2);
        wechatMenuMapList.add(menuMap3);
        wechatMenuMap.put("button",wechatMenuMapList);
        return  wechatMenuMap;
    }
}