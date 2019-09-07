/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lastIndex=0;

        for (int i = 0; i < nums.length; i++) {
            if(lastIndex<=i&&nums[i]!=val){
                nums[lastIndex++]=nums[i];
            }
        }

        return lastIndex;
    }
}
