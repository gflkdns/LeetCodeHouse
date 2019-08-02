import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */
class Solution {
    public String convert(String s, int numRows) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();

        List<List<Character>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
        }

        int index = 0;

        while (index < chars.length) {
            int line = 0;
            while (index < chars.length && line < numRows) {
                //System.out.println(line);
                result.get(line).add(chars[index++]);
                line++;
            }
            line=line-2;
            while (index < chars.length && line > 0) {
                //System.out.println(line);
                result.get(line).add(chars[index++]);
                line--;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            List<Character> item = result.get(i);
            for (int j = 0; j < item.size(); j++) {
                builder.append(item.get(j));
            }
        }
        return builder.toString();
    }
}
