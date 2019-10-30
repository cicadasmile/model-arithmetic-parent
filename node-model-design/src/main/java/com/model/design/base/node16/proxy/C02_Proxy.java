package com.model.design.base.node16.proxy;
/**
 * 代理模式
 */
public class C02_Proxy {
    public static void main(String[] args) {
        AbstractObject object = new ProxyObject();
        object.operation();
    }
}
/**
 * 抽象对象角色
 */
abstract class AbstractObject{
    public abstract void operation();
}
/**
 * 目标对象角色
 */
class TargetObject extends AbstractObject{
    @Override
    public void operation() {
        System.out.println("Target Method Run...");
    }
}
/**
 * 代理对象角色
 */
class ProxyObject extends AbstractObject{
    TargetObject targetObject = new TargetObject();
    @Override
    public void operation() {
        System.out.println("Method Before...");
        targetObject.operation();
        System.out.println("Method After...");
    }
}
