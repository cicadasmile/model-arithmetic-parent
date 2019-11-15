package com.model.design.base.node18.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 */
public class C02_FlyWeight {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fly = factory.factoryMethod('c');
        fly.printState("One");
        fly = factory.factoryMethod('d');
        fly.printState("Two");
        fly = factory.factoryMethod('c');
        fly.printState("San");
        // 调用了三次工厂方法，只创建了两个对象
        factory.poolInfo();
    }
}
/**
 * 抽象享元角色类
 */
interface Flyweight {
    void printState (String state);
}
/**
 * 具体享元角色类
 */
class ConcreteFlyweight implements Flyweight {
    private Character innerState = null;
    public ConcreteFlyweight (Character state){
        this.innerState = state;
    }
    @Override
    public void printState(String state) {
        System.out.println("内部状态：" + this.innerState);
        System.out.println("外部状态：" + state);
    }
}
/**
 * 享元工厂角色类
 */
class FlyweightFactory {
    // 模拟数据池
    private Map<Character,Flyweight> pool = new HashMap<>();
    public Flyweight factoryMethod (Character state){
        //先从缓存中查找对象
        Flyweight fly = pool.get(state);
        if(fly == null){
            fly = new ConcreteFlyweight(state);
            pool.put(state, fly);
        }
        return fly;
    }
    public void poolInfo (){
        System.out.println("数据池："+pool);
    }
}