package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/12/17 9:59
 */
public class Question474 {
    // 01 滚动数组 实验证明 三维降二维的时间和空间优化比二维降一维的时间和空间优化更明显 直接降了一半
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][] counts = new int[length][2];
        int idx=0;
        for (String str : strs) {
            counts[idx]=compute(str);
            idx++;
        }
        int[][] dp=new int[m+1][n+1];
        for(int i=counts[0][0];i<m+1;i++){
            for(int j=counts[0][1];j<n+1;j++){
                dp[i][j]=1;
            }
        }
        //
        for(int i=1;i<strs.length;i++){
            for (int j = m; j >= counts[i][0]; j--) {
                for(int k=n;k>=counts[i][1];k--){
                    dp[j][k]=Math.max(dp[j][k],dp[j-counts[i][0]][k-counts[i][1]]+1);
                }
            }
        }
        return dp[m][n];
    }
    // 01背包问题
//    public int findMaxForm(String[] strs, int m, int n) {
//        int length = strs.length;
//        int[][][] dp = new int[length + 1][m + 1][n + 1];
//        int idx = 0;
//        int[][] counts = new int[length][2];
//        for (String str : strs) {
//            int[] compute = compute(str);
//            counts[idx] = compute;
//            idx++;
//        }
//        for (int i = 1; i <= length; i++) {
//            for (int j = 0; j < m + 1; j++) {
//                for (int k = 0; k < n + 1; k++) {
//                    if (j >= counts[i - 1][0] && k >= counts[i - 1][1]) {
//                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - counts[i - 1][0]][k - counts[i - 1][1]] + 1);
//                    } else dp[i][j][k] = dp[i - 1][j][k];
//                }
//            }
//        }
//        return dp[length][m][n];
//    }

    // 错误思路
    //    public int findMaxForm(String[] strs, int m, int n) {
//        int length = strs.length;
//        int[][] counts = new int[length][2];
//        int idx=0;
//        for (String str : strs) {
//            int[] ret = compute(str);
//            counts[idx]=ret;
//            idx++;
//        }
//        int[] dp=new int[length];
//        for(int i=0;i<length;i++){
//            if(counts[i][0]<=m && counts[i][1]<=n){
//                dp[i]=1;
//            }
//        }
//        int ans=0;
//        for(int i=1;i<length;i++){
//            int i1 = counts[i][0];
//            int j1 = counts[i][1];
//            int flag=0;
//            for(int j=i-1;j>=0;j--){
//                if(counts[i][0]>m || counts[i][1]>n) break;
//                if (counts[i][0] + counts[j][0] <= m && counts[i][1] + counts[j][1] <= n) {
//                    int temp0=counts[i][0]+counts[j][0];
//                    int temp1=counts[i][1]+counts[j][1];
//                    if(flag==0){
//                        i1=temp0;
//                        j1=temp1;
//                        flag=1;
//                    }
//                    if (dp[j] + 1 >= dp[i]) {
//                        if(temp0<i1 || temp1<j1){
//                            i1=temp0;
//                            j1=temp1;
//                        }
//                        dp[i] = dp[j] + 1;
//                    }
//                }
//            }
//            counts[i][0]=i1;
//            counts[i][1]=j1;
//            ans=Math.max(ans,dp[i]);
//        }
//        return ans;
//    }
    public int[] compute(String str) {
        int count0 = 0, count1 = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0') count0++;
            else count1++;
        }
        return new int[]{count0, count1};
    }
}
