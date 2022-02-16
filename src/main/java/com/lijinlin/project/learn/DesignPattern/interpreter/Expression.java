package com.lijinlin.project.learn.DesignPattern.interpreter;

import java.util.HashMap;

public abstract class Expression {
    /**
     *     a + b - c
     *     解释公式和数值，key就是公式（表达式） 参数[a,b,c],value就是具体值
     *     HashMap{a=10,b=20}
     */

    public abstract int interpreter(HashMap<String,Integer> var);
}
