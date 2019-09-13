package com.model.design.base.node11.observer;

import java.util.Observable;

public class C03_Observer_JDK {
    public static void main(String[] args) {
        //创建被观察者对象
        MsgSource msgSource = new MsgSource();
        //创建观察者对象，并将被观察者对象登记
        MsgConsumer watcher = new MsgConsumer(msgSource);
        msgSource.setData("Hello,Java");
        msgSource.setData("Bye Java");
    }
}
class MsgSource extends Observable {
    private String data = "";
    public String getData() {
        return data;
    }
    public void setData(String data) {
        if(!this.data.equals(data)){
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }
}
class MsgConsumer implements java.util.Observer {
    // 添加观察者
    public MsgConsumer(Observable msgSource){
        msgSource.addObserver(this);
    }
    // 状态获取
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("消息内容：" + ((MsgSource)o).getData());
    }
}
