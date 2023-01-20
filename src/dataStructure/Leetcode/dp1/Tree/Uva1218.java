package dataStructure.Leetcode.dp1.Tree;

import dataStructure.Test.S;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Yawen Cao
 * @data 2022/2/16 10:03
 */
public class Uva1218 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(true){
            int idx=0;
            int[][] arr=new int[n-1][2];
            for(int i=0;i<n-1;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            solution(arr);
            n = sc.nextInt();
            if(n==-1) break;
            n=sc.nextInt();
            stack=new Stack<>();
        }
    }
    // 递推
    static Stack<Integer> stack=new Stack<>();
    static int[] parents;
    public static void solution(int[][] arr){
        int n = arr.length;
        parents=new int[n+2];
        ArrayList<Integer>[] lists=new ArrayList[n+2];
        int[][] dp=new int[n+2][3];
        for(int i=0;i<n+2;i++){
            lists[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int i1 = arr[i][0];
            int i2 = arr[i][1];
            lists[i1].add(i2);
            lists[i2].add(i1);
        }
        // 建树
        dfs(lists,1,-1);
        while(!stack.isEmpty()){
            Integer node = stack.pop();
            dp[node][0]=1;
            for (Integer child : lists[node]) {
                if(child==parents[node]) continue;
                dp[node][0]+=Math.min(dp[child][0],dp[child][1]);
                dp[node][1]+=dp[child][2];
                if(dp[node][0]>1e9) dp[node][0]= (int) 1e9;
                if(dp[node][1]>1e9) dp[node][1]= (int) 1e9;
            }
            dp[node][2]= (int) 1e8;
            for (Integer child : lists[node]) {
                if(child==parents[node]) continue;
                dp[node][2]=Math.min(dp[node][2],dp[node][1]-dp[child][2]+dp[child][0]);
            }
        }
        System.out.println(Math.min(dp[1][0],dp[1][2]));
    }
    public static void dfs(ArrayList<Integer>[] lists,int cur,int par){
        parents[cur]=par;
        stack.push(cur);
        for (Integer child : lists[cur]) {
            if(child==par) continue;
            dfs(lists,child,cur);
        }
    }
//    static int[][] dp;
//    public static void solution(int[][] arr){
//        int n = arr.length;
//        ArrayList<Integer>[] lists=new ArrayList[n+2];
//        for(int i=0;i<n+2;i++) {
//            lists[i] = new ArrayList<>();
//        }
//        for(int i=0;i<n;i++){
//            int i1 = arr[i][0];
//            int i2 = arr[i][1];
//            lists[i1].add(i2);
//            lists[i2].add(i1);
//        }
//        // 假定1是 根
//        dp=new int[n+2][3];
//        dfs(lists,1,-1);
//        System.out.println(Math.min(dp[1][0],dp[1][2]));
//    }
//    public static void dfs(ArrayList<Integer>[] lists,int cur,int par){
//        dp[cur][0]=1;
//        int son=0;
//        for (Integer child : lists[cur]) {
//            if(child==par) continue;
//            son++;
//            dfs(lists,child,cur);
//            dp[cur][0]+=Math.min(dp[child][0],dp[child][1]);
//            dp[cur][1]+=dp[child][2];
//            // 溢出判断
//            if(dp[cur][0]>1e9) dp[cur][0]= (int) 1e9;
//            if(dp[cur][1]>1e9) dp[cur][1]= (int) 1e9;
//        }
//        int min= (int) 1e8;
//        for (Integer child : lists[cur]) {
//            if(par==child) continue;
//            min=Math.min(min,dp[cur][1]-dp[child][2]+dp[child][0]);
//        }
//        dp[cur][2]=min;
//    }
}
