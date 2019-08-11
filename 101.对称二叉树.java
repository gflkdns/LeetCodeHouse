/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
        }
        return false;
    }
}
