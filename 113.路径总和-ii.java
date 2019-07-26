import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 出口： 1.到达叶子节点 2.已经超过了给定的sum值 参数：树节点，记录累加值，目标值
     * 
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            pathSum(root,  0, sum);
        }
        return list;
    }

    public void pathSum(TreeNode root, int sum, int target) {
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) {
                list.add(new LinkedList<>(path));
            }
            return;
        }
        if (root.left != null) {
            pathSum(root.left, sum, target);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            pathSum(root.right, sum, target);
            path.remove(path.size() - 1);
        }
    }
}
