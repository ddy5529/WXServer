package com.ddy.wxServer;

import com.ddy.wxServer.Utils.WeiXinInterface.GetWeiXinInterface;
import com.ddy.wxServer.Utils.WeiXinInterface.WeiXInMenuView;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@WebAppConfiguration
//@SpringBootTest
public class WXApplicationTests {

    /*
    * 使用MockServletContext来构建一个空的WebApplicationContext，这样我们创建的HelloController就可以在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中。
    * @author :翟永超
    * */
   /* private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        //mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        *//*
        * 在这个方法体内是比较拦截下的‘/say2’请求返回的内容是否是"Hello World"
		* *//*
//		mvc.perform(MockMvcRequestBuilders.get("/say2").accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("Hello World")));
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testAccessToken() {
        GetWeiXinInterface gat = new GetWeiXinInterface();
        System.out.println("获取到的Token值为：" + gat.GetToken());
    }

    @Test
    public void testWXIPAddress() {
        GetWeiXinInterface gat = new GetWeiXinInterface();
        System.out.println("获取到的微信IP地址为：" + gat.getWeiXinServerIPAddress());
    }

    //以下为微信的可用地址的ip的格式，jsonobject->map->list
    @Test
    public void testListToString() {
        List<String> list = new ArrayList<>();
        list.add("101.226.62.83");
        list.add("101.226.62.82");
        list.add("101.226.62.84");
        list.add("101.226.62.85/27");
        Map map = new HashMap();
        map.put("ip_list", list);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println("测试出的List在JSON中的值为：" + jsonObject.toString());
    }

    @Test
    public void testWeiXinMenuViewFormat() throws JSONException {
//        System.out.println("测试出的微信菜单的JSON串是"+ WeiXInMenuView.getMenuView());
        System.out.println("测试出的微信菜单的JSON串是" + WeiXInMenuView.getCreateMenuOnJSONString());
    }*/
}
