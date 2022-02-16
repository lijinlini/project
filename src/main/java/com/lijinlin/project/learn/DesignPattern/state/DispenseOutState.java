package com.lijinlin.project.learn.DesignPattern.state;

/**
 * 奖品发完的状态
 * 当我们activity 改变成这个状态，抽奖活动结束
 */
public class DispenseOutState extends State {
    RaffleActivity raffleActivity;

    public DispenseOutState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发完了，请下次再参加");
    }

    @Override
    public Boolean raffle() {
        System.out.println("奖品发完了，请下次再参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发完了，请下次再参加");
  /*      System.out.println("抽奖活动结束");
        System.exit(0);*/
    }
}
