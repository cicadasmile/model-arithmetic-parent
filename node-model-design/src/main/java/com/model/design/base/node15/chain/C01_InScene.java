package com.model.design.base.node15.chain;

/**
 * 责任链模式应用场景
 * 公司常见的请假审批流程：请假天数
 * 当 day<=3   天,项目经理审批
 * 当 3<day<=5 天,部门经理审批
 * 当 day> 5   天,CEO审批
 */
public class C01_InScene {
    public static void main(String[] args) {
        // 组装责任链
        AuditHandler h1 = new CeoManger();
        AuditHandler h2 = new DeptManger();
        AuditHandler h3 = new ProjectManger();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);
        /*
         * 测试输出
         * 项目经理无权审批
         * 部门经理无权审批
         * CEO审批：同意【Cicada】,请假【6】天
         */
        h3.handleLeaveDay("Cicada",6);
    }
}
abstract class AuditHandler {
    //持有下一个处理请求的对象
    protected AuditHandler successor = null;
    public AuditHandler getSuccessor() {
        return successor;
    }
    public void setSuccessor(AuditHandler successor) {
        this.successor = successor;
    }
    public abstract void handleLeaveDay (String user,Integer day);
}

/**
 * 项目经理审批
 */
class ProjectManger extends AuditHandler{

    @Override
    public void handleLeaveDay(String user, Integer day) {
        if (day <= 3){
            System.out.println("项目经理审批：同意【"+user+"】,请假【"+day+"】天");
        } else {
            System.out.println("项目经理无权审批");
            if (getSuccessor() != null){
                getSuccessor().handleLeaveDay(user,day);
            }
        }
    }
}
/**
 * 部门经理审批
 */
class DeptManger extends AuditHandler{

    @Override
    public void handleLeaveDay(String user, Integer day) {
        if (day > 3 && day <= 5){
            System.out.println("部门经理审批：同意【"+user+"】,请假【"+day+"】天");
        } else {
            System.out.println("部门经理无权审批");
            if (getSuccessor() != null){
                getSuccessor().handleLeaveDay(user,day);
            }
        }
    }
}

/**
 * CEO审批
 */
class CeoManger extends AuditHandler{
    @Override
    public void handleLeaveDay(String user, Integer day) {
        if (day > 5){
            System.out.println("CEO审批：同意【"+user+"】,请假【"+day+"】天");
        } else {
            if (getSuccessor() != null){
                getSuccessor().handleLeaveDay(user,day);
            }
        }
    }
}