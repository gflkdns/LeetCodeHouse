
/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class TestLeetCode {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0)/2;
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum *= 10;
        sum += root.val;
        return helper(root.left, sum) + helper(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TestLeetCode s = new TestLeetCode();
        System.out.println(s.sumNumbers(node1));
    }

}
