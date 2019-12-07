package com.model.principle.node02.isolation;

public class C01_PersonalBlog {
}
interface ReadBlog {
    String getBlog () ;
}
interface AdminBlog {
    Boolean insertBlog () ;
    Boolean updateBlog () ;
    Boolean deleteBlog () ;
}
/**
 * 读者只开放博客阅读接口
 */
class Reader implements ReadBlog {
    @Override
    public String getBlog() {
        return null;
    }
}
/**
 * 管理员有博客全部的管理权限
 */
class AdminUser implements AdminBlog,ReadBlog {
    @Override
    public String getBlog() {
        return null;
    }
    @Override
    public Boolean insertBlog() {
        return null;
    }
    @Override
    public Boolean updateBlog() {
        return null;
    }
    @Override
    public Boolean deleteBlog() {
        return null;
    }
}