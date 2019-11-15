package com.model.design.base.node18.flyweight;

/**
 * 享元模式使用
 */
public class C01_InScene {
    public static void main(String[] args) {
        String c0 = "cicada" ;
        String c1 = "cicada" ;
        System.out.println(c0 == c1); // true
    }
}
