package dataStructure.Leetcode.Match269;

/**
 * @author Yawen Cao
 * @data 2021/11/29 17:49
 */
public class UnionFind {
    int[] parent;
    int[] rank;
    int firstPerson;
    int n;
    public UnionFind(int[] nums){
        parent=new int[nums.length];
        rank=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public void union(int i,int j){
        int rootx = find(i);
        int rooty = find(j);
        if(rootx!=rooty){
            if(rooty>rootx){
                parent[rootx]=rooty;
                rank[rooty]+=rank[rootx];
            }
            if(rooty<rootx){
                parent[rooty]=rootx;
                rank[rootx]+=rank[rooty];
            }
        }
    }
    public int find(int i){
        if(i!=parent[i]) parent[i]=find(parent[i]);
        return parent[i];
    }
}
