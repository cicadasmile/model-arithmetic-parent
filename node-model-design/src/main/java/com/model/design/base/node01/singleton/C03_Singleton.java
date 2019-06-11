package com.model.design.base.node01.singleton;

import org.junit.Test;

/**
 * 饿汉模式 : 空间换时间
 */
public class C03_Singleton {
    // 使用静态变量记录唯一实例
    private static C03_Singleton singleton = new C03_Singleton();
    public C03_Singleton (){}
    private static C03_Singleton getInstance (){
        return singleton ;
    }

    @Test
    public void test01 (){
        C03_Singleton singleton1 = C03_Singleton.getInstance() ;
        C03_Singleton singleton2 = C03_Singleton.getInstance() ;
        /*
         * com.model.design.base.node01.singleton.C03_Singleton@cabbaa
         * com.model.design.base.node01.singleton.C03_Singleton@cabbaa
         */
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
