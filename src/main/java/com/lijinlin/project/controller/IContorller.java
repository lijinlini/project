package com.lijinlin.project.controller;

import com.lijinlin.project.learn.Animal;
import com.lijinlin.project.learn.Person;
import com.lijinlin.project.learn.QuickSort;
import com.lijinlin.project.learn.grpc.JavaGrpcClient;
import com.lijinlin.project.service.PrototypeService;
import com.lijinlin.project.service.SingletionService;
import java_test.Request;
import java_test.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

@RestController
@Scope("prototype")
public class IContorller {
    @Resource
    private SingletionService singletionService;
    @Resource
    private PrototypeService prototypeService;
    @Resource
    private JavaGrpcClient javaGrpcClient;

    @RequestMapping("/hello")
    public String hello() {
        Request request = Request.newBuilder().setRequest1("test1").setRequest2("test2").build();
        Result result = javaGrpcClient.run(o -> o.method(request));
        return "hello,Sprintboot";
    }

    @RequestMapping("/test1")
    public void test1() {

        System.out.println(singletionService);
        System.out.println(prototypeService);
    }

    @RequestMapping("/getEnv")
    public String getEnv(@Value("${curvar}") String env) throws Exception {
       /* Properties properties = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\workspace\\self\\project\\src\\main\\resources\\bootstrap.properties"));
        properties.load(bufferedReader);
        properties.getProperty("maven.lijinlin.application.env");*/
        return "hello my current env is " + env;
    }

    @RequestMapping("/getOom")
    public void getOom() {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            stringBuilder.append(System.currentTimeMillis());
        }
    }


}
