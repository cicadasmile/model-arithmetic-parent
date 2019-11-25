package com.model.design.base.node22.strategy;
/**
 * 每年双十一,各大电商平台会推出不同的满减策略,当用户的消费金额满一定额度后，会进行减去一定的优惠额度，
 * 从而来一波清仓甩卖,使用策略模式来描述该流程。
 */
public class C01_InScene {
    public static void main(String[] args) {
        // 选择满减策略,走相应的计算方式
        FullReduce strategy = new Full100 ();
        Payment price = new Payment(strategy);
        double quote = price.payment(300);
        System.out.println("最终价格为：" + quote);
    }
}
/**
 * 付款
 */
class Payment {
    private FullReduce fullReduce ;
    public Payment (FullReduce fullReduce){
        this.fullReduce = fullReduce ;
    }
    public double payment (double totalPrice){
        return this.fullReduce.getPayMoney(totalPrice) ;
    }
}
/**
 * 金额满减接口
 */
interface FullReduce {
    double getPayMoney (double totalPrice) ;
}
/**
 * 不同的满减策略
 */
class Full100 implements FullReduce {
    @Override
    public double getPayMoney(double totalPrice) {
        if (totalPrice >= 100){
            totalPrice = totalPrice-20.0 ;
        }
        return totalPrice ;
    }
}
class Full500 implements FullReduce {
    @Override
    public double getPayMoney(double totalPrice) {
        if (totalPrice >= 500){
            totalPrice = totalPrice-120.0 ;
        }
        return totalPrice ;
    }
}