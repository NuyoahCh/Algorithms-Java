package com.shanyangcode.Recursion;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-22
 * @description: 快速排序
 */
public class QuickSort {

    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = 0;
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[right];

        while (i <= j) {
            if (array[i] <= pivot) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
            swap(array, i, right);
            return i;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("quick sort");
        QuickSort sort = new QuickSort();
    }
}
