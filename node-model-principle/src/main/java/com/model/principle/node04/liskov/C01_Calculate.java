package com.model.principle.node04.liskov;

public class C01_Calculate {
    public static void main(String[] args) {
        BizCalculate bizCalculate = new BizCalculate() ;
        System.out.println(bizCalculate.add(2,3)) ;
    }
}
class Calculate { }
class BaseCalculate extends Calculate {
    public int add (int a,int b){
        return a+b ;
    }
}
/**
 * 这里使用组合的方式完成计算
 */
class BizCalculate extends Calculate {
    private BaseCalculate baseCalculate = new BaseCalculate() ;
    public int add (int a,int b){
        return this.baseCalculate.add(a,b) ;
    }
}