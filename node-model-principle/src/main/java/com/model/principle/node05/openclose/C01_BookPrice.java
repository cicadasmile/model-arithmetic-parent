package com.model.principle.node05.openclose;

public class C01_BookPrice {
    public static void main(String[] args) {
        ParityBook parityBook = new DiscountBook("Java",100.00) ;
        System.out.println(parityBook.getPrice());
    }
}
interface Book {
    String getName () ;
    Double getPrice () ;
}
/**
 * 平价书籍
 */
class ParityBook implements Book {
    private String name ;
    private Double price ;
    public ParityBook(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public String getName() {
        return this.name ;
    }
    @Override
    public Double getPrice() {
        return this.price ;
    }
}
/**
 * 打折数据扩展价格计算策略
 */
class DiscountBook extends ParityBook {
    public DiscountBook(String name, Double price) {
        super(name, price);
    }
    @Override
    public Double getPrice() {
        double oldPrice = super.getPrice();
        return oldPrice * 0.8 ;
    }
}