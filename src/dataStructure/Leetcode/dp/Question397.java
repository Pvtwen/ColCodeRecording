package dataStructure.Leetcode.dp;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/19 9:00
 */
public class Question397 {
    public int integerReplacement(int a) {
        long n=a*1L;
        int res=0;
        while(n!=1){
            long bit = n & 1;
            if(bit==0){
                n>>=1;
                res++;
            }else{
                if(n==3){
                    n--;
                }else if(((n>>1)&1)==1){
                    n++;
                }else{
                    n--;
                }
                res++;
            }
        }
        return res;
    }
}

//    HashMap<Long,Integer> map=new HashMap<>();
//    public int integerReplacement(int n) {
//        return dfs(n*1L);
//    }
//    public int dfs(long n){
//        if(n==1) return 0;
//        if(map.containsKey(n)) return map.get(n);
//        int res;
//        if(n%2==0){
//            res=dfs(n/2);
//        }else{
//            int val1=dfs(n+1);
//            int val2=dfs(n-1);
//            res=Math.min(val1,val2);
//        }
//        res++;
//        map.put(n,res);
//        return res;
//    }

//    public static int integerReplacement(int n) {
//        if(n==1) return 0;
//        HashMap<Long,Integer> map=new HashMap<>();
//        Deque<Long> queue=new ArrayDeque<>();
//        queue.offer(n*1L);
//        map.put(n*1L,0);
//        while(!queue.isEmpty()){
//            Long poll = queue.poll();
//            Integer step = map.get(poll);
//            if(poll%2==0){
//                poll/=2;
//                if(poll==1) return step+1;
//                if(!map.containsKey(poll)){
//                    map.put(poll,step+1);
//                    queue.offer(poll);
//                }
//            }else{
//                long val1 = poll + 1;
//                long val2 = poll - 1;
//                if(val1==1 || val2==1) return step+1;
//                if(!map.containsKey(val1)){
//                    queue.offer(val1);
//                    map.put(val1,step+1);
//                }
//                if(!map.containsKey(val2)){
//                    queue.offer(val2);
//                    map.put(val2,step+1);
//                }
//            }
//        }
//        return 1;
//    }

//    public int integerReplacement(int n) {
//        if(n==1) return 0;
//        Set<Long> set=new HashSet<>();
//        Deque<long[]> queue=new ArrayDeque<>();
//        queue.offer(new long[]{n,0});
//        set.add(n*1L);
//        while(!queue.isEmpty()){
//            long[] poll = queue.poll();
//            long val = poll[0];
//            long step = poll[1];
//            if(val%2==0){
//                val/=2;
//                if(val==1) return (int) (step+1);
//                if(!set.contains(val)){
//                    set.add(val);
//                    queue.offer(new long[]{val,step+1});
//                }
//            }else{
//                long val1 = val + 1;
//                long val2 = val - 1;
//                if(val1==1 || val2==1) return (int) (step+1);
//                if(!set.contains(val1)){
//                    set.add(val1);
//                    queue.offer(new long[]{val1,step+1});
//                }
//                if(!set.contains(val2)){
//                    set.add(val2);
//                    queue.offer(new long[]{val2,step+1});
//                }
//            }
//        }
//        return 1;
//    }
