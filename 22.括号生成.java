import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return res;
        }
        generateParenthesis(res, "(", 1, 0, n);
        return res;
    }

    public void generateParenthesis(List<String> res, String item, int count1, int count2, int sum) {
        if (count2 == sum) {
            res.add(item);
            return;
        }

        if ( count1 > sum) {
            return;
        }

        if (count1 + 1 <= sum) {
            generateParenthesis(res, item + "(", count1 + 1, count2, sum);
        }
        if (count2 + 1 <= count1) {
            generateParenthesis(res, item + ")", count1, count2 + 1, sum);
        }
    }
}
