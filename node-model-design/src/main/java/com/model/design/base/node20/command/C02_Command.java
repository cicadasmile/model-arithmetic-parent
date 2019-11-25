package com.model.design.base.node20.command;
/**
 * 命令模式
 */
public class C02_Command {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action("卧倒");
    }
}
/**
 * 命令角色
 */
interface Command {
    // 执行方法
    void execute(String task);
}
/**
 * 具体命令角色类
 */
class ConcreteCommand implements Command {
    //持有相应的接收者对象
    private Receiver receiver = null;
    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute(String task) {
        //接收方来真正执行请求
        receiver.action(task);
    }
}
/**
 * 请求者角色类
 */
class Invoker {
    // 持有命令对象
    private Command command = null;
    public Invoker(Command command){
        this.command = command;
    }
    // 行动方法
    public void action(String task){
        command.execute(task);
    }
}
/**
 * 接收者角色类
 */
class Receiver {
    // 执行命令操作
    public void action(String task){
        System.out.println("执行命令："+task);
    }
}