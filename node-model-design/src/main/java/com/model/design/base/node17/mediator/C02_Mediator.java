package com.model.design.base.node17.mediator;

/**
 * 调停者模式
 */
public class C02_Mediator {
    public static void main(String[] args) {

    }
}
/**
 * 抽象调停者类
 */
interface Mediator {
    void notify (Colleague colleague);
}
/**
 * 抽象同事类
 */
abstract class Colleague {
    /* 持有调停者对象 */
    private Mediator mediator;
    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
    public Mediator getMediator(){
        return mediator;
    }
}
/**
 * 具体调停者类
 */
class ConcreteMediator implements Mediator{
    private ConcreteColleagueA colleagueA ;
    private ConcreteColleagueB colleagueB ;
    public void setColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }
    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }
    @Override
    public void notify(Colleague colleague) {
        System.out.println("协调通知消息");
    }
}
/**
 * 具体同事类
 */
class ConcreteColleagueA extends Colleague{
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }
    public void operate(){
        getMediator().notify(this);
    }
}
class ConcreteColleagueB extends Colleague{
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }
    public void operation(){
        getMediator().notify(this);
    }
}
