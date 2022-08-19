package cn.yjhroot.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class ConcreteSubject implements Subject {
    /**
     * 观察者对象集合
     */
    private final List<Observer> observers;

    /**
     * 消息
     */
    private String message;

    /**
     * 构造方法 初始化被观察者集合
     */
    public ConcreteSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        // 调用每一个观察者的更新方法
        for (Observer observer : observers) {
            observer.update(this.message);
        }
    }

    @Override
    public void doSomething(String message) {
        this.message = message;
        notifyObservers();
    }
}
