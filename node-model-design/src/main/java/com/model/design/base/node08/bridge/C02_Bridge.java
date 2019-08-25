package com.model.design.base.node08.bridge;

/**
 * 桥接模式封装
 */
public class C02_Bridge {
    public static void main(String[] args) {

    }
}
abstract class Abstraction {
    private Implementor implementor  ;
    public Abstraction (Implementor implementor){
        this.implementor = implementor ;
    }
    // 实例方法
    public void operation (){
        implementor.operationImpl();
    }
}
class RefinedAbstraction extends Abstraction{
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }
    //其他的操作方法
    public void otherOperation(){
    }
}
abstract class Implementor {
    // 示例方法，实现抽象部分需要的某些具体功能
    public abstract void operationImpl () ;
}
class ConcreteImplementorA extends Implementor{
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorA.operationImpl()");
    }
}
class ConcreteImplementorB extends Implementor{
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorB.operationImpl()");
    }
}
