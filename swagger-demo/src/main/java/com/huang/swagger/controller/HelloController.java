package com.huang.swagger.controller;

import com.huang.swagger.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @ApiOperation("Hello控制类")
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    //只要我们的接口中，返回值存在实体类，他就会被扫描到swagger
    @PostMapping("/user")
    public User user() {//参数注释@ApiParam
        return new User();
    }

    @ApiOperation("Hello控制类2")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户") String username) {
        return "hello" + username;
    }

    @ApiOperation(value = "/hello3", notes = "测试hello3")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "str", value = "str", dataType = "string")
            , @ApiImplicitParam(paramType = "query", name = "age", value = "12", dataType = "Integer")})
    @GetMapping(value = "/hello3")
    public String hello3(String str, Integer age) {
        String s = str + ":" + age;
        return s;
    }


    @ApiOperation("postUser测试")
    @PostMapping("/postUser")
    public User postUser(@ApiParam("User实体类") User user){
        return user;
    }
}
