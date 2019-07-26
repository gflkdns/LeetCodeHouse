import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer,ListNode> map=new HashMap<>();
        int index=0;
        ListNode cur=head;
        while(cur!=null){
            map.put(index,cur);
            cur=cur.next;
            ++index;
        }
        int removeIndex=index-n;
        if(removeIndex>0){
            map.get(removeIndex-1).next=map.get(removeIndex).next;
            return head;
        }else{
            return head.next;
        }
    }
}

