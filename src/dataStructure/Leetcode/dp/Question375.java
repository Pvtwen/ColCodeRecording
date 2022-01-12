package dataStructure.Leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/23 9:02
 */
public class Question375 {
    static int N=210;
    static int[][] cache=new int[N][N];
    public int getMoneyAmount(int n) {
        return dfs(1,n);
    }
    public int dfs(int l,int r){
        if(l>=r) return 0;
        if(cache[l][r]!=0) return cache[l][r];
        int ans=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int ret = Math.max(dfs(l, i - 1), dfs(i + 1, r)) + i;
            ans=Math.min(ans,ret);
        }
        cache[l][r]=ans;
        return ans;
    }
//    public static void main(String[] args) {
//        int moneyAmount = getMoneyAmount(2);
//        System.out.println(moneyAmount);
//    }
//    static int[] arr;
//    public static int getMoneyAmount(int n) {
//        arr=new int[n+1];
//        for(int i=1;i<=n;i++){
//            List<Integer> list=new ArrayList<>();
//            list.add(i);
//            ArrayList<Integer> copy = new ArrayList<>(list);
//            dfs(1, i-1,copy,i);
//            dfs(i + 1, n,list,i);
//        }
//        int min=Integer.MAX_VALUE;
//        for(int i=1;i<=n;i++){
//            min=Math.min(min,arr[i]);
//        }
//        return min;
//    }
//    public static int dfs(int left,int right){
//        int mid=(left+right)/2;
//        if(mid-left<=2 || right-mid<=2) return mid;
//        int max = Math.max(dfs(left, mid), dfs(mid + 1, right));
//        return max+mid;
//    }
//    public static void dfs(int left, int right, List<Integer> res,int idx){
//        if(right<left) return;
//        int mid=(left+right)/2;
//        res.add(mid);
//        ArrayList<Integer> copy = new ArrayList<>(res);
//
//        if(right-left<3){
//            maxValue(res,idx);
//            return;
//        }
//        if(right-mid<2){
//            maxValue(res,idx);
//            dfs(left,mid-1,copy,idx);
//            return;
//        }
//        if(mid-left<2){
//            maxValue(res,idx);
//            dfs(mid+1,right,copy,idx);
//            return;
//        }
//        dfs(left, mid-1,copy,idx);
//        dfs(mid + 1, right,res,idx);
//    }
//    public static void maxValue(List<Integer> ans,int idx){
//        int sum=0;
//        for (Integer an : ans) {
//            sum+=an;
//        }
//        arr[idx]=Math.max(arr[idx],sum);
//    }
}
