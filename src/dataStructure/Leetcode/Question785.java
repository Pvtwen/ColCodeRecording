package dataStructure.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 86153
 * @data 2021/9/2 22:17
 */
public class Question785 {
 // 方法一 效率较低的dfs
//        static boolean[] visited;
//
//    public static boolean isBipartite(int[][] graph) {
//        visited = new boolean[graph.length];
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].length; j++) {
//                if (!dfs(graph, graph[i][j], 1, i, i)) return false;
//            }
//            Arrays.fill(visited, false);
//        }
//        return true;
//    }
//
//    public static boolean dfs(int[][] graph, int to, int step, int begin, int from) {
////    如果步数为奇数 则不是二分图
//        if(to==begin) return step % 2 == 0;
//        visited[to] = true;
//        for (int i = 0; i < graph[to].length; i++) {
//            if (graph[to][i] != from) {
//                    if (!visited[graph[to][i]]) {
//                        if (!dfs(graph, graph[to][i], step + 1, begin, to)) return false;
//                    }
//            }
//        }
//        return true;
//    }

    //方法二  并查集
//    思路: 将graph[i]中的所有元素合并为一个集合，如果graph[i]中任一元素的父节点与i相同，则不是二分图
//    HashMap<Integer,Integer> map=new HashMap<>();
//    class UnionFind{
//        int[] parent;
//        public UnionFind(int[][] graph){
//            parent=new int[graph.length];
//            for(int i=0;i<graph.length;i++){
//                parent[i]=i;
//            }
//        }
//
//        public int find(int i){
//            if(parent[i]!=i) parent[i]=find(parent[i]);
//            return parent[i];
//        }
//        public void union(int i,int j){
//            int rootx = find(i);
//            int rooty = find(j);
//            parent[rooty]=rootx;
//        }
//    }
//    public boolean isBipartite(int[][] graph) {
//        UnionFind uf=new UnionFind(graph);
//        for(int i=0;i<graph.length;i++){
//            int head=graph[i][0];
//            map.put(i,head);
//            for(int j=1;j<graph[i].length;j++){
//                if(!map.containsKey(head)){
//                    uf.union(head,graph[i][j]);
//                }else{
//                    Integer opp = map.get(head);
//                    if(uf.find(graph[i][j])==opp) return false;
//                    else uf.union(head,graph[i][j]);
//                }
//            }
//        }
//        return true;
//    }

    // 方法三 dfs 染色法
//    HashMap<Integer,Integer> map;
//    public boolean isBipartite(int[][] graph) {
//        map=new HashMap<>();
//        for(int node=0;node<graph.length;node++){
//            if(map.containsKey(node)) continue;
//            else{
//                boolean OK = dfs(node, 0, graph);
//                if(!OK) return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean dfs(int node,int c,int[][] graph){
//        if(map.containsKey(node)){
//            Integer color = map.get(node);
//            return color==c;
//        }else{
//            map.put(node,c);
//            for (int i : graph[node]) {
//                boolean OK = dfs(i, c ^ 1, graph);
//                if(!OK) return false;
//            }
//        }
//        return true;
//    }

    //BFS  单独设置哈希表用作涂色
//    public boolean isBipartite(int[][] graph) {
//        Queue<Integer> queue=new LinkedList<>();
//        boolean[] visited=new boolean[graph.length];
//        int c;
//        HashMap<Integer,Integer> map=new HashMap<>();
//
//        for(int i=0;i<graph.length;i++){
//            if(visited[i]) continue;
//            visited[i]=true;
//            // 每当从头访问一个没有被访问过的元素，将颜色重置为0
//            c=0;
//            map.put(i,c);
//            queue.offer(i);
//            while(!queue.isEmpty()){
//                Integer node = queue.poll();
//                Integer nodeColor = map.get(node);
//                // 节点的子元素的颜色与节点的颜色相反 取补集
//                c=nodeColor^1;
//                for (int friend : graph[node]) {
//                    // 如果已经访问过该元素，那么判断该元素的颜色类型是否正确
//                    if(visited[friend]){
//                        int color = map.get(friend);
//                        if(color!=nodeColor) return false;
//                    }else{
//                        //如果没有访问该元素，将该元素入队列，颜色入哈希表，访问变量设置为true
//                        queue.offer(friend);
//                        map.put(friend,c);
//                        visited[friend]=true;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    //BFS visited变量用做涂色
    public boolean isBipartite(int[][] graph) {
        int[] visited=new int[graph.length];
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(visited[i]!=0) continue;
            visited[i]=1;
            queue.offer(i);

            while(!queue.isEmpty()){
                Integer node = queue.poll();
                int color=visited[node];
                for (int friend : graph[node]) {
                    if(visited[friend]!=0){
                        if(visited[friend]==color) return false;
                    }else{
                        visited[friend]=-color;
                        queue.offer(friend);
                    }
                }
            }
        }
        return true;
    }

}