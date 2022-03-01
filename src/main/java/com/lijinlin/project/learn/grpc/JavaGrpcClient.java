package com.lijinlin.project.learn.grpc;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import java_test.TestServiceGrpc;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class JavaGrpcClient {
    private Channel channel = channel();

    public <Result> Result run(Functional<TestServiceGrpc.TestServiceBlockingStub,Result> functional){
        TestServiceGrpc.TestServiceBlockingStub testServiceBlockingStub = TestServiceGrpc.newBlockingStub(channel);
        testServiceBlockingStub.withDeadlineAfter(1,TimeUnit.SECONDS);
        return functional.run(testServiceBlockingStub);
    }

    private Channel channel(){
        return ManagedChannelBuilder
                .forAddress("127.0.0.1",8090)
                .usePlaintext(true)
                .build();
    }
}
