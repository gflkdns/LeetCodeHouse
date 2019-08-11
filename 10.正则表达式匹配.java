/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */
class Solution {
    // if (s == null || s.length() == 0) {
    // return false;
    // }
    // Character last = null;
    // int pi = 0, si = 0;
    // while (si < s.length() || pi < p.length()) {

    // if (si == s.length()) {
    // if (pi < p.length()) {
    // si--;
    // pi++;
    // } else {
    // return true;
    // }
    // }
    // // 表达式到头了，但另字符串还没结束
    // if (pi == p.length()) {
    // return false;
    // }
    // char piv = p.charAt(pi);
    // char siv = s.charAt(si);
    // if (piv == '*') {
    // // 匹配上一个字符0-n个
    // if (last == null) {
    // return false;
    // }
    // if (last == '.') {
    // si++;
    // } else if (siv != last) {
    // pi++;
    // } else {
    // si++;
    // }
    // } else if (piv == '.') {
    // // 匹配任意一个字符
    // last = '.';
    // si++;
    // pi++;
    // } else {
    // // 应该等于这个字符
    // if (piv != siv) {
    // // 如果下个是*就饶了你
    // if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
    // pi++;
    // } else {
    // // 否则就喀嚓
    // return false;
    // }
    // }
    // last = siv;
    // si++;
    // pi++;
    // }
    // }
    // return true;
    public boolean isMatch(String s, String p) {
        
    }
}

// "aab"\n"c*a*b"