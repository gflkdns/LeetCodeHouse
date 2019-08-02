import java.util.Stack;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }
    //     TreeNode node = root.left;
    //     root.left = root.right;
    //     root.right = node;
    //     invertTree(root.left);
    //     invertTree(root.right);
    //     return root;
    // }

    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                TreeNode t = node.left;
                node.left = node.right;
                node.right = t;
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return root;
    }

}
