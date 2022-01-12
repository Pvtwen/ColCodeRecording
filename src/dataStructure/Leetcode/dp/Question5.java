package dataStructure.Leetcode.dp;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/11/7 19:43
 */
public class Question5 {
    public static String longestPalindrome(String s) {
//        if(s.length()==1) return s;
//        int length = s.length();
//        boolean[][] dp= new boolean[length + 1][length + 1];
//
//        for(int i=0;i<length;i++){
//            dp[i][i]=true;
//        }
//        String ans="";
//        for(int i=length-1;i>=0;i--){
//            for(int j=i;j<length;j++){
//                char c = s.charAt(i);
//                char c1 = s.charAt(j);
//                if(j-i<=1){
//                    if(c==c1) {
//                        dp[i][j]=true;
//                        if(ans.length()<j-i+1) ans=s.substring(i,j+1);
//                    }
//                }else{
//                    dp[i][j]=(dp[i+1][j-1]&&c==c1);
//                    if(ans.length()<j-i+1 && dp[i][j]) ans=s.substring(i,j+1);
//                }
//            }
//        }
//        return ans;
        int length = s.length();
        if(length==1) return s;
        boolean[] dp= new boolean[length];
        Arrays.fill(dp,false);

        String ans="";
        for(int i=length-1;i>=0;i--){
            for(int j=length-1;j>=i;j--){
                char c = s.charAt(i);
                char c1 = s.charAt(j);
                if(i+1>=j){
                    if(c==c1){
                        dp[j]=true;
                        if(ans.length()<j-i+1) ans=s.substring(i,j+1);
                    }else dp[j]=false;
                }else{
                    dp[j]=(dp[j-1] && c==c1);
                    if(ans.length()<j-i+1 && dp[j]) ans=s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}