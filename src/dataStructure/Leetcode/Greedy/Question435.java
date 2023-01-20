package dataStructure.Leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2022/2/1 11:32
 */
public class Question435 {
    // 贪心：int[i][1]进行排序 证明为什么一定要选择第一个int[i][1]最小的
    // 情况一:
    // 情况二
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int ret=0;
        int edge=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=edge){
                edge=intervals[i][1];
            }else{
                ret++;
            }
        }
        return ret;
    }
}
