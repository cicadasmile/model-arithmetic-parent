package com.model.design.base.node10.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式-透明式
 */
public class C03_Transparent_Model {
    public static void main(String[] args) {
        Component1 root = new Composite1("服装");
        Component1 c1 = new Composite1("男装");
        Component1 c2 = new Composite1("女装");
        Component1 leaf1 = new Leaf1("衬衫");
        Component1 leaf2 = new Leaf1("夹克");
        Component1 leaf3 = new Leaf1("裙子");
        Component1 leaf4 = new Leaf1("套装");
        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        c2.addChild(leaf4);
        root.printStruct("");
    }
}
abstract class Component1 {
    /**
     * 输出组件自身的名称
     */
    public abstract void printStruct(String preStr);
    // 聚集管理方法，增加一个子构件对象
    public void addChild(Component1 child){
        /**
         * 缺省实现，抛出异常，因为叶子对象没有此功能
         * 或者子组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持此功能");
    }
    // 聚集管理方法，删除一个子构件对象
    public void removeChild(int index){
        /**
         * 缺省实现，抛出异常，因为叶子对象没有此功能
         * 或者子组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持此功能");
    }
    // 聚集管理方法，返回所有子构件对象
    public List<Component1> getChild(){
        /**
         * 缺省实现，抛出异常，因为叶子对象没有此功能
         * 或者子组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持此功能");
    }
}
class Composite1 extends Component1 {
    // 用来存储组合对象中包含的子组件对象
    private List<Component1> childComponents = new ArrayList<Component1>();
    // 输出对象名称
    private String name ;
    public Composite1 (String name){
        this.name = name;
    }
    /**
     * 聚集管理方法，增加一个子构件对象
     * @param child 子构件对象
     */
    public void addChild(Component1 child){
        childComponents.add(child);
    }
    /**
     * 聚集管理方法，删除一个子构件对象
     * @param index 子构件对象的下标
     */
    public void removeChild(int index){
        childComponents.remove(index);
    }
    // 聚集管理方法，返回所有子构件对象
    public List<Component1> getChild(){
        return childComponents ;
    }
    /**
     * 输出对象的自身结构
     * @param preStr 前缀，主要是按照层级拼接空格，实现向后缩进
     */
    @Override
    public void printStruct(String preStr) {
        // 首先输出自己名称
        System.out.println(preStr+"+"+this.name);
        // 如果还包含有子组件，那么就输出这些子组件对象
        preStr = preStr + "  ";
        if (this.childComponents != null) {
            // 添加两个空格,表示向后缩进
            for (Component1 c : childComponents) {
                ////递归输出每个子对象
                c.printStruct(preStr);
            }
        }
    }
}
class Leaf1 extends Component1 {
    private String name;
    public Leaf1 (String name){
        this.name = name;
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
