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

    public List<Integer> postorderTraversal(TreeNode root) {
        //helper(root);

        Stack<TreeNode> stacks=new Stack<>();
        TreeNode curr=root;
        while(curr!=null||!stacks.isEmpty()){
            if(curr.left!=null){
                stacks.push(curr.left);
                curr=curr.left;
                continue;
            }
            if(curr.right!=null){
                stacks.push(curr.right);
            }
            list.add(curr.val);
            curr=stacks.pop();
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
