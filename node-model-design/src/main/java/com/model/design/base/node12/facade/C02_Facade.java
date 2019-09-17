package com.model.design.base.node12.facade;

/**
 * 源代码实现
 */
public class C02_Facade {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.clientNeed1();
        facade.clientNeed2();
    }
}
class ModuleA {
    public void testA (){
        System.out.println("ModuleA.testA()");
    }
}
class ModuleB {
    public void testB (){
        System.out.println("ModuleB.testB()");
    }
}
class ModuleC {
    public void testC (){
        System.out.println("ModuleC.testC()");
    }
}
class Facade {
    /**
     * 客户需求1
     */
    public void clientNeed1 (){
        ModuleA moduleA = new ModuleA();
        moduleA.testA();
        ModuleB moduleB = new ModuleB();
        moduleB.testB();
    }
    /**
     * 客户需求1
     */
    public void clientNeed2 (){
        ModuleB moduleB = new ModuleB();
        moduleB.testB();
        ModuleC moduleC = new ModuleC();
        moduleC.testC();
    }
}