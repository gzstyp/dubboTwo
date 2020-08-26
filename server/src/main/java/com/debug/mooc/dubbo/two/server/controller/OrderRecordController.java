package com.debug.mooc.dubbo.two.server.controller;

import com.debug.mooc.dubbo.two.server.request.RecordPushRequest;
import com.debug.mooc.dubbo.two.server.service.OrderRecordService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.Map;

/**用户下单服务,此处使用的是rest协议http请求,项目如果是异构的采用本方法,即异构了只能通过 http 来请求了
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-22 4:13
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@RestController
@RequestMapping(value = "/order")
public class OrderRecordController{

    private static final Logger Log = LoggerFactory.getLogger(OrderRecordController.class);

    @Autowired
    private OrderRecordService orderRecordService;

    /**
     * 面向客户：用户下单,使用json的数据格式交互,仅接收POST请求且是josn格式,基于rest协议http请求
     * url : http://127.0.0.1:8094/dubboTwo/order/pushRecord
     * @param 
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/3/22 4:25
    */
    @RequestMapping(value = "/pushRecord",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON)
    public Map<String,Object> pushRecord(@RequestBody RecordPushRequest pushRequest){
        final Map<String,Object> map = Maps.newHashMap();
        try {
            map.put("code","0");
            map.put("msg","操作成功");
            final String result = orderRecordService.pushRecord(pushRequest);
            map.put("data",result);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","操作失败");
            Log.error("面向客户：用户下单出现异常,",e.getMessage());
        }
        return map;
    }
}