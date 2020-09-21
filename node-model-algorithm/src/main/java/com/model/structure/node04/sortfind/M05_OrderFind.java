package com.model.structure.node04.sortfind;

/**
 * 顺序查找基础
 */
public class M05_OrderFind {
    public static void main(String[] args) {
        String[] arr = {"first","second","third"};
        System.out.println(seqSearch(arr,"second"));
    }
    public static int seqSearch(String[] arr, String value) {
        // 数组下标，-1代表没有
        int findIndex = -1 ;
        // 遍历并逐个对比
        for (int i = 0; i < arr.length; i++) {
            if(value.equals(arr[i])) {
                return i ;
            }
        }
        return findIndex ;
    }
}
