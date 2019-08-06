package com.model.design.base.node06.builder;

/**
 * 建造者模式代码
 */
public class C02_Builder {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.builderProduct();
        System.out.println(product.getAct1());
        System.out.println(product.getAct2());
    }
}
/**
 * 产品类
 */
class Product {
    /*定义一些产品的操作*/
    private String act1;
    private String act2;
    public String getAct1() {
        return act1;
    }
    public void setAct1(String act1) {
        this.act1 = act1;
    }
    public String getAct2() {
        return act2;
    }
    public void setAct2(String act2) {
        this.act2 = act2;
    }
}
/**
 * Builder 抽象建造者类
 */
abstract class Builder{
    public abstract void builderact1();
    public abstract void builderact2();
    public abstract Product builderProduct();
}
/**
 * 具体建造者类
 */
class ConcreteBuilder extends Builder{
    private Product product = new Product();
    @Override
    public void builderact1() {
        product.setAct1("操作一：执行...");
    }
    @Override
    public void builderact2() {
        product.setAct2("操作二：执行...");
    }
    @Override
    public Product builderProduct() {
        return product;
    }
}
/**
 *  Director 导演者类
 */
class Director{
    /*使用建造者抽象类*/
    private Builder builder;
    Director(Builder builder){
        this.builder = builder;
    }
    /*负责调用各个建造方法*/
    public void construct(){
        builder.builderact1();
        builder.builderact2();
    }
}
