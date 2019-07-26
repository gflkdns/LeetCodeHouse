
/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int ret=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ret;
    }
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int left=Math.max(helper(root.left),0);
        int right=Math.max(helper(root.right),0);
        ret=Math.max(ret,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
