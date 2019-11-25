package com.model.design.base.node20.command;

/**
 * 生活场景
 */
public class C01_InScene {
    public static void main(String[] args) {
        TVClient tvClient = new TVClient() ;
        Remote remote = new RemoteApp(tvClient) ;
        UserClient userClient = new UserClient(remote) ;
        userClient.action("HM","换台");
    }
}
/**
 * 遥控接口
 */
interface Remote {
    void controlTV (String tvType,String task);
}
/**
 * 遥控器APP
 */
class RemoteApp implements Remote {
    private TVClient tvClient = null ;
    public RemoteApp (TVClient tvClient){
        this.tvClient = tvClient ;
    }
    @Override
    public void controlTV(String tvType, String task) {
        tvClient.action(tvType,task);
    }
}
/**
 * 用户端
 */
class UserClient {
    // 持有遥控器
    private Remote remote = null ;
    public UserClient (Remote remote){
        this.remote = remote ;
    }
    public void action (String tvType, String task){
        remote.controlTV(tvType,task);
    }
}
/**
 * 电视端
 */
class TVClient {
    public void action (String tvType, String task){
        System.out.println("TV品牌："+tvType+";执行："+task);
    }
}