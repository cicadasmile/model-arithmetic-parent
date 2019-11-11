package com.model.design.base.node17.mediator;
/**
 * 生活场景
 */
public class C01_InScene {
    public static void main(String[] args) {
        Manager manager = new Manager() ;
        EmployeeA employeeA = new EmployeeA("张三",manager) ;
        EmployeeB employeeB = new EmployeeB("李四",manager) ;
        employeeA.sendMsg(employeeA.name,"需要产品文档",employeeB);
    }
}
/**
 * 部门协调接口
 */
interface Department {
    void coordinate (String userName,String msg,Employee employee) ;
}
/**
 * 部门经理
 */
class Manager implements Department {
    @Override
    public void coordinate (String userName,String msg,Employee employee) {
        System.out.println("经理接收【"+userName+"】的协调任务：" + msg);
        System.out.println("经理转发【"+userName+"】协调任务,@【"+employee.name+"】");
        employee.getMsg(userName,msg);
    }
}
/**
 * 员工抽象类
 */
abstract class Employee {
    public String name ;
    private Department department ;
    public Employee (String name,Department department){
        this.name = name ;
        this.department = department ;
    }
    public void getMsg (String userName,String msg){
        System.out.println("【"+this.name+"】收到"+"【"+userName+"】协调任务：["+msg+"]");
    }
    public void sendMsg (String name,String msg,Employee employee){
        System.out.println("【"+name+"】发起协调任务："+ msg);
        department.coordinate(name,msg,employee);
    }
}
/**
 * 具体员工
 */
class EmployeeA extends Employee {
    public EmployeeA(String name, Department department) {
        super(name, department);
    }
}
class EmployeeB extends Employee {
    public EmployeeB(String name, Department department) {
        super(name, department);
    }
}