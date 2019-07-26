/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int tiefe) {
        if (root == null) {
            return tiefe;
        }
        tiefe++;
        return Math.max(helper(root.left, tiefe), helper(root.right, tiefe));
    }
}
