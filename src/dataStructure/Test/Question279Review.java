package dataStructure.Test;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/11/8 10:41
 */
public class Question279Review {

    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for(int i=0;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
