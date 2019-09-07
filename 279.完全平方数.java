import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */
class Solution {
    public int numSquares(int n) {
        HashSet<Integer> ed = new HashSet<>();
        int h = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            h++;
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                int j = 1;
                while (true) {
                    int item = num - (j * j);
                    j++;
                    if (item > 0) {
                        if (!ed.contains(item)) {
                            queue.offer(item);
                            ed.add(item);
                        }
                    } else if (item == 0) {
                        return h;
                    } else {
                        break;
                    }

                }
            }
        }
        return h;
    }
}
