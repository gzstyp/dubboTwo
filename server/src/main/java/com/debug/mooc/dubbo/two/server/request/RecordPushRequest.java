package com.debug.mooc.dubbo.two.server.request;

import java.io.Serializable;

/**
 * 订单实体
 * @注意 本实体的字段要与被调用的字段要一致,否则会报错:org.codehaus.jackson.map.exc.UnrecognizedPropertyException: Unrecognized field &quot;itemTotal&quot; 未知的字段
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-03-22 4:25
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
public class RecordPushRequest implements Serializable{

    private Integer itemId;

    private Integer total;

    private String customerName;

    public Integer getItemId(){
        return itemId;
    }

    public void setItemId(Integer itemId){
        this.itemId = itemId;
    }

    public Integer getTotal(){
        return total;
    }

    public void setTotal(Integer total){
        this.total = total;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
}