package com.model.structure.node04.sortfind;

import java.util.Arrays;

/**
 * 插入排序基础
 */
public class M04_Insert {
    public static void main(String[] args) {
        int[] arr = {10,40,90,20,80};
        insertSort(arr);
    }
    public static void insertSort (int[] arr) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            // 待插入数的值和下标
            insertValue = arr[i];
            insertIndex = i - 1;
            // 写入位置
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
            System.out.println("第" + i + "轮插入排序："+Arrays.toString(arr));
        }
    }
}

