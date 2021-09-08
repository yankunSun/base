package com.sunyk.base.controller;

import com.alibaba.fastjson.JSON;
import com.sunyk.base.config.ShrioConfig;
import com.sunyk.base.domain.EasyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/come")
public class ControllerTest {
//    @Autowired
//    public  ShrioConfig shrioConfig;
//    @RequestMapping("/come")
//    public String getReturn(){
//        String config =  shrioConfig.getConfig();
//        System.out.println(config);
//        return  "进来了";
//    }


    /**
    * @Description:
    * @Param:
    * @return:
    * @Author: sun彦坤
    * @Date: 2021/9/7
    */
    @RequestMapping("/Hello")
    public String testGetList() {
        System.out.println("进入测试方法");
        return "Hello World!";

    }
    /** 
    * @Description: 测试post请求接收list对象 
    * @Param:  
    * @return:  
    * @Author: sun彦坤
    * @Date: 2021/9/7 
    */ 
    @PostMapping("/list")
    public void testGetList(@RequestBody Object[] list) {
        System.out.println("进入测试方法");
        for ( Object each : list
             ) {
            System.out.println(each);
        }

    }
    @PostMapping("/list2")
    public void testGetList2(@RequestBody List<Object> list) {
        System.out.println("进入测试方法");
        System.out.println(list.toString());
        System.out.println(JSON.parseObject(JSON.toJSONString(list.get(0)),EasyObject.class).toString());
        System.out.println(JSON.parseObject(JSON.toJSONString(list.get(1)),EasyObject.class).toString());
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));


    }

}
