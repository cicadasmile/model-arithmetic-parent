package com.model.design.base.node04.abstractFactory;

/**
 * 抽象工厂模式
 */
public class C01_AbstractFactory {
    public static void main(String[] args) {
        CarProductFactory factory = new ChinaCarFactory() ;
        factory.getCar("hq") ;
        factory = new GermanyCarFactory () ;
        factory.getCar("ad") ;
    }
}

// 汽车生产抽象工厂
interface CarProductFactory {
    CarProduct getCar (String type) ;
}
// 中国汽车工厂
class ChinaCarFactory implements CarProductFactory {
    @Override
    public CarProduct getCar(String type) {
        CarProduct product = null ;
        if ("hq".equals(type)){
            product = new HQCar() ;
            product.name="红旗一号" ;
            product.date="1999-09-19" ;
            product.material();
            product.origin();
        } else if ("df".equals(type)){
            product = new DFCar() ;
            product.name="东风一号" ;
            product.date="2019-09-19" ;
            product.material();
            product.origin();
        }
        return product ;
    }
}
// 德国汽车工厂
class GermanyCarFactory implements CarProductFactory {
    @Override
    public CarProduct getCar(String type) {
        CarProduct product = null ;
        if ("ad".equals(type)){
            product = new ADCar() ;
            product.name="奥迪A8" ;
            product.date="2017-09-19" ;
            product.material();
            product.origin();
        } else if ("bm".equals(type)){
            product = new BMCar() ;
            product.name="宝马X8" ;
            product.date="2018-09-19" ;
            product.material();
            product.origin();
        }
        return product ;
    }
}
// 汽车生产抽象类
abstract class CarProduct {
    /**
     * 汽车名称
     */
    protected String name ;
    /**
     * 生产日期
     */
    protected String date ;
    /**
     * 材料
     */
    abstract void material () ;
    /**
     * 产地
     */
    abstract void origin () ;
}
// 红旗车
class HQCar extends CarProduct {
    @Override
    void material() {
        System.out.println(super.name+"材料...");
    }
    @Override
    void origin() {
        System.out.println(super.date+":"+super.name+"在中国北京生产");
    }
}
// 东风车
class DFCar extends CarProduct {
    @Override
    void material() {
        System.out.println(super.name+"材料...");
    }
    @Override
    void origin() {
        System.out.println(super.date+":"+super.name+"在中国南京生产");
    }
}
// 奥迪车
class ADCar extends CarProduct {
    @Override
    void material() {
        System.out.println(super.name+"材料...");
    }
    @Override
    void origin() {
        System.out.println(super.date+":"+super.name+"在德国柏林生产");
    }
}
// 宝马车
class BMCar extends CarProduct {
    @Override
    void material() {
        System.out.println(super.name+"材料...");
    }
    @Override
    void origin() {
        System.out.println(super.date+":"+super.name+"在德国慕尼黑生产");
    }
}