package dataStructure.Leetcode.Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yawen Cao
 * @data 2021/12/14 9:10
 */
public class Question630 {
    // https://leetcode-cn.com/problems/course-schedule-iii/solution/tong-ge-lai-shua-ti-la-630-ke-cheng-biao-uhlu/
    // 不存在先学习后者
    // 思路：截止时间近的课程的优先级大于截止时间远的课程的优先级
    public int scheduleCourse(int[][] courses) {
        int length = courses.length;
        // 按学习时长从大到小排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 按截止时间从小到大排序
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int curTime = 0;
        int num = 0;
        for (int i = 0; i < length; i++) {
            int time = courses[i][0];
            int deadline = courses[i][1];
            if (curTime + time <= deadline) {
                curTime += time;
                num++;
                priorityQueue.offer(time);
            } else {
                Integer headCour = priorityQueue.peek();
                if (headCour != null) {
                    int dur = headCour;
                    if (time < dur) {
                        priorityQueue.poll();
                        priorityQueue.offer(time);
                        curTime -= dur;
                        curTime += time;
                    }
                }
            }
        }
        return num;
    }
}
