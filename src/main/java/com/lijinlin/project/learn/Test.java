package com.lijinlin.project.learn;


import java.util.*;

import static java.util.Objects.hash;

public class Test {
    public static void main(String[] args)  throws Exception{
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
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


