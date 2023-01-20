package dataStructure.Leetcode.dp1.LineStructure;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/22 15:06
 */
public class Uva11584 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int idx=0;
        while(idx<n){
            String s = sc.next();
            solutiion(s);
            idx++;
        }
    }
    public static void solutiion(String s){
        int length = s.length();
        // 判断i,j是否是回文
        int[][] dp=new int[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=1;
        }
        for(int len=2;len<=length;len++){
            for(int i=0;i+len-1<length;i++){
                int j=i+len-1;
                char c = s.charAt(i);
                char c1 = s.charAt(j);
                    if(len==2){
                    dp[i][j]=(c==c1)?1:0;
                }else dp[i][j]=(dp[i+1][j-1]==1 && c==c1)?1:0;
            }
        }
        // dp1[i]:0~i的字符最少可以拆分成几个回文字符串
        //
        int[] dp1=new int[length];
        for(int i=0;i<length;i++){
            //初始化
            dp1[i]=(dp[0][i]==1)?1:(i+1);
           for(int j=0;j<i;j++){
               // j+1~i是否是回文字符串
               int i1 = dp[j + 1][i];
               if(i1==1){
                   dp1[i]=Math.min(dp1[i],dp1[j]+1);
               }
           }
        }
        System.out.println(dp1[length-1]);
    }
}
