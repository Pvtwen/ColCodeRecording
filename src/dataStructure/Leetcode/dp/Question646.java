package dataStructure.Leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2022/1/1 9:43
 */
public class Question646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int length = pairs.length;
        int[] dp=new int[length];
        Arrays.fill(dp,1);
        int ret=1;
        for(int i=1;i<length;i++){
            for(int j=i-1;j>=0;j--){
                if(pairs[i][0]>pairs[j][1]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ret=dp[i];
                }
            }
        }
        return ret;
    }
}
