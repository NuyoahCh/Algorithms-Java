package com.shanyangcode.Recursion;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-22
 * @description: 归并排序
 */
public class MergeSort {

    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    public void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left = (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int index = left;
        while (i <= mid && j <= right) {
            if (helper[i] <= helper[j]) {
                array[index] = helper[i];
                i++;
            } else {
                array[index] = helper[j];
                j++;
            }
            index++;
        }

        while (i <= mid) {
            array[index] = helper[i];
            i++;
            index++;
        }

        while (j <= mid) {
            array[index] = helper[j];
            j++;
            index++;
        }
    }
}
