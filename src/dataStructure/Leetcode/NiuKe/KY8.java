package dataStructure.Leetcode.NiuKe;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/1 9:50
 */
public class KY8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        solution1(i);
    }
    static int N= (int) 1e9;
    static int[][] record;
    public static void solution1(int num){
        int max=0;
        int mul=1;
        while(mul<num){
            mul*=2;
            if(mul<=num) max++;
        }
        record=new int[max+1][num+1];
        int dfs = dfs(num, 0, 0,max);
        System.out.println(dfs%N);
    }
    // 前curIdx个元素 当前的和为sum 方案  stackoverflow
    public static int dfs(int num,int curIdx,int sum,int max){
        if(curIdx>max) return 0;
        if(sum>num) return 0;
        if(sum==num) return 1;
        if(record[curIdx][sum]!=0) return record[curIdx][sum];
        int ans=0;
        // 不转移 直接使用curIdx
        int dfs = dfs(num, curIdx, (int) (sum + Math.pow(2, curIdx)),max);
        // 转移 使用curIdx+1
        int dfs1 = dfs(num, curIdx + 1, sum,max);
        ans=(dfs+dfs1)%N;
        record[curIdx][sum]=ans;
        return ans;
    }
    public static void solution(int num){
        int max=0;
        int mul=1;
        while(mul<num){
            mul*=2;
            if(mul<=num) max++;
        }
        long[] dp=new long[num+1];
        Arrays.fill(dp,1);
        for(int i=1;i<=max;i++){
            for(int j = (int) Math.pow(2,i); j<=num; j++){
                dp[j]=(dp[j]+dp[(int) (j-Math.pow(2,i))])%N;
            }
        }
        System.out.println(dp[num]);
    }
//    public static void solution(int num){
//        int max=0;
//        int mul=1;
//        while(mul<num){
//            mul*=2;
//            if(mul<=num) max++;
//        }
//        long[][] dp= new long[max + 1][num + 1];
//        for(int i=0;i<=num;i++){
//            dp[0][i]=1;
//        }
//        for(int i=1;i<=max;i++){
//            for(int j=0;j<=num;j++){
//                if(j>=Math.pow(2,i)) dp[i][j]=(dp[i-1][j]+dp[i][(int) (j-Math.pow(2,i))])%N;
//                else dp[i][j]=dp[i-1][j];
//            }
//        }
//        System.out.println(dp[max][num]%N);
////        System.out.println(res%N);
//    }
}
