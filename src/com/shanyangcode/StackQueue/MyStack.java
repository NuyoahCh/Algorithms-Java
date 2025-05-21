package com.shanyangcode.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-21
 * @description: 请你仅使用一个或两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 */
public class MyStack {

    // 使用一个 queue
    private final Queue<Integer> queue;

    // 构造器
    public MyStack() {
        queue = new LinkedList<>();
    }

    // 将元素压入栈顶
    public void push(int x) {
        queue.offer(x);
        int steps = queue.size() - 1;
        for (int i = 0; i < steps; i++) {
            queue.offer(queue.poll());
        }
    }

    // 移除返回栈顶元素
    public Integer pop() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    // 返回栈顶元素
    public Integer top() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.peek();
    }

    // 判空
    public boolean empty() {
        return queue.isEmpty();
    }
}
