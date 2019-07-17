package com.model.design.base.node02.factory;

/**
 * 简单工厂模式
 */
public class C02_SimpleFactory {
    public static void main(String[] args) {
        OrderFood2 orderFood2 = new OrderFood2() ;
        orderFood2.orderFood("chicken");
    }
}
class OrderFood2 {
    private SimpleFactory simpleFactory = new SimpleFactory() ;
    public void orderFood (String foodName){
        simpleFactory.orderFood(foodName) ;
    }
}
/**
 * 简单工厂类：封装食品的生产流程
 */
class SimpleFactory {
    public Food2 orderFood (String foodName){
        Food2 food2 = null ;
        if (foodName.equals("fish")){
            food2 = new FishFood2() ;
            food2.setName("黑鱼");
        } else if (foodName.equals("chicken")){
            food2 = new ChickenFood2() ;
            food2.setName("土鸡");
        }
        if (food2 != null){
            food2.foodMaterial();
            food2.cookFood();
            return food2 ;
        } else {
            return null ;
        }
    }
}
abstract class Food2 {
    protected String name ;
    public abstract void foodMaterial () ;
    public void cookFood (){
        System.out.println("食品烹饪：" + name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class FishFood2 extends Food2 {
    @Override
    public void foodMaterial() {
        System.out.println("材料：黑鱼一条");
    }
}
class ChickenFood2 extends Food2 {
    @Override
    public void foodMaterial() {
        System.out.println("材料：土鸡一号");
    }
}