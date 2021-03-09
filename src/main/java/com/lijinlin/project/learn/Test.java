package com.lijinlin.project.learn;


import java.util.*;

import static java.util.Objects.hash;

public class Test {
    public static void main(String[] args)  throws Exception{
        System.out.println(hash("帅丙"));
        System.out.println(hash("丙帅"));
        HashMap map=new HashMap();
       /*DeepProtoType p = new DeepProtoType();
       p.name="松江";
       p.deepCloneAbleTarget = new DeepCloneAbleTarget("大牛","大牛的类");
       //DeepProtoType p2 = (DeepProtoType)p.clone();
        DeepProtoType p2 = (DeepProtoType)p.deepClone();

       System.out.println("p.name" + p.name + "p.deepCloneableTarget="+p.deepCloneAbleTarget.hashCode());
       System.out.println("p2.name" + p2.name + "p2.deepCloneableTarget="+p2.deepCloneAbleTarget.hashCode());
       System.out.println("p.name" + p.name.hashCode() + "p.deepCloneableTarget="+p.deepCloneAbleTarget.hashCode());
       System.out.println("p2.name" + p2.name.hashCode() + "p2.deepCloneableTarget="+p2.deepCloneAbleTarget.hashCode());*/
    }

    private static List<Animal> sortPurchaseNum(List<Animal> list){
        List<Animal> preList = new ArrayList<>();
        List<Animal> behindList = new ArrayList<>();
        for(Animal purchaseApplyProduct : list){
            if(purchaseApplyProduct.getLegCount() == 0){
                preList.add(purchaseApplyProduct);
            }else{
                behindList.add(purchaseApplyProduct);
            }
        }
        preList.addAll(behindList);
        return preList;
    }
}


