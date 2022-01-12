package dataStructure.Leetcode.Match257;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/9/6 18:59
 */
public class Question5866 {
    int length= (int) Math.pow(10,5);
    class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int[] nums){
            parent=new int[length];
            rank=new int[length];
            for(int i=2;i<=length;i++){
                parent[i]=i;
            }
            Arrays.fill(rank,1);
        }
        public int find(int i){
            if(parent[i]!=i) parent[i]=find(parent[i]);
            return parent[i];
        }
        public void union(int i,int j){
            int rootx = find(i);
            int rooty = find(j);
            if(rootx!=rooty){
                if(rank[rootx]>rank[rooty]) {
                    parent[rooty]=rootx;
                    rank[rootx]++;
                }
                else if(rank[rootx]<rank[rooty]){
                    parent[rootx]=rooty;
                    rank[rooty]++;
                }
                else{
                    parent[rooty]=rootx;
                    rank[rootx]++;
                }
            }
        }
    }
    public boolean gcdSort(int[] nums) {
        UnionFind uf=new UnionFind(nums);

        for(int val:nums){
            int k=val;
            for(int i=2;i<=val/i;i++){
                boolean flag=false;
                while(val%i==0){
                    val/=i;
                    flag=true;
                }
                if(flag) uf.union(k,i);
            }
            if(val>1) uf.union(k,val);
        }

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=copy[i]){
                if(uf.find(nums[i])!=uf.find(copy[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}
