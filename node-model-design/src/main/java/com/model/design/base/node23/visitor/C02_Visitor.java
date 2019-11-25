package com.model.design.base.node23.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者设计模式
 */
public class C02_Visitor {
    public static void main(String[] args) {
        ObjectStructure obs = new ObjectStructure();
        obs.add(new NodeA());
        obs.add(new NodeB());
        Visitor visitor = new VisitorA();
        obs.doAccept(visitor);
    }
}
/**
 * 抽象访问者角色
 */
interface Visitor {
    /**
     * NodeA的访问操作
     */
    void visit(NodeA node);
    /**
     * NodeB的访问操作
     */
    void visit(NodeB node);
}
/**
 * 具体访问者角色
 */
class VisitorA implements Visitor {
    @Override
    public void visit(NodeA node) {
        node.operationA() ;
    }
    @Override
    public void visit(NodeB node) {
        node.operationB() ;
    }
}
class VisitorB implements Visitor {
    @Override
    public void visit(NodeA node) {
        node.operationA() ;
    }
    @Override
    public void visit(NodeB node) {
        node.operationB() ;
    }
}
/**
 * 抽象节点角色
 */
abstract class Node {
    /**
     * 接收访问者
     */
    abstract void accept(Visitor visitor);
}
/**
 * 具体节点角色
 */
class NodeA extends Node{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void operationA(){
        System.out.println("NodeA.operationA");
    }
}
class NodeB extends Node{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void operationB(){
        System.out.println("NodeB.operationB");
    }
}
/**
 * 结构对象角色类
 */
class ObjectStructure {
    private List<Node> nodes = new ArrayList<>();
    public void detach(Node node) {
        nodes.remove(node);
    }
    public void add(Node node){
        nodes.add(node);
    }
    public void doAccept(Visitor visitor){
        for(Node node : nodes) {
            node.accept(visitor);
        }
    }
}