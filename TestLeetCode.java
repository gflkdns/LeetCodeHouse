import java.util.LinkedList;
import java.util.Queue;

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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                builder.append(",-");
            } else {
                builder.append("," + curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] datas = data.split(",");
        TreeNode node = new TreeNode(Integer.valueOf(datas[1]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int index = 2;
        while (index < datas.length - 2) {
            TreeNode curr = queue.poll();
            String di = datas[index++];

            if (!di.equals("-")) {
                curr.left = new TreeNode(Integer.valueOf(di));
                queue.offer(curr.left);
            }
            di = datas[index++];

            if (!di.equals("-")) {
                curr.right = new TreeNode(Integer.valueOf(di));
                queue.offer(curr.right);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TestLeetCode s = new TestLeetCode();
        System.out.println(s.serialize(s.deserialize(",1,2,3,-,-,-,-")));
        System.out.println(s.serialize(node1));
    }

}
