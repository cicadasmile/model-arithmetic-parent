package com.model.design.base.node07.adapter;

/**
 * 接口适配器，也叫缺省适配器
 */
public class C04_AdapterInte {
    public static void main(String[] args) {
        ServiceAdapter adapter = new ServiceAdapter(){
            @Override
            public int serviceOperation2() {
                return 22 ;
            }
        };
        System.out.println(adapter.serviceOperation2());
    }
}
interface AbstractService {
    void serviceOperation1();
    int serviceOperation2();
    String serviceOperation3();
}
class ServiceAdapter implements AbstractService{
    @Override
    public void serviceOperation1() {

    }
    @Override
    public int serviceOperation2() {
        return 0;
    }
    @Override
    public String serviceOperation3() {
        return null;
    }
}
