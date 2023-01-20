package dataStructure.Leetcode.Match276;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2022/1/16 10:52
 */
public class Question5194 {
    public int minMoves(int target, int maxDoubles) {
        int opt=0;
        while(target>1){
            if(target%2==0){
                if(maxDoubles>0){
                    target/=2;
                    opt++;
                    maxDoubles--;
                }else return opt+target-1;
            }else{
                target--;
                opt++;
            }
        }
        return opt;
    }
//    public int minMoves(int target, int maxDoubles) {
//        return dfs(target,maxDoubles,0,1);
//    }
//    HashMap<String,Integer> map=new HashMap<>();
//    public int dfs(long target, int max, int curDouble, int curVal){
//        String curSign=curVal+","+curDouble;
//        if(map.containsKey(curSign)) return map.get(curSign);
//        int cur=Integer.MAX_VALUE;
//        if(curVal==target){
//            return 0;
//        }
//        // 剪枝
//        if(curVal>target) return 0x3f3f3f3f;
//        // +1;
//        int dfs = dfs(target, max, curDouble, curVal + 1);
//        cur=Math.min(cur,dfs+1);
//        // *2;
//        if(curDouble<max){
//            int dfs1 = dfs(target, max, curDouble + 1, curVal * 2);
//            cur=Math.min(cur,dfs1+1);
//        }
//        map.put(curSign,cur);
//        return (int) cur;
//    }
}
