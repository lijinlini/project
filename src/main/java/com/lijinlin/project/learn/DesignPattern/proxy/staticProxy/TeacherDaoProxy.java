package com.lijinlin.project.learn.DesignPattern.proxy.staticProxy;
//代理对象，静态代理
public class TeacherDaoProxy implements ITeacherDao{
    //目标对象，通过接口来聚合
    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {

        /**
         * 优点：在不修改目标对象的功能前提下，能通过代理对象对目标功能扩展
         * 缺点：因为代理对象需要与目标对象实现一样的接口，所以会有很多代理类，一旦接口增加方法，目标对象与代理对象都需要维护
         */
        System.out.println("代理开始 完成某些操作。。。。。");
        target.teach();
        System.out.println("代理结束。。。");
    }
}
