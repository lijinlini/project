package com.lijinlin.project.learn.DesignPattern.state;

import java.util.Random;

public class CanRaffleState extends State{
    RaffleActivity raffleActivity;

    public CanRaffleState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    /**
     * 已经扣除了积分，不能再扣了
     */
    @Override
    public void deductMoney() {
        System.out.println("已经扣取过积分了");
    }

    /**
     * 可以抽奖，抽完奖后，根据实际情况，改变成新的状态
     * @return
     */
    @Override
    public Boolean raffle() {
        System.out.println("正在抽奖");
        Random r = new Random();
        int num = r.nextInt(10);
        //百分之10中奖机会
        if(num == 0){
            return true;
        }else{
            System.out.println("没有抽中");
            return false;
        }
    }

    /**
     * 不能发奖品
     */
    @Override
    public void dispensePrize() {
        System.out.println("没有抽中,不能发方奖品");
    }
}
