package com.model.design.base.node24.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者设计模式
 */
public class C02_Memento {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("状态1:State01");
        caretaker.add(originator.saveStateMemento());
        originator.setState("状态2:State02");
        caretaker.add(originator.saveStateMemento());
        System.out.println("当前的状态是 =" + originator.getState());
        // 恢复状态
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("当前的状态是 =" + originator.getState());
    }
}
/**
 * 守护者对象
 */
class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();
    public void add(Memento memento) {
        mementoList.add(memento);
    }
    public Memento get (int index) {
        return mementoList.get(index);
    }
}
/**
 * 备忘录角色
 */
class Memento {
    private String state;
    public Memento(String state) {
        super();
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
/**
 * 发起人角色
 */
class Originator {
    private String state;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Memento saveStateMemento() {
        return new Memento(state);
    }
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}