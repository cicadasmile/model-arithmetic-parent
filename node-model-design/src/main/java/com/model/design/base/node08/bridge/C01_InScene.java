package com.model.design.base.node08.bridge;

/**
 * 桥接模式场景应用
 */
public class C01_InScene {
    public static void main(String[] args) {
        // 创建具体的实现对象
        MsgImplementor implementor = new SendBySMS() ;
        // 创建普通的消息对象
        AbstractMsg abstractMessage = new UserMsg(implementor);
        abstractMessage.sendMessage("您的账户异地登陆", "用户A0001");
        // 切换为邮件方式且加急处理
        implementor = new SendByEmail() ;
        abstractMessage = new AdminMsg(implementor);
        abstractMessage.sendMessage("项目上线通知", "运维S0001");
    }
}
/**
 * 封装消息类型
 */
abstract class AbstractMsg {
    // 持有一个实现部分的对象
    MsgImplementor impl ;
    public AbstractMsg (MsgImplementor impl){
        this.impl = impl ;
    }
    /**
     * 发送消息，委派给实现部分的方法
     * @param message    要发送消息的内容
     * @param toUser    消息的接受者
     */
    public void sendMessage (String message, String toUser){
        this.impl.send(message, toUser);
    }
}
class AdminMsg extends AbstractMsg{
    public AdminMsg(MsgImplementor impl) {
        super(impl);
    }
    @Override
    public void sendMessage(String message, String toUser) {
        message = "辛苦的管理员："+message;
        super.sendMessage(message, toUser);
    }
}
class UserMsg extends AbstractMsg{
    public UserMsg(MsgImplementor impl) {
        super(impl);
    }
    @Override
    public void sendMessage(String message, String toUser) {
        message = "尊敬的用户：" + message ;
        super.sendMessage(message, toUser);
    }
}

/**
 * 封装消息发送
 */
interface MsgImplementor {
    void send (String message , String toUser) ;
}
class SendBySMS implements MsgImplementor{
    @Override
    public void send(String message, String toUser) {
        System.out.println("短信通知:"+toUser+";内容："+message);
    }
}
class SendByEmail implements MsgImplementor{
    @Override
    public void send(String message, String toUser) {
        System.out.println("邮件通知:"+toUser+";内容："+message);
    }
}
