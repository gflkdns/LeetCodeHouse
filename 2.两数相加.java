import java.util.Stack;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int j = 0;
        ListNode result = new ListNode(0);
        ListNode pre = result;
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;

            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int curr = a + b + j;
            j = (curr >= 10 ? 1 : 0);

            ListNode next = new ListNode(curr % 10);
            pre.next = next;
            pre = next;
        }
        if (j != 0) {
            pre.next = new ListNode(1);
        }
        return result.next;
    }
}
