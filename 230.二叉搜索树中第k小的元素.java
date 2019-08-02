import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return result;
    }

    int k, result;

    public void helper(TreeNode root) {
        if (k == 0 || root == null) {
            return;
        }
        helper(root.left);
        k--;
        if (k == 0) {
            result = root.val;
        }
        helper(root.right);
    }

}
