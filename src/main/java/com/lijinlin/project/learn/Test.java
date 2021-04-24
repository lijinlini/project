package com.lijinlin.project.learn;


import io.netty.util.NettyRuntime;

import java.util.*;

import static java.util.Objects.hash;

public class Test {
    public static void main(String[] args)  throws Exception{
      new Thread(()->{
          Test t = new Test();
          t.testMethod();

      }).start();

        new Thread(()->{
            Test t = new Test();
            t.testMethod();
        }).start();

        new Thread(()->{
            Test t = new Test();
            t.testMethod();
        }).start();
    }

    public void testMethod(){
        int a = 0;
        B b = new B();
    }

    class B{
        public B() {
        }

    }

}


