package com.model.design.base.node12.facade;

/**
 * 外观模式描述饭店就餐流程
 */
public class C01_InScene {
    public static void main(String[] args) {
        EatAppFacade eatAppFacade = new EatAppFacade () ;
        eatAppFacade.dining();
    }
}
// 预定
class Booking {
    private static Booking booking = new Booking() ;
    public static Booking getInstance (){
        return booking ;
    }
    public void bookPlace (){
        System.out.println("位置预定...");
    }
}
// 点餐
class TakeOrder {
    private static TakeOrder takeOrder = new TakeOrder ();
    public static TakeOrder getInstance (){
        return takeOrder ;
    }
    public void orderDishes (){
        System.out.println("点餐...");
    }
}
// 付款
class Payment {
    private static Payment payment = new Payment () ;
    public static Payment getInstance (){
        return payment ;
    }
    public void payMoney (){
        System.out.println("结账...");
    }
}
// 点餐APP
class EatAppFacade {
    private Booking booking ;
    private TakeOrder takeOrder ;
    private Payment payment ;
    public EatAppFacade (){
        this.booking = Booking.getInstance() ;
        this.takeOrder = TakeOrder.getInstance() ;
        this.payment = Payment.getInstance() ;
    }
    // 就餐流程
    public void dining (){
        booking.bookPlace();
        takeOrder.orderDishes();
        payment.payMoney();
    }
}