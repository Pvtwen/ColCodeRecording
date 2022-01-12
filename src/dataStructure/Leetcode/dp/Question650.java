package dataStructure.Leetcode.dp;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/12/31 15:52
 *
 */
public class Question650 {
    HashMap<String,Integer> map=new HashMap<>();
    public int minSteps(int n) {
        return dfs(n,0,1,-1);
    }
    // opt=0 上一次是复制 opt=1 上一次是粘贴  C 粘贴板的数量  cur 当前到达的
    public int dfs(int n,int C,int cur,int opt){
        String id=cur+","+C;
        if(cur>n) return 1001;
        if(map.containsKey(id)) return map.get(id);
        if(cur==n) return 0;
        int time=1001;
        // 刚开始只能复制
        if(opt==-1){
            time=Math.min(time,dfs(n,cur,cur,0));
        }
        // 如果上一次是复制 下一次只能是粘贴
        else if(opt==0){
            time=Math.min(time,dfs(n,C,cur+C,1));
        }
        // 上一次是粘贴 下一次既可以c 也可以 v
        else if(opt==1){
            time=Math.min(time,dfs(n,cur,cur,0));
            time=Math.min(time,dfs(n,C,cur+C,1));
        }
        if(time>1000) return time;
        map.put(id,time+1);
        return time+1;
    }
}
