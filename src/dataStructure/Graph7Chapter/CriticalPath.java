package dataStructure.Graph7Chapter;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/2/20 18:08
 */
public class CriticalPath {
    // lists:邻接表    T：该栈用于后续逆序拓扑排序
    static int[] ve;
    public static void topoLogicalSort(ArrayList<Integer>[] lists, Stack<Integer> T,int[][] weigh,Deque<Integer> S){
        // 顶点的个数
        int n = lists.length;
        // 记录每个顶点的入度
        int[] indegrees=new int[n];
        for(int i=0;i<n;i++){
            for (Integer next : lists[i]) {
                indegrees[next]++;
            }
        }
        S=new ArrayDeque<>();
        // 入度为0
        for(int i=0;i<n;i++){
            if(indegrees[i]==0) S.offer(i);
        }
        while(!S.isEmpty()){
            Integer node = S.pollFirst();
            T.add(node);
            for (Integer next : lists[node]) {
                indegrees[next]--;
                ve[next]=Math.max(ve[next],ve[node]+weigh[node][next]);
                if(indegrees[next]==0) S.offer(next);
            }
        }
    }
    static int[] vl;
    static int[] rec;
    public static void criticalPath(ArrayList<Integer>[] lists,int[][] weigh){
        Stack<Integer> T=new Stack<>();
        Deque<Integer> S=new ArrayDeque<>();
        topoLogicalSort(lists,T,weigh,S);
        int n = lists.length;
        vl=new int[n];
        Arrays.fill(vl,ve[n-1]);

        // 此处也可以利用dfs进行求解vl
        rec=new int[n];
        Arrays.fill(rec,Integer.MAX_VALUE);
        // 从0开始
        dfs(lists,weigh,0);

        //此处也可以利用之前的栈T通过逆拓扑进行求解
        while(!T.isEmpty()){
            Integer node = T.pop();
            for (Integer from : lists[node]) {
                vl[from]=Math.min(vl[from],vl[node]-weigh[from][node]);
                // 关键活动
            }
        }
        for(int i=0;i<n;i++){
            for (Integer next : lists[i]) {
                int el = vl[i];
                int ee=vl[next]-weigh[i][next];
                if(el==ee) System.out.println(i);
            }
        }
    }
    // cur: 当前节点
    public static int dfs(ArrayList<Integer>[] lists,int[][] weigh,int cur){
        if(lists[cur].size()==0){
            rec[cur]=ve[cur];
            return rec[cur];
        }
        if(rec[cur]!=Integer.MAX_VALUE) return rec[cur];
        int ans=Integer.MAX_VALUE;
        for (Integer next : lists[cur]) {
            ans=Math.min(ans,dfs(lists,weigh,next)-weigh[cur][next]);
        }
        rec[cur]=ans;
        return ans;
    }
}
