/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */
class Solution {
    public int myAtoi(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        char[] chars = str.toCharArray();
        boolean started = false;
        long b = 1;
        long result = 0;
        int lastc = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int c = (int) (chars[i]);
            if (c >= 48 && c <= 57) {
                started = true;
                result += (c - 48) * b;
                b = b > 10000000000L ? 10000000000L : b * 10;
                result = result > 2147483648L ? 2147483648L : result;
                result = result < -2147483648L ? -2147483648L : result;
            } else if (c == 45 && lastc >= 48 && lastc <= 57 && i <= 0) {
                result *= -1;
            } else if (c == 43 && lastc >= 48 && lastc <= 57 && i <= 0) {
            } else if (started) {
                result = 0;
                b = 1;
            }
            lastc = c;
        }
        result = result > 2147483647L ? 2147483647L : result;
        result = result < -2147483648L ? -2147483648L : result;
        return (int) result;
    }
}
