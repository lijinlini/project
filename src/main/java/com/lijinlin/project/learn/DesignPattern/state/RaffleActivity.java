package com.lijinlin.project.learn.DesignPattern.state;

public class RaffleActivity {
    /**
     * state表示活动当前的状态，是变化的
     */
    State state = null;
    /**
     * 表示奖品数量
     */
    int count = 0;
    /**
     * 四个属性表示四个状态
     */
    State noRaffleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);
    State dispenseState = new DispenseState(this);
    State dispenseOutState = new DispenseOutState(this);

    /**
     * 初始化当前的状态
     * 1初始化当前的状态为noRafflleState（不能抽奖的状态）
     * 2初始化奖品的数量
     * @param count
     */
    public RaffleActivity(int count) {
        this.state = getNoRafflleState();
        this.count = count;
    }

    /**
     * 扣分，调用当前状态的deductMoney
     */
    public void debuctMondy(){
        state.deductMoney();
    }

    /**
     *抽奖
     */
    public void raffle(){
        /**
         * 如果当前的状态是抽奖成功
         */
        if(state.raffle()){
            /**
             * 领取奖品
             */
            state.dispensePrize();
        }
    }

    public State getState(){
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * 每领取一次奖品，数量要减少1
     * @return
     */
    public int getCount() {
        int curCount = count;
        count --;
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getNoRafflleState() {
        return noRaffleState;
    }

    public void setNoRafflleState(State noRafflleState) {
        this.noRaffleState = noRafflleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispenseOutState() {
        return dispenseOutState;
    }

    public void setDispenseOutState(State dispenseOutState) {
        this.dispenseOutState = dispenseOutState;
    }
}
