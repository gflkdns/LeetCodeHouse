import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> nodes2 = new Stack<>();
        Stack<TreeNode> nodes1 = new Stack<>();
        nodes1.push(root);
        int direction = 1;
        while (!nodes1.isEmpty() || !nodes2.isEmpty()) {
            Stack<TreeNode> curr, next;
            if (direction > 0) {
                curr = nodes1;
                next = nodes2;
            } else {
                curr = nodes2;
                next = nodes1;
            }
            int size = curr.size();
            List<Integer> item = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = curr.pop();
                item.add(node.val);
                if (direction > 0) {

                    if (node.left != null) {
                        next.push(node.left);
                    }
                    if (node.right != null) {
                        next.push(node.right);
                    }
                } else {

                    if (node.right != null) {
                        next.push(node.right);
                    }
                    if (node.left != null) {
                        next.push(node.left);
                    }
                }
            }
            direction *= -1;
            result.add(item);
        }
        return result;
    }
}
