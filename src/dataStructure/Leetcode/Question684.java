package dataStructure.Leetcode;

/**
 * @author 86153
 * @data 2021/8/28 11:04
 */
public class Question684 {
    class UnionFind{
        int[] parent;

        public UnionFind(int[][] edges){
            parent=new int[edges.length+1];
            for(int i=1;i<edges.length;i++){
                parent[i]=i;
            }
        }
        public int find(int i){
            if(parent[i]!=i) parent[i]=find(parent[i]);
            return parent[i];
        }
        public void union(int i,int j){
            int rootx = find(i);
            int rooty = find(j);
            parent[rooty]=rootx;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] res=null;
        UnionFind uf=new UnionFind(edges);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) res = edge;
            else uf.union(edge[0], edge[1]);
        }
        return res;
    }
}
