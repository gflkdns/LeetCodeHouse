import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int last_index;
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> value_indexs = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        last_index = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            value_indexs.put(inorder[i], i);
        }

        return helper(0, inorder.length);
    }

    // start 和 end 是标记拆分中序遍历数组用的
    private TreeNode helper(int start, int end) {
        if (start == end) {
            return null;
        }
        // 后序遍历是 left right root 末尾 一定是根节点
        int root_val = postorder[last_index--];
        TreeNode root = new TreeNode(root_val);

        int index = value_indexs.get(root_val);

        root.right = helper(index + 1, end);
        root.left = helper(start, index);

        return root;
    }
}
