package com.model.structure.node02.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Stack 堆栈用法
 */
public class M02_Stack {
    public static void main(String[] args) {
        // 入堆栈
        Stack<String> stack = new Stack<>() ;
        stack.push("First") ;
        stack.push("Second") ;
        stack.push("Third") ;
        int stackSize = stack.size() ;
        int loop = 0 ;
        // 根据栈大小，不断出栈
        while (loop < stackSize) {
            System.out.println(stack.pop());
            System.out.println(stack);
            loop ++ ;
        }
        Map<String,String> map = new HashMap<>() ;
    }
}
