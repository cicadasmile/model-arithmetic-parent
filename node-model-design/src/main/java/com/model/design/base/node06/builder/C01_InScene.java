package com.model.design.base.node06.builder;

/**
 * 基于建造者模式描述软件开发
 */
public class C01_InScene {
    public static void main(String[] args) {
        BuilderSoft builderSoft = new SoftImpl () ;
        ProjectManager manager = new ProjectManager(builderSoft) ;
        manager.createSoft();
    }
}

/**
 * 手机软件产品开发
 */
class MobileSoft {
    // 设计
    private String design ;
    // 架构
    private String frame ;
    // 开发
    private String develop ;
    // 上线
    private String online ;

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getDevelop() {
        return develop;
    }

    public void setDevelop(String develop) {
        this.develop = develop;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }
}
/**
 * 手机软件流程抽象类
 */
abstract class BuilderSoft {
    // 前期工作
    public abstract void earlyWork () ;
    // 中期工作
    public abstract void midWork () ;
    // 后期工作
    public abstract void lateWork () ;
    // 手机软件完成
    public abstract MobileSoft builderSoft () ;
}

/**
 * 手机软件具体实现
 */
class SoftImpl extends BuilderSoft {
    private MobileSoft mobileSoft = new MobileSoft();
    @Override
    public void earlyWork() {
        System.out.println("软件前期设计...");
    }

    @Override
    public void midWork() {
        System.out.println("软件中期架构...");
        System.out.println("软件中期开发...");
    }

    @Override
    public void lateWork() {
        System.out.println("软件后期上线...");
    }

    @Override
    public MobileSoft builderSoft() {
        return mobileSoft ;
    }
}

/**
 * 项目经理：把控项目进度
 */
class ProjectManager {
    private BuilderSoft builderSoft ;
    ProjectManager (BuilderSoft builderSoft){
        this.builderSoft = builderSoft ;
    }
    // 统筹项目周期
    public void createSoft (){
        builderSoft.earlyWork();
        builderSoft.midWork();
        builderSoft.lateWork();
        // MobileSoft mobileSoft = builderSoft.builderSoft() ;
        // return mobileSoft ;
    }
}