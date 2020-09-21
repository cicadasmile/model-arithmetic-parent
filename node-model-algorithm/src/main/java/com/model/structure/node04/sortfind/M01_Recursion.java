package com.model.structure.node04.sortfind;

/**
 * 递归基础
 */
public class M01_Recursion {
    public static void main(String[] args) {
        printNum(3);
    }
    private static void printNum (int num){
        if (num > 1){
            printNum(num-1);
        }
        System.out.println("num="+num);
    }
}
