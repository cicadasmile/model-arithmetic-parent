package com.model.design.base.node01.singleton;
import org.junit.Test;

/**
 * 类级内部类里面创建对象实例
 */
public class C06_Singleton {
    @Test
    public void test01 (){
        SingletonDemo INSTANCE1 = SingletonDemo.INSTANCE ;
        SingletonDemo INSTANCE2 = SingletonDemo.INSTANCE ;
        System.out.println(INSTANCE1 == INSTANCE2);
        INSTANCE1.info();
        INSTANCE2.info();
    }
}
enum SingletonDemo {
    INSTANCE ;
    public void info (){
        System.out.println("枚举方式实现单例");
    }
}