package dataStructure.Graph7Chapter;

/**
 * @author Yawen Cao
 * @data 2022/2/20 17:10
 * 寻找关节点
 */
public class ArticulNode {
    // 邻接矩阵
    static int count=0;
    static int[] visited;
    // 个人理解：当前节点能够连接的顶点的最小值(因为count逐步增大，就可以看出某个节点的子节点是否和该节点的祖先节点相连
    static int[] low;
    static int vexNum;
    public static void solution(int[][] G){
        // 顶点的数量
        int n = G.length;
        vexNum=n;
        visited=new int[n];
        low=new int[n];
        dfs(G,0);
        if(count<vexNum){
            System.out.println(0+"是关节点");
            for(int i=0;i<n;i++){
                if(visited[i]==0) dfs(G,i);
            }
        }
    }
    // cur: 当前节点
    public static void dfs(int[][] G,int cur){
        count++;
        visited[cur]=count;int min=cur;
        for(int i=0;i<vexNum;i++){
            if(visited[cur]==0){
                dfs(G,i);
                if(low[i]<min) min=low[i];
                // 说明子节点没有和祖先节点相连 该节点是关节点
                if(low[i]>=visited[cur]) System.out.println(cur+"是关节点");
            }else if(visited[i]<min) min=Math.min(min,visited[i]); // 如果该节点已经被访问过 也就意味着i是cur的祖先节点
        }
        low[cur]=min;
    }
}
