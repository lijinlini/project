package com.lijinlin.project.learn.interview.circularDependence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//https://www.cnblogs.com/xiaoxing/p/10762686.html
public class NotBeSolvedSpringCircularDependence {
    private ApplicationContext applicationContext;

    @Before
    public void beforeApplicationContext() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(applicationContext);
    }

    @Test
    public void test(){

    }

    @After
    public void after(){
        if(applicationContext != null){
            ((ClassPathXmlApplicationContext)applicationContext).close();
        }
    }

}

class CirculationB{
    private CirculationA circulationA;

    public CirculationB(CirculationA circulationA) {
        this.circulationA = circulationA;
    }
    public CirculationB() {

    }

    public CirculationA getCirculationA() {
        return circulationA;
    }

    public void setCirculationA(CirculationA circulationA) {
        this.circulationA = circulationA;
    }
}
class CirculationA{
    private CirculationB circulationB;

    public CirculationA(CirculationB circulationB) {
        this.circulationB = circulationB;
    }
    public CirculationA() {

    }

    public CirculationB getCirculationB() {
        return circulationB;
    }

    public void setCirculationB(CirculationB circulationB) {
        this.circulationB = circulationB;
    }
}

