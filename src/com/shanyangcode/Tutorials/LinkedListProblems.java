package com.shanyangcode.Tutorials;

/**
 * @program: Algorithms
 * @author: NuyoahCh
 * @create: 2025-05-19
 * @description: 链表专题
 */
public class LinkedListProblems {

    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    // 反转链表
    // 1 -> 2 -> 3 -> null
    // null -> 3 -> 2 -> 1
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
//        if (head == null || head.next == null) {
//            return head;
//        }
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        int size = getListSize(head);
        int step = (size - 1) / 2;
        ListNode cur = head;
        for (int i = 0; i < step; i++) {
            cur = cur.next;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return cur;

    }

    // 合并两个递增的链表
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                dummyNode.next = cur1;
                cur1 = cur1.next;
            } else {
                dummyNode.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return dummyNode.next;
    }

    // 判断链表是否有环
    public boolean hasCycle(ListNode head) {
        // 头节点为空，就没有环
        if (head == null) {
            return false;
        }
        // 创建快慢指针
        ListNode slow = head;
        ListNode fast = head;

        // 往后进行遍历
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 环的入口
    public ListNode cycleEntrance(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode cycleEntranceFroMe(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public int getListSize(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {

    }
}
