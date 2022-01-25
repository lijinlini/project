package com.lijinlin.project.learn.DesignPattern.state;

/**
 * 状态抽象类
 */
public abstract class State {
    /**
     * 扣积分
     */
    public abstract void deductMoney();

    /**
     * 是否抽中奖品
     */
    public abstract Boolean raffle();

    /**
     * 发放奖品
     */
    public abstract void dispensePrize();
}
