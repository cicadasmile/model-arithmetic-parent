package com.model.structure.node04.sortfind;

/**
 * 二分查找基础
 */
public class M06_BinaryFind {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int index = binarySearch (arr, 0, arr.length - 1, 40);
        System.out.println("index="+index);
    }
    public static int binarySearch(int[] arr, int leftIndex, int rightIndex, int findValue) {
        // leftIndex > rightIndex,没有查到
        if (leftIndex > rightIndex) {
            return -1;
        }
        int midIndex = (leftIndex + rightIndex) / 2;
        int midValue = arr[midIndex];
        // 向左递归
        if (findValue < midValue) {
            return binarySearch(arr, leftIndex, midIndex - 1, findValue);
        // 向右递归
        } else if (findValue > midValue) {
            return binarySearch(arr, midIndex + 1, rightIndex, findValue);
        // 直接找到
        } else {
            return midIndex;
        }
    }
}
