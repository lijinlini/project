package com.lijinlin.project.learn.DesignPattern.composite;

public class Client {
    /**
     * java的集合类 hashMap用到了组合模式
     * @param args
     */

    public static void main(String[] args) {
        //从大到小创建对象
        OrganizationComponent university = new University("清华大学","中国顶级大学");

        OrganizationComponent computerCollege = new College("计算机学院", "计算机学院");

        OrganizationComponent infoEngineerCollege = new College("信息工程学院", "信息工程学院");

        //创建各个学院下面的系
        computerCollege.add(new Department("软件工程","软件工程不错"));
        computerCollege.add(new Department("网络工程","网络工程不错"));
        computerCollege.add(new Department("计算机科学与技术","计算机科学与技术不错"));

        infoEngineerCollege.add(new Department("通信工程","通信工程不好学"));
        infoEngineerCollege.add(new Department("通信工程","信息工程好学"));
        university.add(computerCollege);
        university.add(infoEngineerCollege);
        computerCollege.print();
    }
}
