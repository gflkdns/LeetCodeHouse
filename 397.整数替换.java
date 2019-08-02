/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */
class Solution {
    Integer min = Integer.MAX_VALUE;

    public int integerReplacement(int n) {
        integerReplacement(n, 0);
        return min;
    }

    public void integerReplacement(long n, int size) {
        if (n == 1) {
            min = Math.min(min, size);
            return;
        }
        size++;
        if (n % 2 == 0) {
            integerReplacement(n / 2L, size);
        } else {
            integerReplacement(n + 1L, size);
            integerReplacement(n - 1L, size);
        }
    }
}
