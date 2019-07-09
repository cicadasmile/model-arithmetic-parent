package com.model.design.base.node01.singleton;

/**
 * JDK 单例模式分析
 */
public class C07_Singleton {
    public static void main(String[] args) {
        Runtime runtime1 = Runtime.getRuntime() ;
        Runtime runtime2 = Runtime.getRuntime() ;
        /*
         * 1229416514
         * 1229416514
         */
        System.out.println(runtime1.hashCode());
        System.out.println(runtime2.hashCode());
    }
}
