package dataStructure.Leetcode.dp.Review;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2021/12/9 9:59
 */
public class Question435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int edge = intervals[0][1];
        int ans=1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=edge){
                edge=intervals[i][1];
                ans++;
            }
        }
        return intervals.length-ans;
    }
//    public int eraseOverlapIntervals(int[][] intervals) {
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//        int[] edge=intervals[0];
//        int ans=1;
//        for(int i=1;i<intervals.length;i++){
//            if(intervals[i][0]==edge[0]){
//                if(intervals[i][1]<edge[1]){
//                    edge=intervals[i];
//                }
//            }else if(intervals[i][0]>=edge[1]){
//                ans++;
//                edge=intervals[i];
//            }else if(intervals[i][1]<edge[1]){
//                edge=intervals[i];
//            }
//        }
//        return intervals.length-ans;
//    }
}
