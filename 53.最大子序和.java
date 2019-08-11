/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length);
    }

    public int maxSubArray(int[] nums, int start, int end) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
