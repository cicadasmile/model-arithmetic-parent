package com.model.design.base.node01.singleton;

import org.junit.Test;

public class C04_Singleton {
    // 使用静态变量记录唯一实例
    // volatile可以确保当singleton被初始化后，多线程才可以正确处理
    // 被volatile修饰的变量的值，将不会被本地线程缓存
    // 对该变量读写都是直接操作共享内存，确保多个线程能正确的处理该变量。
    private static volatile C04_Singleton singleton = null ;
    public C04_Singleton (){}
    private static C04_Singleton getInstance (){
        // 如果实例不存在，则进入同步区
        if (singleton == null){
            // 只有第一次才会彻底执行这里面的代码
            synchronized (C04_Singleton.class) {
                if (singleton == null){
                    singleton = new C04_Singleton() ;
                }
            }
        }
        return singleton ;
    }

    @Test
    public void test01 (){
        C04_Singleton singleton1 = C04_Singleton.getInstance() ;
        C04_Singleton singleton2 = C04_Singleton.getInstance() ;
        /*
         * com.model.design.base.node01.singleton.C04_Singleton@cabbaa
         * com.model.design.base.node01.singleton.C04_Singleton@cabbaa
         */
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
