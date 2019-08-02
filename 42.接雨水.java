/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */
class Solution {
    public int trap(int[] height) {

        int max = 0;
        int index = 0;

        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                index = i;
            }
        }

        int count = 0;
        for (int i = 0; i < index; i++) {
            if (height[i] == 0) {
                continue;
            }
            int curr_count = 0;
            for (int j = i + 1; j <= index; j++) {
                int raw = height[j] - height[i];
                if (raw >= 0) {
                    i = j - 1;
                    count += curr_count;
                    break;
                } else {
                    curr_count = curr_count - raw;
                }
            }
        }
        for (int i = height.length - 1; i > index; i--) {
            if (height[i] == 0) {
                continue;
            }
            int curr_count = 0;
            for (int j = i - 1; j >= index; j--) {
                int raw = height[j] - height[i];
                if (raw >= 0) {
                    i = j + 1;
                    count += curr_count;
                    break;
                } else {
                    curr_count = curr_count - raw;
                }
            }
        }
        return count;
    }
}
