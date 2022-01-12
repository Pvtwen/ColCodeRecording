package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/12/10 20:34
 */
public class Question516 {
    // 区间dp
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp=new int[length][length];
        for(int len=1;len<=length;len++){
            for(int left=0;left+len-1<length;left++){
                int right=left+len-1;
                if(len==1) dp[left][left]=1;
                else if(len==2) dp[left][right]=(s.charAt(left)==s.charAt(right))?2:1;
                else {
                    if(s.charAt(left)==s.charAt(right)) dp[left][right]=dp[left+1][right-1]+2;
                    else dp[left][right]=Math.max(dp[left+1][right],dp[left][right-1]);
                }
            }
        }
        return dp[0][length-1];
    }

    // 此题和第五题 最长回文子串的dp[i][j]所描述的不同
    // 此题的dp[i][j]为i，j最长的长度
    // 5题的dp[i][j]为i，j的字符串能否构成回文
//    public int longestPalindromeSubseq(String s) {
//        int length = s.length();
//        int[][] dp=new int[length][length];
//        for(int i=0;i<length;i++){
//            dp[i][i]=1;
//        }
//        int len=1;
//        for(int i=1;i<length;i++){
//            for(int j=i-1;j>=0;j--){
//                if(s.charAt(i)!=s.charAt(j)){
//                    dp[j][i]=Math.max(dp[j+1][i],dp[j][i-1]);
//                }else dp[j][i]=dp[j+1][i-1]+2;
//                len=Math.max(len,dp[j][i]);
//            }
//        }
//        return len;
//    }
}
