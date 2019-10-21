package com.model.design.base.node15.chain;

/**
 * 责任链模式
 */
public class C02_Chain {
    public static void main(String[] args) {
        // 组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setHandler(handler2);
        // 提交请求
        handler1.handlerRequest();

    }
}
/**
 * 抽象处理者角色
 */
abstract class Handler {
    /*
     * 持有后续的责任对象
     */
    protected Handler handler;
    /**
     * 处理请求的方法
     */
    public abstract void handlerRequest();

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}

/**
 * 具体处理者角色
 */
class ConcreteHandler extends Handler{
    /**
     * 调用该方法处理请求
     */
    @Override
    public void handlerRequest() {
        /*
         * 判断是否有后续的责任对象,没有就出来请求,有就直接放过
         */
        if(getHandler() != null){
            System.out.println("放过请求,下个对象处理...");
            getHandler().handlerRequest();
        } else{
            System.out.println("直接处理请求了...");
        }
    }
}
