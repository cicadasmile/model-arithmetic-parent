package com.model.design.base.node02.factory;
/**
 * 简单工厂模式引入场景
 */
public class C01_InScene {
    public static void main(String[] args) {
        OrderFood1 orderFood = new OrderFood1() ;
        orderFood.orderFood("fish") ;
        orderFood.orderFood("chicken") ;
    }
}
/**
 * 订餐流程
 */
class OrderFood1 {
    public Food1 orderFood (String foodName){
        Food1 food1 = null ;
        if (foodName.equals("fish")){
            food1 = new FishFood1() ;
            food1.setName("黑鱼");
        } else if (foodName.equals("chicken")){
            food1 = new ChickenFood1() ;
            food1.setName("土鸡");
        }
        if (food1 != null){
            food1.foodMaterial();
            food1.cookFood();
            return food1 ;
        } else {
            return null ;
        }
    }
}
/**
 * 食物抽象类
 */
abstract class Food1 {
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
/**
 * 材料：黑鱼一条
 */
class FishFood1 extends Food1 {
    @Override
    public void foodMaterial() {
        System.out.println("材料：黑鱼一条");
    }
}
/**
 * 材料：土鸡一号
 */
class ChickenFood1 extends Food1 {
    @Override
    public void foodMaterial() {
        System.out.println("材料：土鸡一号");
    }
}
