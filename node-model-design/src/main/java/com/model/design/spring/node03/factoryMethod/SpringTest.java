package com.model.design.spring.node03.factoryMethod;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring框架中工厂方法测试
 */
public class SpringTest {
    @Test
    public void test01 (){
        ApplicationContext context01 = new ClassPathXmlApplicationContext("/spring/spring-factorymethod.xml");
        CarEntity car1 = (CarEntity)context01.getBean("car1") ;
        CarEntity car2 = (CarEntity)context01.getBean("car2") ;
        System.out.println(car1);
        System.out.println(car2);
    }
}
