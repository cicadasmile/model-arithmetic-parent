package com.model.design.base.node10.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式-安全式
 */
public class C02_Security_Model {
    public static void main(String[] args) {
        Composite root = new Composite("服装");
        Composite composite1 = new Composite("男装");
        Leaf manCoat = new Leaf("上衣");
        Leaf manBottom = new Leaf("下衣");
        composite1.addChild(manCoat);
        composite1.addChild(manBottom);
        Composite composite2 = new Composite("女装");
        Leaf leaf1 = new Leaf("鞋子");
        Leaf leaf2 = new Leaf("帽子");
        root.addChild(leaf1);
        root.addChild(leaf2);
        root.addChild(composite1);
        root.addChild(composite2);
        root.printStruct("");
    }
}
// 抽象构件角色类
interface Component {
    /*
     * 输出组件自身的名称
     */
    void printStruct(String preStr);
}
// 树枝构件角色类
class Composite implements Component{
    // 用来存储组合对象中包含的子组件对象
    private List<Component> childComponents = new ArrayList<Component>();
    // 输出对象的名称
    private String name;
    // 构造方法，传入组合对象的名字
    public Composite (String name){
        this.name = name;
    }
    /**
     * 聚集管理方法，增加一个子构件对象
     * @param child 子构件对象
     */
    public void addChild(Component child){
        childComponents.add(child);
    }
    /**
     * 聚集管理方法，删除一个子构件对象
     * @param index 子构件对象的下标
     */
    public void removeChild(int index){
        childComponents.remove(index);
    }
    /**
     * 聚集管理方法，返回所有子构件对象
     */
    public List getChild(){
        return childComponents ;
    }
    /**
     * 输出对象的自身结构
     * @param preStr 前缀，主要是按照层级拼接空格，实现向后缩进
     */
    @Override
    public void printStruct(String preStr) {
        //先输出自己
        System.out.println(preStr+"+"+this.name);
        //如果还包含有子组件，那么就输出这些子组件对象
        if (this.childComponents != null){
            //添加两个空格，表示向后缩进两个空格
            preStr = preStr+"  ";
            //输出当前的子对象:使用函数递归的原理
            for (Component c : childComponents) {
                c.printStruct(preStr);
            }
        }
    }
}
class Leaf implements Component{
    // 输出叶子对象的名称
    private String name;
    // 构造方法，传入叶子对象的名称
    public Leaf (String name){
        this.name = name ;
    }
    /**
     * 输出叶子对象的结构，叶子对象没有子对象，也就是输出叶子对象的名字
     * @param preStr 前缀，主要是按照层级拼接的空格，实现向后缩进
     */
    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr+"-"+name);
    }
}