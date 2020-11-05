package com.huang.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service//放入到容器中
public class UserService {

    //想要拿到provide-service提供的票，就要去注册中心拿到服务
    @Reference//引用,Pom坐标,可以定义路径相同的接口名
    TicketService TICKET_SERVICE;

    public void buyTicket(){
        String ticket=TICKET_SERVICE.getTicket();
        System.out.println("在在注册中心拿到=》"+ticket);
    }
}