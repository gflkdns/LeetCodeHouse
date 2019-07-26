/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        if (root.left == null) {
            return;
        }
        flatten(root.left);
        TreeNode raw = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode curr = root.right;
        if (curr != null) {
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = raw;
        }

    }
}
