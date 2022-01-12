package dataStructure.Leetcode.Back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/8 9:32
 */
public class Question89 {
//        public List<Integer> grayCode(int n) {
//            List<Integer> init=new ArrayList<>();
//            init.add(0);
//            if(n==0) return init;
//            init.add(1);
//            if(n==1) return init;
//            for(int i=2;i<=n;i++){
//                List<Integer> copy=new ArrayList<>(init);
//                // 正向+前导0 不管
//                // 逆向+前导1 乘1<<(i-1)
//                for(int j=init.size()-1;j>=0;j--){
//                    Integer i1 = init.get(j);
//                    int i2 = i1 + (1 << (i - 1));
//                    copy.add(i2);
//                }
//                init=copy;
//            }
//            return init;
//        }
        List<Integer> ret=new ArrayList<>();
        public List<Integer> grayCode(int n) {
            int[] s=new int[n];
            dfs(n,0,s,new int[]{0,1});
            return ret;
        }
        public void dfs(int n,int cur,int[] s,int[] arr){
            if(cur==n){
                int base=0;
                int idx=0;
                for(int i=s.length-1;i>=0;i--){
                    int c = s[i];
                    if(c==1) base+=(1<<idx);
                    idx++;
                }
                ret.add(base);
                return;
            }
            s[cur]=arr[0];
            dfs(n,cur+1,s,new int[]{0,1});
            s[cur]=arr[1];
            dfs(n,cur+1,s,new int[]{1,0});
        }
//    int[] visited;
//    List<Integer> ret=new ArrayList<>();
//    public List<Integer> grayCode(int n) {
//        int max = 1 << n;
//        visited=new int[max];
//        int[] arr=new int[max];
//        visited[0]=1;
//        arr[0]=0;
//        dfs(n,1,0,arr);
//        return ret;
//    }
//    public int  dfs(int n,int cur,int val,int[] arr){
//        if(cur==(1<<n)){
//            for (int i : arr) {
//                ret.add(i);
//            }
//            return 1;
//        }
//        // 先全部填满1
//        for(int i=0;i<n-1;i++){
//            int i1 = val | (1 << i);
//            if(visited[i1]==0){
//                visited[i1]=1;
//                arr[cur]=i1;
//                int dfs = dfs(n, cur + 1, i1, arr);
//                if(dfs==1) return 1;
//                visited[i1]=0;
//            }
//        }
//        // 退1
//        for(int i=0;i<n;i++){
//            int i1 = val & (1 << i);
//            if(i1==0) continue;
//            int i2 = val - (1 << i);
//            if(visited[i2]==0){
//                visited[i2]=1;
//                arr[cur]=i2;
//                int dfs = dfs(n, cur + 1, i2, arr);
//                if(dfs==1) return 1;
//                visited[i2]=0;
//            }
//        }
//
//        return 0;
//    }
}
