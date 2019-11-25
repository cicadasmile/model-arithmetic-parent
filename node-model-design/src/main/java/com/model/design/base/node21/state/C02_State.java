package com.model.design.base.node21.state;

/**
 * 状态模式
 */
public class C02_State {
    public static void main(String[] args){
        Context context = new Context();
        State state = new ConcreteStateA() ;
        context.setState(state);
        context.printInfo("当前环境状态A");
        state = new ConcreteStateB();
        context.setState(state);
        context.printInfo("当前环境状态B");
    }
}
/**
 * 环境角色
 */
class Context {
    private State state;
    public void setState(State state) {
        this.state = state;
    }
    public void printInfo (String info) {
        state.stateInfo(info);
    }
}
/**
 * 抽象状态角色
 */
interface State {
    void stateInfo (String param);
}
/**
 * 具体状态角色
 */
class ConcreteStateA implements State {
    @Override
    public void stateInfo (String info) {
        System.out.println("ConcreteStateA：" + info);
    }
}
class ConcreteStateB implements State {
    @Override
    public void stateInfo (String info) {
        System.out.println("ConcreteStateB：" + info);
    }
}