package com.lijinlin.project.learn.DesignPattern.state;

public class DispenseState extends State{
    RaffleActivity raffleActivity;

    public DispenseState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public Boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    /**
     * 发放奖品
     */
    @Override
    public void dispensePrize() {
        if(raffleActivity.getCount() > 0){
            System.out.println("恭喜中奖了");
            raffleActivity.setState(raffleActivity.getNoRafflleState());
        }else{
            System.out.println("很遗憾奖品发送完了");
            raffleActivity.setState(raffleActivity.getDispenseOutState());
        }
    }
}
