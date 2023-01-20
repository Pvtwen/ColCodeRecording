package dataStructure.Leetcode.dp1.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/15 9:29
 */
public class Uva1220 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n!=0){
            int[] dp=new int[n];
            // 字符串和对应的int 映射
            HashMap<String,Integer> map=new HashMap<>();
            // 员工从属关系表
            ArrayList<Integer>[] lists=new ArrayList[n];
            for(int i=0;i<n;i++){
                lists[i]=new ArrayList<>();
            }
            map.put(sc.next(),0);
            int cur=1;
            int idx=0;
            while(idx<n-1){
                String emp1 = sc.next();
                String emp2 = sc.next();
                if(!map.containsKey(emp1)){
                    map.put(emp1,cur++);
                }
                if(!map.containsKey(emp2)){
                    map.put(emp2,cur++);
                }
                // 员工与boss
                lists[map.get(emp2)].add(map.get(emp1));
                idx++;
            }
            solution(lists,n);
            n = sc.nextInt();
        }

    }
    // boss:0 而且一定不能来
    static int[][] dp;
    static int[][] f;
    // dp[i][0]: 不选i所能邀请的最大员工数
    public static void solution(ArrayList<Integer>[] lists,int n){
        dp=new int[n][2];
        // 用来记录方案是否唯一
        f=new int[n][2];
        dfs(lists,0);
        // 不唯一
        if(dp[0][0]==dp[0][1]){
            System.out.print(dp[0][0]+" ");
            System.out.print("No\n");
            return;
        }
        int max = Math.max(dp[0][0], dp[0][1]);
        if(max==dp[0][0]){
            System.out.print(dp[0][0]+" ");
            if(f[0][0]==1) System.out.print("Yes\n");
            else System.out.print("No\n");
        }else if(max==dp[0][1]){
            System.out.print(dp[0][1]+" ");
            if(f[0][1]==1) System.out.print("Yes\n");
            else System.out.print("No\n");
        }
    }
    public static void dfs(ArrayList<Integer>[] lists,int cur){
        if(lists[cur].size()==0){
            dp[cur][0]=0;dp[cur][1]=1;
            f[cur][0]=1;f[cur][1]=1;
            return;
        }
        // 特判f[child][0]==1
        int flag=1;
        int flag1=1;
        int sum1=0;
        int sum0=0;
        for (Integer child : lists[cur]) {
            dfs(lists,child);
            if(f[child][0]==0) flag=-1;
            if(dp[child][0]==dp[child][1]) flag1=-1;
            sum1+=dp[child][0];
            int max = Math.max(dp[child][0], dp[child][1]);
            if((dp[child][0]==max && f[child][0]==0) || (dp[child][1]==max && f[child][1]==0)) flag1=-1;
            sum0+=max;
        }
        if(flag==1) f[cur][1]=1;
        if(flag1==1) f[cur][0]=1;
        dp[cur][1]=sum1;dp[cur][0]=sum0;
        dp[cur][1]+=1;
    }
}
