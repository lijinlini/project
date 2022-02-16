package com.lijinlin.project.learn.DesignPattern.responsibilitychain;

public class CollegeApprover extends Approver{
    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() >5000 && purchaseRequest.getPrice() <= 10000){
            System.out.println(" 请求编号Id = " + purchaseRequest.getId() + "被" + this.name + "处理");
        }else{
            approver.processRequest(purchaseRequest);
        }
    }
}
