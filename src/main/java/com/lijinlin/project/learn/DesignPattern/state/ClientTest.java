package com.lijinlin.project.learn.DesignPattern.state;

public class ClientTest {
    public static void main(String[] args) {
        //创建活动对象，奖品池有1个奖品
        RaffleActivity activity = new RaffleActivity(1);
        //连续抽300次奖
        for (int i = 0; i < 30; i++) {
            System.out.println("--------第" + (i + 1) + "次抽奖--------");
            //参加抽奖，第一步点击扣除积分
            activity.debuctMondy();
            activity.raffle();
        }
    }
}
