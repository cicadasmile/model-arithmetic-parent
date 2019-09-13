package com.model.design.base.node11.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者设计模式
 */
public class C01_Observer_Push {
    public static void main(String[] args) {
        // 创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        // 创建观察者对象
        Observer observer1 = new ConcreteObserver("观察者A");
        Observer observer2 = new ConcreteObserver("观察者B");
        // 注册观察者
        subject.attach(observer1);
        subject.attach(observer2);
        // 修改主题状态
        subject.change("New State ！");
        /**
         * 主题状态:New State ！
         *【观察者A】状态:New State ！
         *【观察者B】状态:New State ！
         */
    }
}
// 抽象主题角色
abstract class Subject {
    // 保存注册的观察者对象
    private List<Observer> list = new ArrayList<>();
    /**
     * 注册观察者对象
     */
    public void attach (Observer observer){
        list.add(observer);
        System.out.println("注册一个观察者:"+observer.getClass().getName());
    }
    /**
     * 删除观察者对象
     */
    public void delete (Observer observer){
        list.remove(observer);
        System.out.println("删除一个观察者:"+observer);
    }
    /**
     * 知所有注册的观察者对象
     */
    public void notifyObserver (String newState){
        for (Observer observer : list) {
            observer.update(newState);
        }
    }
}
// 具体主题角色
class ConcreteSubject extends Subject{
    private String state ;
    public String getState (){
        return state ;
    }
    public void change (String newState){
        state = newState;
        System.out.println("主题状态:"+state);
        //状态发生改变，通知各个观察者
        this.notifyObserver(state);
    }
}
// 抽象观察者角色
interface Observer {
    /**
     * 更新接口
     */
    void update(String state);
}
// 具体观察者角色
class ConcreteObserver implements Observer{
    private String name ;
    // 观察者状态
    private String observerState ;
    public ConcreteObserver (String name){
        this.name = name ;
    }
    /**
     * 更新观察者的状态，使其与目标的状态保持一致
     */
    @Override
    public void update(String state) {
        observerState = state ;
        System.out.println("【"+this.name+"】状态:"+observerState);
    }
}
