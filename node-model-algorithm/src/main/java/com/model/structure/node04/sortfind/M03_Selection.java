package com.model.structure.node04.sortfind;

import java.util.Arrays;

/**
 * 选择排序基础
 */
public class M03_Selection {
    public static void main(String[] args) {
        int[] arr = {30,70,50,90,60};
        selectionSort(arr);
    }
    public static void selectionSort (int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minData = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                // 假设最小值判断
                if (minData > arr[j]) {
                    // 交换小值
                    minData = arr[j];
                    // 重置 minIndex，递增
                    minIndex = j;
                }
            }
            // 最小值交换放在arr[0]位置
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minData ;
            }
            System.out.println("第"+(i+1)+"轮排序："+Arrays.toString(arr));
        }
    }
}
