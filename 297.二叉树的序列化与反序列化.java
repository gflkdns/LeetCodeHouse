import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {


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

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
