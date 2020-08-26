package com.debug.mooc.dubbo.two.server.controller;

import com.debug.mooc.dubbo.one.api.response.BaseResponse;
import com.debug.mooc.dubbo.one.api.service.IDubboItemService;
import org.apache.curator.shaded.com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 服务消费者调用服务生产者,基于dubbo-rpc协议,项目如果是同构的采用本方法,即同构了直接通过实例对象.方法来调用啦
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-22 0:18
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@RestController
@RequestMapping("/item")
public class ItemController{

    private static final Logger Log = LoggerFactory.getLogger(ItemController.class);


    @Autowired//此处的iDubboItemService值在spring/spring-dubbo.xml的值方便与本处自动装配?尽量写成一致的
    private IDubboItemService iDubboItemService;

    /**
     * 商城列表查询,此处使用的是dubbo-rpc协议
     * url http://127.0.0.1:8094/dubboTwo/item/lists
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/3/22 0:36
    */
    @RequestMapping(value = "/lists",method = RequestMethod.GET)
    public Map<String,Object> lists(){
        final Map<String,Object> map = Maps.newHashMap();
        try {
            final BaseResponse baseResponse = iDubboItemService.listItems();//基于dubbo-rpc协议
            map.put("code","0");
            map.put("msg","操作成功");
            map.put("data",baseResponse);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","操作失败");
        }
        return map;
    }

}