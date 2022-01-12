package dataStructure.Leetcode.Match257;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/9/7 16:27
 */
public class Question5866Review {
    int maxLength=100010;
    class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int[] nums){
            parent=new int[maxLength];
            rank=new int[maxLength];
            for(int i=2;i<maxLength;i++){
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
                if(rank[rootx]>rank[rooty]){
                    parent[rooty]=rootx;
                    rank[rootx]++;
                }else if(rank[rooty]>rank[rootx]){
                    parent[rootx]=rooty;
                    rank[rooty]++;
                }else{
                    parent[rooty]=rootx;
                    rank[rootx]++;
                }
            }
        }
    }
    public boolean gcdSort(int[] nums) {
        UnionFind uf=new UnionFind(nums);
        for(int num:nums){
            int k=num;
            for(int i=2;i<num/i;i++){
                boolean flag=false;
                while(num%i==0){
                    //筛选出所有相同的质数
                    num/=i;
                    flag=true;
                }
                if(flag) uf.union(k,i);
            }
            // 这里的条件用于合并质数其本身 以及 可以写成某数平方的数  例如 4,9，16
            // 因为该类数字经过循环之后num变为1 不能将1合并为一类  1是所有数字的质数
            if(num>1) uf.union(k,num);
        }
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(copy[i]!=nums[i]){
                if(uf.find(copy[i])!=uf.find(nums[i])) return false;
            }
        }
        return true;
    }
}
