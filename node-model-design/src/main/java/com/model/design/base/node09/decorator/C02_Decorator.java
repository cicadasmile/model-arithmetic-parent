package com.model.design.base.node09.decorator;

/**
 * 装饰模式源码模式
 */
public class C02_Decorator {
    public static void main(String[] args) {

    }
}
// 抽象构件角色
interface Component {
    void sampleOperation();
}
// 具体构件角色
class ConcreteComponent implements Component{
    @Override
    public void sampleOperation() {
        System.out.println("业务相关代码");
    }
}
//装饰角色
class Decorator implements Component{
    private Component component;
    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public void sampleOperation() {
        //委派给构件进行处理
        component.sampleOperation();
    }
}
// 具体装饰角色
class ConcreteDecoratorA extends Decorator{
    public ConcreteDecoratorA(Component component) {
        super(component);
    }
    @Override
    public void sampleOperation() {
        super.sampleOperation();
        System.out.println("A.处理相关业务的代码");
    }
}
class ConcreteDecoratorB extends Decorator{
    public ConcreteDecoratorB(Component component) {
        super(component);
    }
    @Override
    public void sampleOperation() {
        super.sampleOperation();
        System.out.println("B.处理相关业务方法");
    }
}
