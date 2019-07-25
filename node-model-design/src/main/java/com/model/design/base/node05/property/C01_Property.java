package com.model.design.base.node05.property;

/**
 * 基于JDK源码方式实现原型模式
 */
public class C01_Property {
    public static void main(String[] args) {
        Product product = new Product("机械键盘","白色",100.00) ;
        Product product1 = (Product) product.clone();
        Product product2 = (Product) product.clone();
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product1==product2);  // false
    }
}
class Product implements Cloneable {

    private String name ;
    private String color ;
    private Double price ;
    public Product(String name, String color, Double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    protected Object clone() {
        Product product = null ;
        try{
            product = (Product)super.clone() ;
        } catch (Exception e){
            e.printStackTrace();
        }
        return product ;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}