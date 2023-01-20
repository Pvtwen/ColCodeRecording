package dataStructure.Leetcode.dp1.Tree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/13 10:25
 * 题设：不能住在已经浏览过的城市 说明住宿的节点不能相邻
 */
public class NC15748 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[][] arr=new int[n-1][2];
        int idx=0;
        while(idx<arr.length){
            arr[idx][0]=sc.nextInt();
            arr[idx][1]=sc.nextInt();
            idx++;
        }
        solution(arr,s,n);
    }
    static int[][] dp;
    public static void solution(int[][] arr,int s,int n){
        int length = arr.length;
        ArrayList<Integer>[] lists=new ArrayList[n+1];
        dp=new int[n+1][2];
        for(int  i=0;i<=n;i++){
            lists[i]=new ArrayList<>();
        }
        for(int i=0;i<arr.length;i++){
            int i1 = arr[i][0];
            int i2 = arr[i][1];
            lists[i1].add(i2);
            lists[i2].add(i1);
        }
        Node node=new Node(s,null);
        dfs(lists,node);
        System.out.print(dp[s][0]);
    }
    public static void dfs(ArrayList<Integer>[] lists,Node node){
        int cur = node.n;
        if(lists[cur].size()==0){
            dp[cur][0]=0;dp[cur][1]=1;
            // 刷表
            Node parent = node.parent;
            if(parent!=null){
                dp[parent.n][0]+=Math.max(dp[cur][1],dp[cur][0]);
                dp[parent.n][1]+=dp[cur][0];
            }
            return;
        }
        for (Integer nei : lists[node.n]) {
            Node parent = node.parent;
            if(parent!=null) {
                int par=parent.n;
                if(nei==par) continue;
            }
            Node node1=new Node(nei,node);
            dfs(lists,node1);
        }
        dp[cur][1]+=1;
        // 刷表
        Node parent = node.parent;
        if(parent!=null) {
            dp[parent.n][0]+=Math.max(dp[cur][1],dp[cur][0]);
            dp[parent.n][1]+=dp[cur][0];
            Node gp = parent.parent;
        }
    }
    static class Node{
        int n;
        Node parent;
        Node(){}
        Node(int n,Node parent){
            this.n=n;
            this.parent=parent;
        }
    }
//    static int[][] dp;
//    public static void solution(int[][] arr,int s,int n){
//        int length = arr.length;
//        ArrayList<Integer>[] lists=new ArrayList[n+1];
//        // n种状态 两种抉择
//        dp=new int[n+1][2];
//        for(int i=0;i<lists.length;i++){
//            lists[i]=new ArrayList<>();
//        }
//        for(int i=0;i<length;i++){
//            int i1 = arr[i][0];
//            int i2 = arr[i][1];
//            lists[i1].add(i2);
//            lists[i2].add(i1);
//        }
//        dfs(lists,n,s,-1);
//        System.out.print(dp[s][0]);
//    }
//    // dp[i][0]: 不选i节点() 对应的i节点的子树包含的最大独立集
//    // dp[i][1]: 选择i节点(选择住宿) 对应的i节点的子树包含的最大独立集
//    // cur:当前的点 par:父节点
//    public static void dfs(ArrayList<Integer>[] lists,int n,int cur,int par){
//        // 递归结束边界
//        if(lists[cur].size()==0){
//            dp[cur][0]=0;
//            dp[cur][1]=1;
//            return;
//        }
//        for (Integer nei : lists[cur]) {
//            if(nei==par) continue;
//            dfs(lists,n,nei,cur);
//            dp[cur][1]+=dp[nei][0];
//            dp[cur][0]+=Math.max(dp[nei][0],dp[nei][1]);
//        }
//        // 加上自身节点
//        dp[cur][1]+=1;
//    }
}
