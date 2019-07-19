package com.model.design.spring.node01.singleton;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Spring框架中单例模式
 */
public class SpringTest {
    @Test
    public void test01 (){
        ApplicationContext context01 = new ClassPathXmlApplicationContext("/spring/spring-singleton.xml");
        ApplicationContext context02 = new ClassPathXmlApplicationContext("/spring/spring-singleton.xml");
        UserBean user01 = (UserBean)context01.getBean("user") ;
        UserBean user02 = (UserBean)context01.getBean("user") ;
        UserBean user03 = (UserBean)context02.getBean("user") ;
        // com.model.design.spring.node01.singleton.UserBean@364841
        System.out.println(user01);
        // com.model.design.spring.node01.singleton.UserBean@364841
        System.out.println(user02);
        // com.model.design.spring.node01.singleton.UserBean@c4711c
        System.out.println(user03);
    }
}
