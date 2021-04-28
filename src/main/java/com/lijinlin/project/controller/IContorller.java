package com.lijinlin.project.controller;

import com.lijinlin.project.service.PrototypeService;
import com.lijinlin.project.service.SingletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

@RestController
@Scope("prototype")
public class IContorller {
    @Autowired
    private SingletionService singletionService;
    @Autowired
    private PrototypeService prototypeService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello,Sprintboot";
    }

    @RequestMapping("/test1")
    public void test1(){

       System.out.println(singletionService);
       System.out.println(prototypeService);
    }

    @RequestMapping("/getEnv")
    public String getEnv(@Value("${curvar}") String env) throws Exception{
       /* Properties properties = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\workspace\\self\\project\\src\\main\\resources\\bootstrap.properties"));
        properties.load(bufferedReader);
        properties.getProperty("maven.lijinlin.application.env");*/
        return "hello my current env is " + env;
    }


}