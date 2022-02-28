package com.lijinlin.project.learn.grpc;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java_test.Request;
import java_test.Result;
import java_test.TestServiceGrpc;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class JavaGrpcServer extends TestServiceGrpc.TestServiceImplBase implements InitializingBean {
    @Override
    public void method(Request request, StreamObserver<Result> responseObserver) {
        Result result = Result.newBuilder().setResult1("result1").setResult2("result2").build();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ServerBuilder.forPort(8090)
                .addService(new JavaGrpcServer())
                .build()
                .start();
    }
}
