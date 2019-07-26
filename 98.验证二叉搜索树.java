/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (high!=null&&val >= high) {
            return false;
        }
        if (low!=null&&val <= low) {
            return false;
        }
        return isValidBST(root.left, low, val) && isValidBST(root.right, val, high);
    }
}
