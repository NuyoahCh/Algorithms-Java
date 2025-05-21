package com.shanyangcode.StackQueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-21
 * @description:
 */
public class Other {

    /**
     * 括号匹配
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     */
    public boolean isVaild(String s) {
        // 没成双
        if (s.length() % 2 == 1) {
            return false;
        }
        // 创建 map 结构
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Deque<Character> stack = new LinkedList<>();
        // 判断过程
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.offerLast(c);
            } else if (!stack.isEmpty() && c == map.get(stack.peekLast())) {
                stack.pollLast();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 给定一个只包括 '('，')'，'['，']'， '{'，'}' 的字符串 s ，括号的优先级排序由高到低依次为()，[]，{}，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * 内层括号的优先级不低于外层括号。
     */
    public boolean priIsValid(String s, String priorityOrder) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Map<Character, Integer> priorityMap = new HashMap<>();
        for (int i = 0; i < priorityOrder.length(); i++) {
            priorityMap.put(priorityOrder.charAt(i), priorityOrder.length() - 1);
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && priorityMap.get(c) < priorityMap.get(stack.peekLast())) {
                    return false;
                }
                stack.offerLast(c);
            } else if (!stack.isEmpty() & c == map.get(stack.peekLast())) {
                stack.pollLast();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

    }
}
