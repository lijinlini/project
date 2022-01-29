package com.lijinlin.project.learn.DesignPattern.responsibilitychain;

public class DepartmentApprover extends Approver{
    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() <= 5000){
            System.out.println(" 请求编号Id = " + purchaseRequest.getId() + "被" + this.name + "处理");
        }else{
            approver.processRequest(purchaseRequest);
        }
    }
}
