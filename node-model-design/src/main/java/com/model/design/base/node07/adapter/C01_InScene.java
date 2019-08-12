package com.model.design.base.node07.adapter;

/**
 * 适配器模式描述生活场景
 */
public class C01_InScene {
    public static void main(String[] args) {
        CurrentAdapter adapter = new CurrentAdapter() ;
        System.out.println(adapter.get110VCurrent()) ;
    }
}
// 220V电流
class Current220V {
    public int get220VCurrent (){
        return 220 ;
    }
}
// 110V电流接口
interface Current110V {
    int get110VCurrent () ;
}
// 电流适配器
class CurrentAdapter extends Current220V implements Current110V {
    // 电流转换方法
    @Override
    public int get110VCurrent() {
        int high = get220VCurrent() ;
        int low = high/2 ;
        return low ;
    }
}
