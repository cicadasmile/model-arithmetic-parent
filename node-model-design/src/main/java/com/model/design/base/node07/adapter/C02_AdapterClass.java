package com.model.design.base.node07.adapter;

/**
 * 类适配器模式
 */
public class C02_AdapterClass {
}
interface Target {

    void sampleOperation1();

    void sampleOperation2();
}
class Adaptee {
    public void sampleOperation1(){
        System.out.println("Adaptee.sampleOperation1()");
    }
}
class Adapter extends Adaptee implements Target{

    @Override
    public void sampleOperation2() {
        System.out.println("Adapter.sampleOperation2()");
    }
}