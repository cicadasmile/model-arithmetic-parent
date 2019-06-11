package com.model.design.base.node01.singleton;
/**
 * 懒汉式加载 ：时间换空间
 */
public class C01_Singleton {
    private static C01_Singleton singleton = null;
    private C01_Singleton (){}
    private static C01_Singleton getInstance (){
        /*
         * 这里存在线程安全问题
         */
        if (singleton == null){
            singleton = new C01_Singleton() ;
        }
        return singleton ;
    }
    public static void main(String[] args) {
        C01_Singleton singleton1 = C01_Singleton.getInstance() ;
        C01_Singleton singleton2 = C01_Singleton.getInstance() ;
        /*
         * com.model.design.base.node01.singleton.C01_Singleton@1e579dc
         * com.model.design.base.node01.singleton.C01_Singleton@1e579dc
         */
        System.out.println(singleton1);
        System.out.println(singleton2);
    }

}
