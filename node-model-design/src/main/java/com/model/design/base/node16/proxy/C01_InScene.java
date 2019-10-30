package com.model.design.base.node16.proxy;

/**
 * 代理模式下应用场景
 */
public class C01_InScene {
    public static void main(String[] args) {
        /*自己收快递的测试方式*/
        GetExpress getExpress = new GetExpress();
        getExpress.sureInfo();
        getExpress.signName("张三");
        /*代收快递的测试方式*/
        ExpressAct getUser = new GetExpress();
        ExpressAct getProxy = new ProxyExpress(getUser);
        getProxy.sureInfo();
        getProxy.signName("李四");
    }
}
/**
 * 接收一个快递的动作接口：确认信息，签名
 */
interface ExpressAct{
    void sureInfo();
    void signName(String name);
}
/**
 * 定义一个类接收快递:自己去拿快递
 */
class GetExpress implements ExpressAct{
    @Override
    public void sureInfo() {
        System.out.println("请确认你的个人信息！");
    }
    @Override
    public void signName(String name) {
        System.out.println("你的名字是："+name);
    }
}
/**
 * 定义一个类接收快递:找人代领快递
 */
class ProxyExpress implements ExpressAct{
    private ExpressAct expressAct=null;
    public ProxyExpress(ExpressAct expressAct){
        this.expressAct = expressAct;
    }
    @Override
    public void sureInfo() {
        this.expressAct.sureInfo();
    }
    @Override
    public void signName(String name) {
        this.expressAct.signName(name);
    }
}