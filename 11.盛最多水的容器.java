/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */
class Solution {
    public int maxArea(int[] height) {
        int result=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int raw=Math.min(height[i],height[j])*(j-i);
                result=Math.max(result, raw);
            }
        }
        return result;
    }
}

