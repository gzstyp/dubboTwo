package com.debug.mooc.dubbo.two.server.service;

import com.debug.mooc.dubbo.two.server.request.RecordPushRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.HashMap;

/**
 * 处理订单下单,基于rest协议http请求,项目如果是异构的采用本方法,即异构了只能通过 http 来请求了
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-22 4:55
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@Service//注意这个包名哦
public class OrderRecordService implements Serializable{

    private static final Logger Log = LoggerFactory.getLogger(OrderRecordService.class);

    private final String url_order = "http://127.0.0.1:9013/v1/orderRecord/pushOrder";

    /**
     * 处理controller层过来的用户下单数据,基于rest协议http请求
     * @作者 田应平
     * @版本 v1.0
     * @创建时间 2019/3/22 5:00
     * @QQ号码 444141300
     * @Email service@dwlai.com
     * @官网 http://www.fwtai.com
    */
    public String pushRecord(final RecordPushRequest pushRequest){
        final HashMap<String,String> header = new HashMap<String,String>();
        header.put("Content-Type","application/json");
        try {
            return ToolOkHttp.post(url_order,header,"application/json",pushRequest);
        } catch (Exception e) {
            Log.error("处理controller层过来的用户下单数据-出现异常",e.getMessage());
            return "{\"msg\":\"操作失败\",\"code\":-1}";
        }
    }
}