package com.model.design.base.node01.singleton;
import org.junit.Test;
/**
 * 类级内部类里面创建对象实例
 */
public class C05_Singleton {
    /**
     * 类级内部类
     */
    private static class SingletonHolder {
        private static C05_Singleton lazySingleton = new C05_Singleton() ;
    }
    private static C05_Singleton getInstance (){
        return SingletonHolder.lazySingleton ;
    }
    @Test
    public void test01 (){
        C05_Singleton singleton1 = C05_Singleton.getInstance() ;
        C05_Singleton singleton2 = C05_Singleton.getInstance() ;
        /*
         * com.model.design.base.node01.singleton.C05_Singleton@10366b4
         * com.model.design.base.node01.singleton.C05_Singleton@10366b4
         */
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
