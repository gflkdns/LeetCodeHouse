/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        while (n != 1 && n % 10 % 2 == 0) {
            n = n / 2;
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}
