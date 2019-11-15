package com.model.design.base.node18.flyweight;

/**
 * JDK应用场景
 */
public class C03_Integer {
    public static void main(String[] args) {
        Integer c1 = Integer.valueOf(127),c2 = Integer.valueOf(127) ;
        Integer c3 = new Integer(127),c4 = new Integer(127) ;
        boolean flag1 = c1==c2 ,flag2 = c2==c3,flag3 = c3==c4 ;
        // true;false;false
        System.out.println(flag1+";"+flag2+";"+flag3);
        Integer c5 = Integer.valueOf(222),c6=Integer.valueOf(222) ;
        // false
        System.out.println(c5==c6);
    }
}
