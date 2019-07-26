import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<=0){
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>(1);
        one.add(1);
        result.add(one);
        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = result.get(i - 1);
            List<Integer> curr = new ArrayList<>(i);
            curr.add(1);
            for (int j = 0; j < i - 1; j++) {
                curr.add(pre.get(j) + pre.get(j + 1));
            }
            curr.add(1);
            result.add(curr);
        }
        return result;
    }
}
