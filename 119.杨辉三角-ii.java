/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0){
            return new ArrayList<>(0);
        }
        List<Integer> pre = new ArrayList<>(1);
        pre.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>(i);
            curr.add(1);
            for (int j = 0; j < i - 1; j++) {
                curr.add(pre.get(j) + pre.get(j + 1));
            }
            curr.add(1);
            pre=curr;
        }
        return pre;
    }
}

