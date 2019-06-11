package com.model.design.base.node01.singleton;
import org.junit.Test;
/**
 * 单例对象，且保证线程安全
 */
public class C02_Singleton {

    // 使用静态变量记录唯一实例
    private static C02_Singleton singleton = null;
    public C02_Singleton (){}
    // 控制线程安全，但是性能不好
    private static synchronized C02_Singleton getInstance (){
        if (singleton == null){
            singleton = new C02_Singleton() ;
        }
        return singleton ;
    }

    @Test
    public void test01 (){
        C02_Singleton singleton1 = C02_Singleton.getInstance() ;
        C02_Singleton singleton2 = C02_Singleton.getInstance() ;
        /*
         * com.model.design.base.node01.singleton.C02_Singleton@10366b4
         * com.model.design.base.node01.singleton.C02_Singleton@10366b4
         */
        System.out.println(singleton1);
        System.out.println(singleton2);
    }

}
