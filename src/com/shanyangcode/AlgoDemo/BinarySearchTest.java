package com.shanyangcode.AlgoDemo;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-18
 * @description: 二分查找
 * 1 2 3 4 5 6 7 8 target = 6, 先排序，再查找
 */
public class BinarySearchTest {

    // 基本二分查找的写法
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 折中查找，保证极端情况下的准确性
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 这个地方刚开始自己实现的，思路不对，这个地方没有捋清楚
                // mid = right - 1;
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 给你一个非负整数 x ，计算并返回 x 的算术平方根 。由于返回类型是整数，
     * 结果只保留 整数部分 ，小数部舍去。
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */
    public int sqrtRoot(int x) {
        int left = 1;
        int right = x;
        int result = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /**
     * 和原来二分查找的思路写法保持不变
     * 在看视频的过程中我就在质疑为什么还是不用使用之前的方式进行实现
     * 所以就自己又写了一个 demo 使用最熟悉的三个 if - else 的实现思路
     * 这样才发现这个是需要一个范围取值的，而不是非负整数的题目条件
     */
    public int sqrtRootForMe(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else if ((long) mid * mid > x) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
     * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * 示例 1：[4,5,6,7,0,1,2] , target = 0, return 4
     */
    public int findTargetInRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[mid] > target) {
                    if (nums[left] > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target) {
                    if (nums[right] < target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Hello Binary Search");
        BinarySearchTest test = new BinarySearchTest();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 6;
        System.out.println(test.binarySearch(array, target));
        System.out.println(test.sqrtRoot(8));
        System.out.println(test.sqrtRoot(9));
        // 自己的实现方式
        // -1 一旦出现了小数点这样的方式则会报错
        // 3
        System.out.println(test.sqrtRootForMe(8));
        System.out.println(test.sqrtRootForMe(9));
    }
}
