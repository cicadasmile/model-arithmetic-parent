package com.model.design.base.node05.property;

import java.io.*;

/**
 * 深拷贝和浅拷贝对比案例
 */
public class C02_DeepClone {
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog("Tom") ;
        Dog dog1 = (Dog)dog.clone() ;
        Dog dog2 = (Dog)dog.clone() ;
        // dog1：1639622804;dog2：1639622804
        System.out.println("dog1："+dog1.cat.hashCode()+";dog2："+dog2.cat.hashCode());
        Dog dog3 = (Dog)dog.deepClone() ;
        Dog dog4 = (Dog)dog.deepClone() ;
        // dog3：1937348256;dog4：1641808846
        System.out.println("dog3："+dog3.cat.hashCode()+";dog4："+dog4.cat.hashCode());
    }
}

class Cat implements Serializable {
    public String name ;
    public Cat (String name){
        this.name = name ;
    }
}
class Dog implements Cloneable,Serializable {
    public String name ;
    public Cat cat ;
    public Dog (String name){
        this.name = name ;
        this.cat = new Cat("Kit") ;
    }
    @Override
    protected Object clone() {
        Dog dog = null ;
        try{
            dog = (Dog)super.clone() ;
        } catch (Exception e){
            e.printStackTrace();
        }
        return dog ;
    }
    public Object deepClone() throws IOException, ClassNotFoundException{
        //将对象写到流里面：序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //从流里面读出对象：反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}