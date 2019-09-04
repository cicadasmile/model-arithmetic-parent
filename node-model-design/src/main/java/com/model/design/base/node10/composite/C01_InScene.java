package com.model.design.base.node10.composite;
import java.io.File;
/**
 * 打印指定文件夹目录
 */
public class C01_InScene {
    public static void main(String[] args) {
        File file = new File("F:\\tree") ;
        fileTree(file, 0);
    }
    private static void fileTree(File file, int floor) {
        // 判断是否存在
        if (file.exists()) {
            if (floor > 0) {
                // 循环打空格
                for (int i = 0; i < floor; i++) {
                    System.out.print(" ");
                }
            }
            if (file.isDirectory()) {
                System.out.println("+" + file.getName());
                // 列出所有文件及文件夹
                File[] files = file.listFiles();
                if (null != files) {
                    // 循环递归
                    for (File dirFile : files) {
                        fileTree(dirFile, floor + 1);
                    }
                }
            } else {
                System.out.println("-" + file.getName());
            }
        }
    }
}
