package dataStructure.Leetcode.dp.Review;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2021/12/14 10:14
 */
public class Question435Review {
    // 贪心
//    public int eraseOverlapIntervals(int[][] intervals) {
//        int length = intervals.length;
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        });
//        int edge = intervals[0][1];
//        int ans=1;
//        for(int i=1;i<length;i++){
//            int left = intervals[i][0];
//            if(left>=edge){
//                edge=intervals[i][1];
//                ans++;
//            }
//        }
//        return length-ans;
//    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] edge = new int[]{intervals[0][0], intervals[0][1]};
        int ans=1;
        for(int i=1;i<length;i++){
            int left = intervals[i][0];
            if(left<edge[1]){
                if(intervals[i][1]<edge[1]){
                    edge[0]=intervals[i][0];
                    edge[1]=intervals[i][1];
                }
            }else{
                ans++;
                edge[0]=intervals[i][0];
                edge[1]=intervals[i][1];
            }
        }
        return length-ans;
    }
}
