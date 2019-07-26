/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(height(root.left, 0) - height(root.right, 0)) < 2;
    }

    public int height(TreeNode root, int height) {
        if (root == null) {
            return height;
        }
        height++;
        return Math.max(height(root.left, height), height(root.right, height));
    }
}
