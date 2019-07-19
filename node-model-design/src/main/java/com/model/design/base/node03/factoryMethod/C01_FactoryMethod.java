package com.model.design.base.node03.factoryMethod;

/**
 * 1、生活场景
 * 系统常见的数据导出功能：数据导出PDF、WORD等常见格式。
 *
 * 2、工厂方法模式是类的创建模式，又叫做虚拟构造子(Virtual Constructor)模式
 *    或者多态性工厂（Polymorphic Factory）模式。
 *    工厂方法模式的用意是定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类中。
 *
 * 3、核心角色
 * 1)、抽象工厂角色
 *    这个角色的是工厂方法模式的核心，任何在模式中创建对象的工厂类必须实现这个接口。
 *    在实际的系统中，这个角色也常常使用抽象类实现。
 *
 * 2)、具体工厂角色
 *    担任这个角色的是实现了抽象工厂接口的具体JAVA类。具体工厂角色含有与业务密切相关的逻辑，
 *    并且受到使用者的调用以创建导出类。
 *
 * 3)、抽象导出角色
 *    工厂方法模式所创建的对象的超类，也就是所有导出类的共同父类或共同拥有的接口。
 *    在实际的系统中，这个角色也常常使用抽象类实现。
 *
 * 4)、具体导出角色
 *    这个角色实现了抽象导出角色所声明的接口，
 *    工厂方法模式所创建的每一个对象都是某个具体导出角色的实例。
 *
 */
// 客户端角色
public class C01_FactoryMethod {
    public static void main(String[] args) {
        String data = "" ;
        ExportFactory factory = new ExportWordFactory () ;
        ExportFile exportWord = factory.factory("user-word") ;
        exportWord.export(data) ;
        factory = new ExportPdfFactory() ;
        ExportFile exportPdf =factory.factory("log-pdf") ;
        exportPdf.export(data) ;
    }
}
// 抽象工厂角色
interface ExportFactory {
    ExportFile factory (String type) ;
}
// 具体工厂角色
class ExportWordFactory implements ExportFactory {
    @Override
    public ExportFile factory(String type) {
        if ("user-word".equals(type)){
            return new ExportUserWordFile() ;
        } else if ("log-word".equals(type)){
            return new ExportLogWordFile() ;
        } else {
            throw new RuntimeException("没有找到对象") ;
        }
    }
}
class ExportPdfFactory implements ExportFactory {
    @Override
    public ExportFile factory(String type) {
        if ("user-pdf".equals(type)){
            return new ExportUserPdfFile() ;
        } else if ("log-pdf".equals(type)){
            return new ExportLogPdfFile() ;
        } else {
            throw new RuntimeException("没有找到对象") ;
        }
    }
}
// 抽象导出角色
interface ExportFile {
    boolean export (String data) ;
}
// 具体导出角色
class ExportUserWordFile implements ExportFile {
    @Override
    public boolean export(String data) {
        System.out.println("导出用户Word文件");
        return true;
    }
}
class ExportLogWordFile implements ExportFile {
    @Override
    public boolean export(String data) {
        System.out.println("导出日志Word文件");
        return true;
    }
}
class ExportUserPdfFile implements ExportFile {
    @Override
    public boolean export(String data) {
        System.out.println("导出用户Pdf文件");
        return true;
    }
}
class ExportLogPdfFile implements ExportFile {
    @Override
    public boolean export(String data) {
        System.out.println("导出日志Pdf文件");
        return true;
    }
}