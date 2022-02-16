package com.lijinlin.project.learn.DesignPattern.state;

/**
 * 不能抽奖的状态不能抽奖但是可以扣积分
 */
public class NoRaffleState extends State{
    /**
     * 初始化时传入活动引用，扣除积分后改变其状态 （不能抽奖的状态）
     */
    RaffleActivity raffleActivity;

    public NoRaffleState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    /**
     * 当前状态可以扣积分，扣除后，将状态设置成可以抽奖的状态
     */
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功，您可以抽奖了");
        raffleActivity.setState(raffleActivity.getCanRaffleState());
    }

    /**
     * 当前状态不能抽奖
     * @return
     */
    @Override
    public Boolean raffle() {
        System.out.println("扣了积分才能抽奖哦");
        return false;
    }

    /**
     * 当前状态不能发奖品
     */
    @Override
    public void dispensePrize() {
        System.out.println("不能发奖品");
    }
}
