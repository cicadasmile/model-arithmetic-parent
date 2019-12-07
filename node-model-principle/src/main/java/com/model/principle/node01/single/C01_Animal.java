package com.model.principle.node01.single;

public class C01_Animal {
    public static void main(String[] args) {

    }
}
class Animal {
    public void dogVoice (){
        System.out.println("狗叫声：旺旺");
    }
    public void cowVoice (){
        System.out.println("牛叫声：哞哞");
    }
}
class DogVoice {
    public String getDogVoice (){
        return "旺旺" ;
    }
}
class CowVoice {
    public String getCowVoice (){
        return "哞哞" ;
    }
}