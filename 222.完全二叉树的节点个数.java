/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */
/**
 * Definition for a binary tree node.
 * 
 */
class Solution {
    // int count=0;
    // public int countNodes(TreeNode root) {
    // if(root==null){
    // return 0;
    // }
    // count++;
    // countNodes(root.left);
    // countNodes(root.right);
    // return count;
    // }

    public int countNodes(TreeNode root) {
        int h_l = 0;
        int h_r = 0;
        TreeNode curr = root;
        while (curr != null) {
            h_l++;
            curr = curr.left;
        }

        curr = root;
        while (curr != null) {
            h_r++;
            curr = curr.right;
        }

        // 两边的树一样高
        if (h_l == h_r) {
            return 2 ^ h_l - 1;
        } else {
            int leftCount = countNodes(root.left);
            System.out.println("leftCount:"+leftCount);
            int rightCount = countNodes(root.right);
            System.out.println("rightCount:"+rightCount);
            return leftCount + rightCount + 1;
        }

    }
}
