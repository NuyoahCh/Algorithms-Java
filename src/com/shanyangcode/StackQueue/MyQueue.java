package com.shanyangcode.StackQueue;

import java.util.Stack;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-21
 * @description: 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（offer、peek、poll、isEmpty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean isEmpty() 如果队列为空，返回 true ；否则，返回 false
 */
public class MyQueue {
    // 两个栈类型的定义
    private final Stack<Integer> storageStack;
    private final Stack<Integer> retrievalStack;

    // 构造器
    MyQueue() {
        storageStack = new Stack<>();
        retrievalStack = new Stack<>();
    }

    // push 添加元素到存储栈
    public void offer(int value) {
        storageStack.add(value);
    }

    // 返回队列开头的元素
    public Integer peek() {
        if (retrievalStack.isEmpty()) {
            // case
//            if (retrievalStack.isEmpty()) {
//                loadMore();
//            }
            // 这个地方不需要判断吧，直接 loadMore 之后再去判断
            loadMore();

        }

        if (retrievalStack.isEmpty()) {
            return null;
        }

        return retrievalStack.peek();
    }

    // 移除并且返回元素
    public Integer poll() {
        if (retrievalStack.isEmpty()) {
            loadMore();
        }
        if (retrievalStack.isEmpty()) {
            return null;
        }
        return retrievalStack.pop();
    }


    // 判断是否为空
    public boolean isEmpty() {
        return storageStack.isEmpty() && retrievalStack.isEmpty();
    }

    // helper func 推出元素
    private void loadMore() {
        while (!storageStack.isEmpty()) {
            retrievalStack.push(storageStack.pop());
        }
    }
}
