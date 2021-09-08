package com.sunyk.base.learn.day;

import com.alibaba.fastjson.JSON;
import com.sunyk.base.domain.EasyObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day20210907")
public class Day20210907 {

    /**
    * @Description: java泛型
     * java泛型实现是基于编译期的类型擦除，最终都会变成Object类型；
     * ArrayList是一种泛型示例；一种模型可以构建多种类型的ArrayList实例，而不需要每种类型，都构建一种模型
     * 具体实例 {@code com.sunyk.base.domain.Point }
    * @Param:
    * @return:
    * @Author: sun彦坤
    * @Date: 2021/9/7
    */

    /**
     * @Description: 通过接口将收到多种类型的数据，但是由于泛型的存在，可以一起接收处理
     * 那么既然Object可以实现效果，为什么要引入泛型？
     * 因为在明确了接收类型的情况下，Object可以通过强制类型转换获取到正确的对象，但是会有不知道的情况和误写的情况，编译时期会通过，但是运行期会类型错误；
     * 所以引入泛型，目的在编译期就能保证传入的类型是正确的，
     * 1、避免强制类型转换错误
     * 2、实现在编译器报错
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
