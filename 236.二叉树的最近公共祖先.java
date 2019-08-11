/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hasTreeNode(root, p, q);
        return result;
    }

    TreeNode result;

    public boolean hasTreeNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = hasTreeNode(root.left, p, q) ? 1 : 0;
        int right = hasTreeNode(root.right, p, q) ? 1 : 0;
        int mid = root == p || root == q ? 1 : 0;

        if (left + right + mid >= 2) {
            result = root;
        }

        return mid + left + right > 0;
    }
}
