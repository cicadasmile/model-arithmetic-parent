package com.model.design.spring.node04.abstractFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

/**
 * Spring框架中工厂方法测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-abstract-factory.xml"})
public class SpringTest {

    @Resource
    private BeanFactory beanFactory ;

    @Test
    public void test01 (){
        CarBean carBean = (CarBean)beanFactory.getBean("carBean") ;
        System.out.println(carBean.getName());
    }

    @Test
    public void test02 (){
        ApplicationContext context01 = new ClassPathXmlApplicationContext(
                "/spring/spring-abstract-factory.xml");
        CarBean carBean = (CarBean)context01.getBean("carBean1") ;
        System.out.println(carBean.getName());
    }
}
