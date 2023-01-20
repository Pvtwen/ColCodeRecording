package dataStructure.Leetcode.dp1;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/2/5 11:20
 * 嵌套矩形问题
 */
public class Q354 {
    // LIS
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int n = envelopes.length;
        int[] dp=new int[n];
        int ret=1;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(isValid(envelopes[j],envelopes[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ret=Math.max(ret,dp[i]);
        }
        return ret;
    }
    public boolean isValid(int[] a,int[] b){
        return a[0]<b[0] && a[1]<b[1];
    }
    // 拓扑排序 超时
//    public int maxEnvelopes(int[][] envelopes) {
//        int n = envelopes.length;
//        ArrayList<Integer>[] routes=new ArrayList[n];
//        for(int i=0;i<n;i++){
//            routes[i]=new ArrayList<>();
//        }
//        int[] indegrees=new int[n];
//        // 构件图
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                int w1 = envelopes[i][0];
//                int h1 = envelopes[i][1];
//                int w2 = envelopes[j][0];
//                int h2 = envelopes[j][1];
//                if((w1<w2 && h1<h2)){
//                    routes[i].add(j);
//                    indegrees[j]++;
//                }else if((w2<w1 && h2<h1)){
//                    routes[j].add(i);
//                    indegrees[i]++;
//                }
//            }
//        }
//        Deque<int[]> queue=new ArrayDeque<>();
//        // 入度为0
//        for(int i=0;i<n;i++){
//            if(indegrees[i]==0){
//                queue.offer(new int[]{i,1});
//            }
//        }
//        int ret=1;
//        // 可能有多条路径到达同一个信封 存储最大的哪条路径
//        HashMap<Integer,Integer> map=new HashMap<>();
//        while(!queue.isEmpty()){
//            int[] poll = queue.poll();
//            int node = poll[0];
//            if(routes[node].size()==0) ret=Math.max(ret,poll[1]);
//            for (Integer next : routes[node]) {
//                indegrees[next]--;
//                if(map.containsKey(next)){
//                    Integer record = map.get(next);
//                    if(poll[1]+1>record){
//                        map.put(next,poll[1]+1);
//                    }
//                }else{
//                    map.put(next,poll[1]+1);
//                }
//                if(indegrees[next]==0){
//                    queue.offer(new int[]{next,map.get(next)});
//                }
//            }
//        }
//        return ret;
//    }
    // 记忆化递归 超时
    HashMap<Integer,Integer> map=new HashMap<>();
    public int dfs(ArrayList<Integer>[] routes,int cur){
        if(routes[cur].size()==0){
            return 1;
        }
        if(map.containsKey(cur)) return map.get(cur);
        int len=0;
        for (Integer next : routes[cur]) {
            len=Math.max(len,1+dfs(routes,next));
        }
        map.put(cur,len);
        return len;
    }

    // 如果要求字典序最小 不能用LIS
    int[] res=new int[(int) 1e5];
    int rec=1;
    public void dfs1(ArrayList<Integer>[] routes,int[] ret,int cur,int idx){
        if(routes[idx].size()==0){
            ret[cur++]=idx;
            if(cur>rec){
                res=Arrays.copyOf(ret,ret.length);
                rec=cur;
            }
            return;
        }
        for (Integer next : routes[idx]) {
            ret[cur]=next;
            dfs1(routes,ret,cur+1,next);
        }
    }
}
