package com.model.design.base.node11.observer;

import java.util.ArrayList;
import java.util.List;

public class C02_Observer_Pull {
    public static void main(String[] args) {
        // 创建主题对象
        ConcreteSubject1 subject = new ConcreteSubject1();
        // 创建观察者对象
        Observer1 observer1 = new ConcreteObserver1("观察者A","JAVA");
        Observer1 observer2 = new ConcreteObserver1("观察者B","MySQL");
        // 注册观察者
        subject.attach(observer1);
        subject.attach(observer2);
        /*
         * 修改主题状态
         * 主题状态：JAVA State ！
         * 【观察者A】状态:JAVA State ！
         * 主题状态：MySQL State ！
         * 【观察者B】状态:MySQL State ！
         */
        subject.change("JAVA State ！","JAVA");
        subject.change("MySQL State ！","MySQL");
    }
}
abstract class Subject1 {
    // 保存注册的观察者对象
    private List<Observer1> list = new ArrayList<>();
    /**
     * 注册观察者对象
     */
    public void attach (Observer1 observer){
        list.add(observer);
    }
    /**
     * 删除观察者对象
     */
    public void delete (Observer1 observer){
        list.remove(observer);
        System.out.println("删除一个观察者:"+observer);
    }
    /**
     * 通知所有注册的观察者对象,传入消息的话题
     */
    public void notifyObservers (String msgTopic){
        for (Observer1 observer : list){
            observer.update(this);
        }
    }
}
class ConcreteSubject1 extends Subject1 {
    private String state ;
    private String msgTopic ;
    public String getState (){
        return state ;
    }
    public String getMsgTopic (){
        return msgTopic ;
    }
    public void change (String newState,String newMsgTopic){
        this.state = newState ;
        this.msgTopic = newMsgTopic ;
        System.out.println("主题状态："+state);
        this.notifyObservers(msgTopic);
    }
}

interface Observer1 {
    /**
     * 更新接口
     * @param subject 传入主题对象，方面获取相应的主题对象的状态
     */
    void update(Subject1 subject);
}
class ConcreteObserver1 implements Observer1{
    private String name ;
    // 选择话题
    private String msgTopic ;
    // 观察者状态
    private String observerState ;
    public ConcreteObserver1 (String name,String msgTopic){
        this.name = name ;
        this.msgTopic = msgTopic ;
    }
    @Override
    public void update(Subject1 subject) {
        ConcreteSubject1 concreteSubject1 = (ConcreteSubject1)subject ;
        // 只有指定话题才拉取消息
        if (concreteSubject1.getMsgTopic().equals(msgTopic)){
            observerState = concreteSubject1.getState();
            System.out.println("【"+this.name+"】状态:"+observerState);
        }
    }
}
