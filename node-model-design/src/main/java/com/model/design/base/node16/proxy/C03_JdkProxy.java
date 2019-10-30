package com.model.design.base.node16.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理实现AOP编程
 */
public class C03_JdkProxy {
    public static void main(String[] args) {
        BookService bookService = BookAopProxyFactory.createService() ;
        System.out.println(bookService.getBook());
    }
}
class BookAspect {
    public void before (){
        System.out.println("Method Before ...");
    }
    public void after (){
        System.out.println("Method After ...");
    }
}
interface BookService {
    String getBook () ;
}
class BookServiceImpl implements BookService {
    @Override
    public String getBook() {
        System.out.println("目标方法【getBook】被执行");
        return "高性能MySQL";
    }
}
class BookAopProxyFactory {
    public static BookService createService() {
        // 目标类
        final BookService bookService = new BookServiceImpl() ;
        // 切面类
        final BookAspect bookAspect = new BookAspect();
        /*
         * 代理类：将目标类（切入点）和 切面类（通知） 结合
         */
        BookService proxyBookService = (BookService) Proxy.newProxyInstance(
                BookAopProxyFactory.class.getClassLoader(),
                bookService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        // 前执行
                        bookAspect.before();
                        // 执行目标类的方法
                        Object obj = method.invoke(bookService, args);
                        // 后执行
                        bookAspect.after();
                        return obj;
                    }
                });
        return proxyBookService ;
    }
}