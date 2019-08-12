package com.model.design.base.node07.adapter;

/**
 * 对象适配器模式
 */
public class C03_AdapterObject {
}
interface Target1 {
    void sampleOperation1();
    void sampleOperation2();
}
class Adaptee1 {
    public void sampleOperation1(){
        System.out.println("Adaptee.sampleOperation1()");
    }
}
class Adapter1 implements Target1 {
    private Adaptee1 adaptee ;
    public Adapter1 (Adaptee1 adaptee){
        this.adaptee = adaptee;
    }

    public void sampleOperation1() {
        this.adaptee.sampleOperation1();
    }

    @Override
    public void sampleOperation2() {
        System.out.println("Adapter.sampleOperation2()");
    }
}
