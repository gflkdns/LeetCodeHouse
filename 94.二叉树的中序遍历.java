import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<Integer> list = new ArrayList<>();

    // /**
    // * 中序遍历是先遍历左子树，在遍历根节点，然后遍历右子树 中序遍历二叉搜索树得到的数据是排好序的
    // *
    // * @param root
    // * @return
    // */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    // 这个方法会改变树的结构，不好
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode raw = stack.pop();
            if (raw != null) {
                if (raw.left != null) {
                    stack.push(raw);
                    stack.push(raw.left);
                    raw.left = null;
                    continue;
                }
                result.add(raw.val);
                if (raw.right != null) {
                    stack.push(raw.right);
                    raw.right = null;
                }
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
                continue;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
