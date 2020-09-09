package com.model.structure.node02.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 基于 LinkedList 模拟队列效果
 */
public class M01_Queue {
    public static void main(String[] args) {
        // 入队列
        Queue<String> queue = new LinkedList<>();
        queue.add("head") ;
        queue.add("middle") ;
        queue.add("tail") ;
        // 当队列出数据之后，size是不断变化的
        int queueSize = queue.size() ;
        int loop = 0 ;
        // 根据队列大小，不断出队列
        while (loop < queueSize) {
            System.out.println(queue.poll());
            System.out.println(queue);
            loop ++ ;
        }
    }
}
