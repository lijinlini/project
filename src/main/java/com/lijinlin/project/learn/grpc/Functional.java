package com.lijinlin.project.learn.grpc;

public interface Functional<Arg,Result> {
    Result run(Arg arg);
}
