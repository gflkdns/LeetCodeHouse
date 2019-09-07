import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */
class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        ArrayList<Integer> lists = new ArrayList<>(map.values());
        Collections.sort(lists);
        return lists.size() >= 3 ? lists.get(lists.size() - 3) : lists.get(lists.size() - 1);
    }

    public static void main(String[] args) {
        new Solution().thirdMax(new int[] { 1, 3, 2, 4 });
    }
}
