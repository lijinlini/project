package com.lijinlin.project.learn.DesignPattern.visitor;

/**
 * 1这里我们使用了双分派，首先在客户端程序中，将具体状态作为参数传递woman中.
 * 2然后women类调用作为参数的“具体方法”中方法getWomanResult，同时将自己（this）作为参数传入，完成第二次分派
 */
public class Women extends Person{
    @Override
    public void accept(Action action) {
        action.getWomenResult(this);
    }
}
