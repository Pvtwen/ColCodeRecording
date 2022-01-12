package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/10/15 16:16
 */
public class Question877 {
    public boolean stoneGame(int[] piles) {
        int length=piles.length;
        int[][] dp=new int[length+1][length+1];

        for(int i=1;i<length+1;i++){
            dp[i][i]=piles[i-1];
        }

        for(int i=length-1;i>=1;i--){
            for(int j=i+1;j<length+1;j++){
                dp[i][j]=Math.max(piles[i-1]-dp[i+1][j],piles[j-1]-dp[i][j-1]);
            }
        }

        for(int i=length-2;i>=0;i--){
            for(int j=i+1;j<length;j++){
                dp[i+1][j+1]=Math.max(piles[i]-dp[i+2][j+1],piles[j]-dp[i+1][j]);
            }
        }
//        for(int i=0;i<length;i++){
//            dp[i][i]=piles[i];
//        }

//        for(int i=length-2;i>=0;i--){
//            for(int j=i+1;j<length;j++){
//                dp[i][j]=Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
//            }
//        }

//        for(int i=1;i<length;i++){
//            for(int j=i-1;j>=0;j++){
//                dp[j][i]=Math.max(piles[j]-dp[j+1][i],piles[i]-dp[j][i-1]);
//            }
//        }

        return dp[1][length]>0?true:false;
    }
}
