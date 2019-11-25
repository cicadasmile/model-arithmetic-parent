package com.model.design.base.node22.strategy;
/**
 * 策略模式
 */
public class C02_Strategy {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyB() ;
        Context context = new Context(strategy) ;
        context.userMethod();
    }
}
/** 环境角色类 */
class Context {
    //持有一个具体策略的对象
    private Strategy strategy;
    /**
     * 构造函数，传入一个具体策略对象
     * @param strategy    具体策略对象
     */
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void userMethod (){
        this.strategy.strategyMethod();
    }
}
/** 抽象策略类 */
interface Strategy {
    // 策略方法
    void strategyMethod () ;
}
/** 具体策略类 */
class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("策略A方法");
    }
}
class ConcreteStrategyB implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("策略B方法");
    }
}