package com.model.structure.node03.linked;

import java.util.LinkedList;
import java.util.List;

public class M01_Linked {
    public static void main(String[] args) {
        List<User> userList = new LinkedList<>() ;
        User removeUser = new User(200,"Second") ;
        // 添加元素
        userList.add(new User(100,"First")) ;
        userList.add(removeUser) ;
        userList.add(new User(300,"Third")) ;
        System.out.println("初始化："+userList);
        // 修改元素
        userList.get(0).setUserName("Zero");
        System.out.println("修改后："+userList);
        // 删除元素
        userList.remove(removeUser) ;
        System.out.println("删除后："+userList);
    }
}
class User {
    private Integer userId ;
    private String userName ;
    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}