package dataStructure.Leetcode.dp.Review;

/**
 * @author Yawen Cao
 * @data 2021/12/10 20:15
 */
public class Question5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp= new boolean[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=true;
        }
        char[] chars = s.toCharArray();
        int ans=1;
        String ret=""+s.charAt(0);
        for(int j=1;j<length;j++){
            for(int i=j-1;i>=0;i--){
                if(j-i<2) dp[i][j]=(s.charAt(i)==s.charAt(j));
                else dp[i][j]=(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]);
                if(dp[i][j] && j-i+1>ans){
                    ans=j-i+1;
                    ret=new String(chars,i,j-i+1);
                }
            }
        }
        return ret;
    }
}
