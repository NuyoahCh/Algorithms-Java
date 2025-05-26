package com.shanyangcode.Hash;

import java.util.HashMap;
import java.util.Map;
import javax.jws.Oneway;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-25
 * @description:
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && (name != null ? name.equals(person.name) : person.name == null);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

public class HashTableKeyEquality {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Alice", 25);
        map.put(person1, "Value1");
        System.out.println(map.get(person2)); // 打印 Value1
    }
}
