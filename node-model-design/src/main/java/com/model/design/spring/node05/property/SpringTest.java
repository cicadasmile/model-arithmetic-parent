package com.model.design.spring.node05.property;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring框架中原型模式测试
 */
public class SpringTest {

    @Test
    public void test01 (){
        ApplicationContext context01 = new ClassPathXmlApplicationContext(
                "/spring/spring-property.xml");
        // 原型模式
        Sheep sheep1 = (Sheep)context01.getBean("sheep01") ;
        Sheep sheep2 = (Sheep)context01.getBean("sheep01") ;
        System.out.println(sheep1==sheep2); // false
        // 单例模式
        Sheep sheep3 = (Sheep)context01.getBean("sheep02") ;
        Sheep sheep4 = (Sheep)context01.getBean("sheep02") ;
        System.out.println(sheep3==sheep4); // true
    }
}
