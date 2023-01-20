package dataStructure.Leetcode.dp1.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/21 11:03
 */
public class Uva12186 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // N: 员工个数
        int N = sc.nextInt();
        int T = sc.nextInt();
        while(N!=0 && T!=0){
            int[] arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            solution(arr,N,T);
            N=sc.nextInt();
            T=sc.nextInt();
        }
    }
    static int[] dp;
    public static void solution(int[] arr,int N,int T){
        ArrayList<Integer>[] lists=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            lists[i]=new ArrayList<>();
        }
        // 建立邻接表
        for(int i=0;i<arr.length;i++){
            int i1 = arr[i];
            lists[i1].add(i+1);
        }
        dp=new int[N+1];
        dfs(lists,N,T,0);
        System.out.println(dp[0]);
    }
    // cur ： 当前员工  dp[i]:i如果要向上级请愿 至少需要多少名员工
    public static void dfs(ArrayList<Integer>[] lists,int N,int T,int cur){
        if(lists[cur].size()==0) {
            dp[cur]=1; return;
        }
        // 不算上自己本身
        dp[cur]=0;
        for (Integer emp : lists[cur]) {
            dfs(lists,N,T,emp);
        }
        // 至少需要(k*T+1)/100个工人请愿
        // k:子节点的数目
        int k = lists[cur].size();
        // k*T-1 防止出现T=100% 而出现下标越界
        int c=(k*T-1)/100+1;
        int[] arr=new int[k];
        int idx=0;
        for (Integer emp : lists[cur]) {
            arr[idx++]=dp[emp];
        }
        Arrays.sort(arr);
        for(int i=0;i<c;i++){
            dp[cur]+=arr[i];
        }
    }
}
