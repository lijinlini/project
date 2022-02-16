package com.lijinlin.project.learn.DesignPattern.responsibilitychain;

public abstract class Approver {
    /**
     *     下一个处理者
     */
    Approver approver;
    /*名字*/
    String name;

    public Approver(String name) {
        this.name = name;
    }
    /**
     *     下一个处理者
     */
    public void setApprover(Approver approver) {
        this.approver = approver;
    }
    /**
     *     处理审批请求的方法，得到一个请求，处理是子类完成，因此该方法做成抽象
     */
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
