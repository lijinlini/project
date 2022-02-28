package com.lijinlin.project.learn.grpc;

import org.junit.Test;
import java_test.Request;
import java_test.Result;
import org.junit.runner.RunWith;

import javax.annotation.Resource;


public class GrpcClientJavaTestApplicationTests {
    @Resource
    private JavaGrpcClient javaGrpcClient;
    @Test
    public void contextLoads(){
        Request request = Request.newBuilder().setRequest1("test1").setRequest2("test2").build();
        Result result = javaGrpcClient.run(o -> o.method(request));
    }
}
