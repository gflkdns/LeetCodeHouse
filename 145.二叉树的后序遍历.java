import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<Integer> list = new ArrayList<>();

    // right left root
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stacks = new Stack<>();
        stacks.push(root);
        TreeNode curr;
        while (!stacks.isEmpty()) {
            curr = stacks.pop();
            if (curr.left != null) {
                stacks.push(curr);
                stacks.push(curr.left);
                curr.left = null;
                continue;
            }
            if (curr.right != null) {
                stacks.push(curr);
                stacks.push(curr.right);
                curr.right = null;
                continue;
            }
            list.add(curr.val);
        }
        return list;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        list.add(root.val);
    }
}
