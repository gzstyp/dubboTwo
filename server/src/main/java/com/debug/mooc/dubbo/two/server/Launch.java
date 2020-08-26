package com.debug.mooc.dubbo.two.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 服务消费者,dubboOne调用dubboTwo
 * 调用服务生产者步骤：
 * 1、在本项目的pom.xml引入生产服务方api的jar包;
 * 2、就是在本配置文件spring-dubbo.xml引入服务提供方提供的dubbo服务,含提供哪个服务名、url主机、协议、版本号、超时
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019年3月21日 20:50:06
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@SpringBootApplication
@ImportResource(value = {"classpath:spring/spring-jdbc.xml","classpath:spring/spring-dubbo.xml"})
@MapperScan(basePackages = "com.debug.mooc.dubbo.two.model.mapper")
@ComponentScan({"com.debug.mooc.dubbo.two"})
public class Launch extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(Launch.class);
    }

    public static void main(String[] args){
        SpringApplication.run(Launch.class,args);
        System.out.println("应用启动成功");
    }
}