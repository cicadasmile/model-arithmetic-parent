package com.model.design.base.node21.state;

/**
 * 状态模式描述变色龙身体颜色的变化
 */
public class C01_InScene {
    public static void main(String[] args) {
        Chameleon chameleon = new Chameleon("红色","花丛环境") ;
        LifeContext lifeContext = new LifeContext() ;
        // 树叶环境
        BodyColor bodyColor = new GreenColor ();
        lifeContext.setBodyColor(bodyColor);
        lifeContext.change(chameleon);
        // 树枝环境
        bodyColor = new GrayColor() ;
        lifeContext.setBodyColor(bodyColor);
        lifeContext.change(chameleon);
    }
}
/**
 * 变色龙
 */
class Chameleon {
    public String color ;
    public String contextDesc ;
    public Chameleon(String color, String contextDesc) {
        this.color = color;
        this.contextDesc = contextDesc;
    }
}
/**
 * 变色龙生存环境
 */
class LifeContext {
    private BodyColor bodyColor;
    public void setBodyColor(BodyColor bodyColor) {
        this.bodyColor = bodyColor;
    }
    public void change (Chameleon chameleon){
        bodyColor.change(chameleon) ;
    }
}
/**
 * 变色龙身体颜色抽象类
 */
interface BodyColor {
    void change (Chameleon chameleon);
}
/**
 * 变色龙身体颜色具体类
 */
class GreenColor implements BodyColor {
    @Override
    public void change(Chameleon chameleon) {
        System.out.println("变化前："+chameleon.color+";"+chameleon.contextDesc);
        chameleon.contextDesc = "树叶环境" ;
        chameleon.color = "绿色" ;
        System.out.println("变化后："+chameleon.color+";"+chameleon.contextDesc);
    }
}
class GrayColor implements BodyColor {
    @Override
    public void change(Chameleon chameleon) {
        System.out.println("变化前："+chameleon.color+";"+chameleon.contextDesc);
        chameleon.contextDesc = "树枝环境" ;
        chameleon.color = "灰色" ;
        System.out.println("变化后："+chameleon.color+";"+chameleon.contextDesc);
    }
}