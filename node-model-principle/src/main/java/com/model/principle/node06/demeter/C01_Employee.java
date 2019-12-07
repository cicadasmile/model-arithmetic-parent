package com.model.principle.node06.demeter;

import java.util.ArrayList;
import java.util.List;

public class C01_Employee {
    public static void main(String[] args) {
        HeadCompanyEmpManage empManage = new HeadCompanyEmpManage() ;
        BranchCompanyEmpManage branchEmp = new BranchCompanyEmpManage() ;
        empManage.printEmp(branchEmp);
    }
}
/**
 * 总公司员工
 */
class HeadCompanyEmp {
    public String name ;
    public HeadCompanyEmp(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "HeadCompanyEmp{name='" + name + '}';
    }
}
/**
 * 分公司员工
 */
class BranchCompanyEmp {
    public String name ;
    public BranchCompanyEmp(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "BranchCompanyEmp{name='" + name + '}';
    }
}
/**
 * 分公司员工管理
 */
class BranchCompanyEmpManage {
    // 添加分公司员工
    public List<BranchCompanyEmp> addEmp (){
        List<BranchCompanyEmp> list = new ArrayList<>() ;
        for (int i = 1 ; i <= 3 ; i++){
            list.add(new BranchCompanyEmp("分公司员工"+i)) ;
        }
        return list ;
    }
    // 获取分公司员工
    public void printBranchCompanyEmp (){
        List<BranchCompanyEmp> list = addEmp () ;
        for (BranchCompanyEmp emp:list){
            System.out.println(emp);
        }
    }
}
/**
 * 总公司员工管理,基于迪米特原则,不出现陌生类
 */
class HeadCompanyEmpManage {
    // 添加总公司员工
    public List<HeadCompanyEmp> addHeadEmp (){
        List<HeadCompanyEmp> list = new ArrayList<>() ;
        for (int i = 1 ; i <= 3 ; i++){
            list.add(new HeadCompanyEmp("总公司员工"+i)) ;
        }
        return list ;
    }
    public void printEmp (BranchCompanyEmpManage empManage){
        // 打印分公司员工
        empManage.printBranchCompanyEmp();
        List<HeadCompanyEmp> headEmpList = addHeadEmp () ;
        for (HeadCompanyEmp headCompanyEmp:headEmpList){
            System.out.println(headCompanyEmp);
        }
    }
}