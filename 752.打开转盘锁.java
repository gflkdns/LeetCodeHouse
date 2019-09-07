import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    // BFS搜索
    public int openLock(String[] deadends, String target) {
        char[] pos = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        int h = 0;
        if (set.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return h;
                }
                if (!set.contains(curr)) {
                    set.add(curr);
                    queue.addAll(getNextList(curr, pos));
                }

            }
            h++;

        }
        return -1;
    }

    private List<String> getNextList(String str, char[] pos) {
        List<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0';
            char[] newChars = chars.clone();
            newChars[i] = pos[(num + 11) % 10]; // 数字加一
            res.add(new String(newChars));
            newChars[i] = pos[(num + 9) % 10]; // 数字减一
            res.add(new String(newChars));
        }
        return res;
    }
}