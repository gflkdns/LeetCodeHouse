/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty()) {
            return -1;
        }
        char[] chars = haystack.toCharArray();
        char[] s = needle.toCharArray();

        if (s.length > chars.length) {
            return -1;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == s[0]) {
                boolean ismarch = true;
                for (int j = 1; j < s.length; j++) {
                    if (i + j >= chars.length) {
                        ismarch = false;
                        break;
                    }
                    if (chars[i + j] != s[j]) {
                        ismarch = false;
                        break;
                    }
                }
                if (ismarch) {
                    return i;
                }
            }
        }
        return -1;
    }
}

