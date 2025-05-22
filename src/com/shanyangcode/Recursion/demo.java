package com.shanyangcode.Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-22
 * @description:
 */
public class demo {

    // 计算阶乘
    public int factorial(int n) {
        // 基本情况
        if (n == 0 || n == 1) {
            return 1;
        }
        // 递归情况
        return n * factorial(n - 1);
    }

    // 斐波那契数列
    public int fibonacci(int n) {
        // 基本情况
        if (n == 0 || n == 1) {
            return n;
        }
        // 递归情况
        return factorial(n - 1) + factorial(n - 2);
    }

    // 斐波那契数列 + 记忆化搜索，避免重复计算
    public int fibonacciBetter(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return fibonacciBetter(map, n);
    }

    public int fibonacciBetter(Map<Integer, Integer> map, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = fibonacciBetter(map, n - 1) + fibonacciBetter(map, n - 2);
        map.put(n, result);
        return result;
    }

    public static void main(String[] args) {

    }
}
