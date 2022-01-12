package dataStructure.Leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2021/12/7 17:21
 */
public class Question435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        int[][] dp = new int[length][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int cur = 1;
        dp[0][0] = intervals[0][0];
        dp[0][1] = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] == dp[cur - 1][0]) {
                if (intervals[i][1] < dp[cur - 1][1]) {
                    dp[cur - 1][0] = intervals[i][0];
                    dp[cur - 1][1] = intervals[i][1];
                }
            } else {
                // 二分
                if (intervals[i][0] < dp[cur - 1][1]) {
                    int l = 0, r = cur - 1;
                    while (l <= r) {
                        int mid = (l + r) / 2;
                        // 查找第一个大于等于interval[i][1]的 替换之
                        if (l == r) break;
                        else if (dp[mid][1] >= intervals[i][1]) r = mid;
                        else l = mid + 1;
                    }
                    if(dp[l][1]<intervals[i][1]);
                    else{
                        dp[l][0] = intervals[i][0];
                        dp[l][1] = intervals[i][1];
                    }
                } else {
                    dp[cur][0] = intervals[i][0];
                    dp[cur][1] = intervals[i][1];
                    cur++;
                }
            }
        }
        return length - cur;
    }

//    public int eraseOverlapIntervals(int[][] intervals) {
//        int length = intervals.length;
//        int[] dp=new int[length];
//        int ans=0;
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        });
//        int edge=intervals[0][1];
//        for(int i=1;i<length;i++){
//            if(edge<=intervals[i][0]){
//                edge=intervals[i][1];
//                ans++;
//            }
//        }
//        return length-ans;
//    }
//    public int eraseOverlapIntervals(int[][] intervals) {
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//        int length = intervals.length;
//        int[] dp = new int[length];
//        // dp[i]:下标i截止 所能到达的最大长度
//        Arrays.fill(dp,1);
//        int ret=1;
//        for(int i=1;i<length;i++){
//            for(int j=i-1;j>=0;j--){
//                int l = intervals[i][0];
//                int r = intervals[j][1];
//                if(l>=r) dp[i]=Math.max(dp[i],dp[j]+1);
//            }
//        }
//        return  length - Arrays.stream(dp).max().getAsInt();
//    }
}
