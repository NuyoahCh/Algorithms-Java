package com.shanyangcode.AlgoDemo;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-18
 * @description: 示例 1：[5,6,7,0,1,2,4] , target = -1
 * left = 0, right = 7, nums[mid] = 7 mid 到底是否在旋转区域呢
 * 旋转区：从索引为 0， 到达我这个 mid 的区域，我是最大的
 * 原地区：你开始到达数组结束的区域，都是升序的
 * 通过某种的比较方式，有些数值我们就不需要了
 * 那么我们到底怎么判断在哪一个区域的，比较 right 和 mid 的值
 * 旋转区的判断条件：
 * if nums[mid] > nums[right] {
 * // 那么我们就是在旋转区
 * } else {
 * // 那么就在原地区
 * }
 * 1. 旋转区
 * if nums[mid] > nums[target] {
 * if (nums[left] > target) {
 * // 旋转区所有的元素都是大于 target，更新他的左边界
 * left = mid + 1;
 * } else {
 * // target 就在他们之间，去寻找就可以
 * right = mid - 1;
 * }
 * }
 * 旋转区最右边的值，最大的值都要比 target 小，那么前面的都找不到了
 * else {
 * left = mid + 1
 * // 这个地方就把旋转区所有的地方都搞定了
 * }
 * <p>
 * 2. 原地区
 * 右边的值如果也是小于 target，那么在旋转区目前是找不到的
 * if nums[mid] < target {
 * if nums[target] < target {
 * right = mid - 1;
 * } else {
 * left = mid + 1;
 * }
 * } else {
 * right = mid - 1;
 * }
 */
public class FindTargetInRotatedArray {

    public int findTargetInRotatedArrayAgain(int[] nums, int target) {
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
        FindTargetInRotatedArray test = new FindTargetInRotatedArray();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 6;
        System.out.println(test.findTargetInRotatedArrayAgain(array, target));
    }
}
