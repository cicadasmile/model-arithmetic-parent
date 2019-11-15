package com.model.design.base.node19.template;
/**
 * 模板方法模式
 */
public class C02_Template {
    public static void main(String[] args) {

    }
}
/**
 * 抽象模板角色
 */
abstract class AbstractTemplate {
    /**
     * 模板方法
     */
    public void templateMethod(){
        //调用基本方法
        abstractMethod();
        hookMethod();
        concreteMethod();
    }
    /**
     * 相关基本方法
     */
    protected abstract void abstractMethod();
    protected void hookMethod(){}
    private final void concreteMethod(){}
}
/**
 * 具体模板角色
 */
class ConcreteTemplate extends AbstractTemplate{
    /**
     * 基本方法的实现
     */
    @Override
    public void abstractMethod() {
    }
    /**
     * 重写父类的方法
     */
    @Override
    public void hookMethod(){
    }
}