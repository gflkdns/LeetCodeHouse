import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // 记录前序遍历的索引值
    int pre_index = 0;
    int[] preorder;
    int[] inorder;
    // 记录中序遍历的位置
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int start, int end) {
        if (start == end) {
            return null;
        }

        // 前序遍历的第一个位置，必定是它的根节点
        int root_val = preorder[pre_index++];
        TreeNode root = new TreeNode(root_val);

        int index = map.get(root_val);
        //中序遍历的顺序是 left root right
        //因此，找到这个下标，位于他左边的一定是left右边的一定是right
        root.left = helper(start, index);
        root.right = helper(index + 1, end);

        return root;
    }
}
