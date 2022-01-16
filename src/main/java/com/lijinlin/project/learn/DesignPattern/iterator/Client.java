package com.lijinlin.project.learn.DesignPattern.iterator;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<College> collegeArrayList = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();
        collegeArrayList.add(computerCollege);
        collegeArrayList.add(infoCollege);

        OutPutImpl outPutImpl = new OutPutImpl(collegeArrayList);
        outPutImpl.printCollege();
    }
}
