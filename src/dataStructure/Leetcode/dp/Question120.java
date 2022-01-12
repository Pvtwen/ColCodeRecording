package dataStructure.Leetcode.dp;

import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/11 9:50
 */
public class Question120 {
//    public static int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int res=Integer.MAX_VALUE;
//        int n = triangle.size();
//        if(n==1) return triangle.get(0).get(0);
//        int res=0;
//        int[][] dp=new int[n][n];
//        dp[0][0]=triangle.get(0).get(0);
//
//        for(int i=1;i<n;i++){
//            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
//            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
//            if(i==n-1){
//                res=Math.min(dp[i][0],dp[i][i]);
//            }
//            for(int j=1;j<i;j++){
//                dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
//                if(i==n-1){
//                    res=Math.min(res,dp[i][j]);
//                }
//            }
//        }

        // 滚动数组
//        if(n==1) return triangle.get(0).get(0);
//        int[] dp=new int[n];
//
//        dp[0]=triangle.get(0).get(0);
//        for(int i=1;i<n;i++){
//            dp[i]=dp[i-1]+triangle.get(i).get(i);
//            dp[0]=dp[0]+triangle.get(i).get(0);
//            if(i==n-1) res=Math.min(dp[0],dp[i]);
//            for(int j=i-1;j>0;j--){
//                dp[j]=Math.min(dp[j],dp[j-1])+triangle.get(i).get(j);
//                if(i==n-1) res=Math.min(res,dp[j]);
//            }
//        }
//        return res;

    //dp[i][j]: 从底往下i行j列最小值 从底部递推
//        public int minimumTotal(List<List<Integer>> triangle) {
//            int n=triangle.size();
//            int[][] dp=new int[n][n];
//            for(int i=0;i<n;i++){
//                dp[n-1][i]=triangle.get(n-1).get(i);
//            }
//            for(int i=n-2;i>=0;i--){
//                for(int j=0;j<=i;j++){
//                    dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
//                }
//            }
//            return dp[0][0];
//        }

    // 滚动数组
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp=new int[n];
        for(int i=0;i<=n-1;i++){
            dp[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
