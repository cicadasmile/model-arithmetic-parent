package com.model.structure.node04.sortfind;

/**
 * 冒泡排序基础
 */
public class M02_Bubble {
    public static void main(String[] args) {
        int[] arr = {3,7,5,9,6};
        bubbleSort(arr);
        for (int num:arr){
            System.out.println(num);
        }
    }
    public static void bubbleSort(int[] arr) {
        // 声明临时变量
        int temp = 0;
        // 排序总趟数
        for (int i = 0; i < arr.length - 1; i++) {
            // 元素交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 位置交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
