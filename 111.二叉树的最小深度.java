/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int minDepth(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int tiefe) {
        if (root == null) {
            return tiefe;
        }
        if (root.left == null && root.right == null) {
            return ++tiefe;
        }
        ++tiefe;
        return Math.min(
            root.left == null ? Integer.MAX_VALUE : helper(root.left, tiefe),
                root.right == null ? Integer.MAX_VALUE : helper(root.right, tiefe));
    }
}
