package com.shanyangcode.AlgoDemo;

import java.util.Arrays;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-18
 * @description: API 设计：实现动态数组
 * 1. 添加元素 - add
 * 2. 访问元素 - get
 * 3. 修改元素 - update
 * 4. 删除元素 - remove
 * 5. 大小 - size
 */
public class CustomizedArray {
    // 数组大小
    private int[] array;
    // 默认容量
    private int DEFAULT_CAPACITY = 10;
    // 数组大小
    private int size;

    // 构造器
    public CustomizedArray() {
        // new 初始化一个 array
        // 原来实现的数组不需要删除，Java中自带的GC垃圾回收机制
        array = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    // 1. 添加元素 - add
    public void add(int value) {
        if (size == DEFAULT_CAPACITY) {
            // 扩容操作
            expandCapacity();
        }
        // 添加元素值放置到数组中
        array[size] = value;
        // 数组大小进行调整
        size++;
    }

    // 2. 访问元素 - get
    public int get(int index) {
        // 获取索引
//        return array[index];
        // check the legality
        if (size == 0 || index < 0 || index >= size) {
            return Integer.MIN_VALUE;
        }
        return array[index];
    }

    // 3. 修改元素 - update
    public boolean update(int index, int value) {
        // check the legality
        if (size == 0 || index < 0 || index >= size) {
            return false;
        }
        // 修改对应索引的值
        array[index] = value;
        return true;
    }

    // 3. 修改元素 - update 优化版
    public void updateBetter(int index, int value) {
        // check the legality
        if (size == 0 || index < 0 || index >= size) {
//            return;
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // 修改对应索引的值
        array[index] = value;
//        return true;
    }

    // 4. 删除元素 - remove
    public int remove(int index) {
        // check the legality
        if (size == 0 || index < 0 || index >= size) {
            return Integer.MIN_VALUE;
        }

        int result = array[index];
        // 1 2 3 4 5    index = 2
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return result;
    }

    // 5. 大小 - size
    public int size() {
        // 返回元素大小
        return size;
    }


    // help function 辅助函数进行扩容
    private void expandCapacity() {
        // 2 倍扩容，进行 copy 的方式
        array = Arrays.copyOf(array, array.length * 2);
        // 1 2 3
        // 1 2 3 0 0 0
    }

    private void expandCapacityHand() {
        // 创建一个新的数组，容量是原来的两倍
        int[] newArray = new int[array.length * 2];

        // 将原数组中的元素逐个复制到新数组中
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        // 将原数组引用指向新数组
        array = newArray;
    }


    // 打印函数
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("数组里面的元素为：");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.
        CustomizedArray myArray = new CustomizedArray();
        myArray.add(1);
        System.out.println(myArray.toString());
        myArray.add(2);
        System.out.println(myArray.toString());
//        myArray.get(1);
        System.out.println(myArray.get(-1));
        System.out.println(myArray.get(2));
        System.out.println(myArray.get(1));
        myArray.update(1, -1);
        System.out.println(myArray.get(1));
        myArray.add(3);
        myArray.add(4);
        System.out.println(myArray.toString());
        int item = myArray.remove(1);
        System.out.println(myArray.toString());
        System.out.println(item);
        System.out.println(myArray.size());
    }
}
