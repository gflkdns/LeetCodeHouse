/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode node = new ListNode(0);
        ListNode next = node;
        ListNode curr = head;
        while (curr != null) {
            ListNode t = curr.next;

            if (t != null) {
                curr.next = curr.next.next;
                t.next = curr;
                curr = curr.next;
                next.next = t;
                next = t.next;
            } else {
                break;
            }

        }
        return node.next;
    }
}
