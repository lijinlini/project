package com.lijinlin.project.learn.DesignPattern.observer.normal.improve;

public interface Subject {
    public void registerObserver(Observer observer);

    public void removerObserver(Observer observer);

    public void notifyObservers();

}
