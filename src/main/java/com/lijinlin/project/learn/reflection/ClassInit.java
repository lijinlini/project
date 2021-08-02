package com.lijinlin.project.learn.reflection;

public class ClassInit {
    static {
        System.out.println("Main类被加载");
    }

    public ClassInit() {
        System.out.println("Main类构造");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son = new Son();
        //反射也会产生主动引用
        //Class.forName("com.lijinlin.project.learn.reflection.Son");

        //不会产生类的引用方法
        //System.out.println(Son.b);

        //Son[] array = new Son[5];

        System.out.println(Son.M);

    }
}

class Father {
    static int b = 2;

    static {
        System.out.println("父类被加载");
    }

    public Father() {
        System.out.println("父类构造方法被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;

    public Son() {
        System.out.println("子类构造方法");
    }
}
