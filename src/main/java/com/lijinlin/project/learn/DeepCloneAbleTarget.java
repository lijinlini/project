package com.lijinlin.project.learn;

import java.io.Serializable;

public class DeepCloneAbleTarget implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private String cloneName;
    private String cloneClass;

    public DeepCloneAbleTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
