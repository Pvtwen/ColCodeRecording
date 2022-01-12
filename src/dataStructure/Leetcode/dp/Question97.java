package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/11/10 10:34
 */
public class Question97 {
//     dp(i,j)  s1的前i个 s2的前j个是否够成
//    public boolean isInterleave(String s1, String s2, String s3) {
//        int length1 = s1.length();
//        int length2 = s2.length();
//        int length3 = s3.length();
//        boolean[][] dp=new boolean[length1+1][length2+1];
//        dp[0][0]=true;
//        for(int i=1;i<length1+1;i++){
//            if(s3.charAt(i-1)!=s1.charAt(i-1)) break;
//            dp[i][0]=true;
//        }
//        for(int i=1;i<length2;i++){
//            if(s3.charAt(i-1)!=s2.charAt(i-1)) break;
//            dp[0][i]=true;
//        }
//        for(int i=1;i<length1+1;i++){
//            for(int j=1;j<length2+1;j++){
//                int idx=i+j-1;
//                boolean b=(s1.charAt(i-1)==s3.charAt(idx) && dp[i-1][j]);
//                boolean b1=(s2.charAt(j-1)==s3.charAt(idx) && dp[i][j-1]);
//                dp[i][j]=(b||b1);
//            }
//        }
//        return dp[length1][length2];
//    }

    // dp(i,j) : i,len1  j,len2 能否构成有序
//    public boolean isInterleave(String s1, String s2, String s3) {
//        int length1 = s1.length();
//        int length2 = s2.length();
//        int length3 = s3.length();
//        if(length1+length2!=length3) return false;
//        boolean[][] dp=new boolean[length1+1][length2+1];
////        dp[0][0]=true;
//        dp[length1][length2]=true;
//        for(int i=length1-1;i>=0;i--){
//            if(s3.charAt(length2+i)!=s1.charAt(i)) break;
//            dp[i][length2]=true;
//        }
//        for(int j=length2-1;j>=0;j--){
//            if(s3.charAt(length1+j)!=s2.charAt(j)) break;
//            dp[length1][j]=true;
//        }
//        for(int i=length1-1;i>=0;i--){
//            for(int j=length2-1;j>=0;j--){
//                int idx=i+j;
//                boolean b=(s3.charAt(idx)==s1.charAt(i) && dp[i+1][j]);
//                boolean b1=(s3.charAt(idx)==s2.charAt(j) && dp[i][j+1]);
//                dp[i][j]=(b||b1);
//            }
//        }
//        return dp[0][0];
//    }

    // 方法一基础上的滚动数组
//    public boolean isInterleave(String s1, String s2, String s3) {
//        int length1 = s1.length();
//        int length2 = s2.length();
////        boolean[][] dp=new boolean[length1+1][length2+1];
//        boolean[] dp=new boolean[length2+1];
//        for(int i=1;i<length2;i++){
//            if(s3.charAt(i-1)!=s2.charAt(i-1)) break;
//            dp[i]=true;
//        }
//        dp[0]=true;
//        for(int i=1;i<length1+1;i++){
//            if(s3.charAt(i-1)==s1.charAt(i-1) && dp[0]) dp[0]=true;
//            if(s3.charAt(i-1)!=s1.charAt(i-1) || !dp[0]) dp[0]=false;
//            for(int j=1;j<length2+1;j++){
//                int idx=i+j-1;
//                boolean b=(s1.charAt(i-1)==s3.charAt(idx) && dp[j]);
//                boolean b1=(s2.charAt(j-1)==s3.charAt(idx) && dp[j-1]);
//                dp[j]=(b||b1);
//            }
//        }
//        return dp[length2];
//    }
}
