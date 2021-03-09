package com.lijinlin.project.learn.DesignPattern.prototype;

import com.lijinlin.project.learn.DeepCloneAbleTarget;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//原型模式 用来拷贝
public class DeepProtoType implements Serializable,Cloneable {
    public String name;
    public DeepCloneAbleTarget deepCloneAbleTarget;
    public DeepProtoType(){
        super();
    }
    //深拷贝方式1使用克隆方法
    @Override
    protected Object clone() throws CloneNotSupportedException{
        Object deep = null;
        //基本数据类型和string的克隆
        deep = super.clone();
        //对引用类型的属性进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType)deep;
        deepProtoType.deepCloneAbleTarget = (DeepCloneAbleTarget)deepCloneAbleTarget.clone();
        return deep;
    }

    //深拷贝-方式2通过对象的序列化实现（推荐）
    public Object deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try{
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//当前这个对象以对象流的方式输出

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType)ois.readObject();
            return copyObj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            //关闭流
            try{
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
