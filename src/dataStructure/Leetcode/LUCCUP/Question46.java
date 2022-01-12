package dataStructure.Leetcode.LUCCUP;

import java.util.ArrayList;

/**
 * @author Yawen Cao
 * @data 2021/10/2 20:21
 * 志愿者调配
 * 逆推  解方程  利用y=ax+b  的系数a，b 分别组建数组
 */
public class Question46 {
    public static int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int n=finalCnt.length;
        int m=plans.length;
        ArrayList<Integer>[] lists=new ArrayList[n+1];
        int[] param=new int[n+1];
        int[] cnt=new int[n+1];
        for(int i=0;i<n+1;i++){
            lists[i]=new ArrayList<>();
        }
        param[0]=1;
        for(int i=1;i<n+1;i++){
            cnt[i]=finalCnt[i-1];
        }

        for (int[] edge : edges) {
            int edgeA = edge[0];
            int edgeB = edge[1];
            lists[edgeA].add(edgeB);
            lists[edgeB].add(edgeA);
        }

        for(int i=m-1;i>=0;i--){
            int idx = plans[i][1];
            int plan=plans[i][0];
            operate(plan,idx,param,lists);
            operate(plan,idx,cnt,lists);
        }
        int par=0;
        for(int i=0;i<n+1;i++){
            totalNum-=cnt[i];
            par+=param[i];
        }
        int x= (int) (totalNum/par);
        for(int i=0;i<n+1;i++){
            cnt[i]=param[i]*x+cnt[i];
        }
        return cnt;
    }
    public static void operate(int plan,int idx,int[] arr,ArrayList<Integer>[] lists){
        if(plan==1) arr[idx]*=2;
        else{
            for (Integer node : lists[idx]) {
                if(plan==2) arr[node]-=arr[idx];
                else arr[node]+=arr[idx];
            }
        }
    }
}
