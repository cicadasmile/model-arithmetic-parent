package com.model.design.base.node19.template;

/**
 * 软件开发场景描述
 */
public class C01_InScene {
    public static void main(String[] args) {
        DevelopApp developApp = new DevelopApp() ;
        developApp.templateMethod() ;
    }
}
/**
 * 软件开发抽象类
 */
abstract class SoftDevelop {
    public void templateMethod(){
        //调用基本方法
        doBiz ();
        doProduct();
        doDevelop();
        doTest();
    }
    public abstract void doBiz () ;
    public abstract void doProduct () ;
    public abstract void doDevelop () ;
    public abstract void doTest () ;
}
/**
 * APP开发具体类
 */
class DevelopApp extends SoftDevelop {
    @Override
    public void doBiz() {
        System.out.println("整理App业务");
    }
    @Override
    public void doProduct() {
        System.out.println("输出App产品");
    }
    @Override
    public void doDevelop() {
        System.out.println("进行App开发");
    }
    @Override
    public void doTest() {
        System.out.println("进行App测试");
    }
}