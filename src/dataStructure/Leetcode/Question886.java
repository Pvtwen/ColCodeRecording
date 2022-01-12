package dataStructure.Leetcode;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/9/9 16:07
 */
public class Question886 {
//    static class UnionFind{
//        int[] parent;
//        public UnionFind(int n){
//            parent=new int[n+1];
//            for(int i=1;i<=n;i++){
//                parent[i]=i;
//            }
//        }
//
//        public int find(int i){
//            if(parent[i]!=i) parent[i]=find(parent[i]);
//            return parent[i];
//        }
//
//        public void union(int i,int j){
//            int rootx = find(i);
//            int rooty = find(j);
//            parent[rooty]=rootx;
//        }
//    }
//    public static boolean possibleBipartition(int n, int[][] dislikes) {
//        // 先以dislikes[i][0] 从小到大排序 以便后续合并
//        // 如果是乱序的 无法判断元素的根到底是head1 还是head2
//        Arrays.sort(dislikes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//
//        UnionFind uf=new UnionFind(n);
//        int head1=dislikes[0][0];
//        int head2=dislikes[0][1];
//
//        for(int i=1;i<dislikes.length;i++){
//            int root0 = uf.find(dislikes[i][0]);
//            int root1 = uf.find(dislikes[i][1]);
//
//            if(root0==root1) return false;
//            else{
//                // 合并
//                if(root0==head1) uf.union(head2,dislikes[i][1]);
//                else if(root1==head1) uf.union(head2,dislikes[i][0]);
//                else if(root0==head2) uf.union(head1,dislikes[i][1]);
//                else if(root1==head2) uf.union(head1,dislikes[i][0]);
//                // 以防测试用例68出现的情况
//                // 5            [[1,2],[3,4],[4,5],[3,5]]
//                else{
//                    head1=dislikes[i][0];
//                    head2=dislikes[i][1];
//                }
//            }
//        }
//        return true;
//    }

    // dfs  染色法
    HashMap<Integer,Integer> map;
    ArrayList<Integer>[] arr;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        arr=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<>();
        }
        //构建零阶矩阵
        for(int i=0;i<dislikes.length;i++){
            arr[dislikes[i][0]].add(dislikes[i][1]);
            arr[dislikes[i][1]].add(dislikes[i][0]);
        }

        map=new HashMap<>();
        for(int node=1;node<=n;node++){
            if(map.containsKey(node)) continue;
            else{
                boolean Ok=dfs(node,0);
                if(!Ok) return false;
            }
        }
        return true;
    }

    public boolean dfs(int node,int c){
        if(map.containsKey(node)){
            Integer color = map.get(node);
            return color==c;
        }else{
            for (Integer friend : arr[node]) {
                boolean OK = dfs(friend, c ^ 1);
                if(!OK) return false;
            }
        }
        return true;
    }
}