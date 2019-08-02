/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val > q.val) {
            TreeNode t = q;
            q = p;
            p = t;
        }
        if (p.right == q) {
            return p;
        }
        if (q.left == p) {
            return q;
        }
        if (root.val > p.val && root.val < q.val) {
            return root;
        }
        TreeNode node = lowestCommonAncestor(root.right, p, q);
        if (node == null) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return node;
        }

    }
}
