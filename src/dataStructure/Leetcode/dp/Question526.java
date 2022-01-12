package dataStructure.Leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/12/21 9:33
 */

public class Question526 {
    // ¼ÇÒä»¯µÝ¹é
//    HashSet<List<Integer>> set=new HashSet<>();
//    public int countArrangement(int n) {
//        int res=0;
//        for(int i=1;i<=n;i++){
//            HashSet<Integer> dist = new HashSet<>();
//            dist.add(i);
//            res+=dfs(n,i,1,new ArrayList<>(),dist);
//            // ´òÓ¡Â·¾¶
//            for (Integer integer : dist) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }
//        return res;
//    }
//    public int dfs(int n, int cur, int idx,List<Integer> steps,HashSet<Integer> dist){
//        if(set.contains(steps))  return 1;
//        if(idx==n){
//            if(cur%idx==0 || idx%cur==0){
//                steps.add(cur);
//                set.add(steps);
//                return 1;
//            }
//            return 0;
//        }
//        if(cur%idx!=0 && idx%cur!=0) return 0;
//        int que=0;
//        for(int i=1;i<=n;i++){
//            if(!dist.contains(i)){
//                List<Integer> copy=new ArrayList<>(steps);
//                HashSet<Integer> cop=new HashSet<>(dist);
//                cop.add(i);
//                int dfs = dfs(n, i, idx + 1, copy, cop);
//                if(dfs==1){
//                    copy.add(cur);
//                    que++;
//                    set.add(copy);
//                }
//            }
//        }
//        return que;
//    }

//    public int countArrangement(int n) {
//        return dfs(n,1,new HashSet<>());
//    }
//
//    public int dfs(int n, int idx, Set<Integer> set) {
//        if(idx>n) return 1;
//        int ans=0;
//        for(int i=1;i<=n;i++){
//            if(!set.contains(i) && (idx%i==0 || i%idx==0)){
//                Set<Integer> cop=new HashSet<>(set);
//                cop.add(i);
//                ans+=dfs(n,idx+1,cop);
//            };
//        }
//        return ans;
//    }

    // dfs+×´Ì¬Ñ¹Ëõ
    public int countArrangement(int n) {
        return dfs(n,1,0);
    }
    public int dfs(int n,int idx,int val){
        if(idx>n) return 1;
        int ans=0;
        for(int i=1;i<=n;i++){
            if(((1<<i)&val)==0 && (i%idx==0 || idx%i==0)){
                ans+=dfs(n,idx+1,(1<<i)|val);
            }
        }
        return ans;
    }
}
