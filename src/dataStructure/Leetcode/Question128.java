package dataStructure.Leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 86153
 * @data 2021/8/24 10:50
 */
public class Question128 {

//    //Hashmap+递归
//    static HashMap<Integer,Integer> map;
//    //设置一个访问变量
//    static boolean[] visited;
//    public static  int longestConsecutive(int[] nums) {
//        if(nums.length==0) return 0;
//        map=new HashMap<>();
//        visited=new boolean[nums.length];
//        int maxLength=1;
//        //构造哈希表
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],i);
//        }
//
//        for(int j=0;j<nums.length;j++){
//            //如果已访问过则 continue
//            if(visited[j]==false){
//                int length = recursion(nums[j], 0);
//                maxLength=Math.max(maxLength,length);
//            }
//        }
//        return maxLength;
//    }
//
//    public static int recursion(int value,int length){
//        //如果哈希表里找不到该元素 返回0
//        if(map.get(value)==null) return 0;
//        //如果已经访问过该变量 返回0
//        int index=map.get(value);
//        if(visited[index]==true) return 0;
//        visited[index]=true;
//        length++;
//        //+1代表加本身
//        return recursion(value+1,length)+recursion(value-1,length)+1;
//    }

    //并查集
//    static HashMap<Integer,Integer> map=new HashMap<>();
//    static class UnionFind{
//        int[] parent;
//        int[] rank;
//        public UnionFind(int[] nums){
//            parent=new int[nums.length];
//            rank=new int[nums.length];
//            for(int i=0;i<nums.length;i++){
//                parent[i]=i;
//                rank[i]=1;
//            }
//        }
//
//        public void Union(int i,int j){
//            if(map.get(i)==null || map.get(j)==null) return;
//            Integer index1 = map.get(i);
//            Integer index2 = map.get(j);
//
//            int rootx = find(index1);
//            int rooty = find(index2);
//            if(rootx!=rooty) {
//                if (rooty > rootx) {
//                    parent[rootx] = rooty;
//                    rank[rooty] += rank[rootx];
//                }
//                if(rooty<rootx){
//                    parent[rooty]=rootx;
//                    rank[rootx]+=rank[rooty];
//                }
//            }
//        }
//
//        public int find(int i){
//            if(i!=parent[i]) parent[i]=find(parent[i]);
//            return parent[i];
//        }
//    }
//
//    public static int longestConsecutive(int[] nums) {
//        if(nums.length==0) return 0;
//        int max=0;
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],i);
//        }
//        UnionFind uf=new UnionFind(nums);
//        for (int num : nums) {
//            uf.Union(num,num+1);
//        }
//
//        for (int count : uf.rank) {
//            max=Math.max(count,max);
//        }
//        return max;
//    }

    //记忆化 HashMap
    static HashMap<Integer,Integer> map=new HashMap<>();   // key:num[i] -- value: 右边界

    static public int longestConsecutive(int[] nums) {
        //如果要用访问变量visited，map的kv对应该是 nums[i]---i,否则找不到对应元素的下标.
        for (int num : nums) {
            map.put(num,num);
        }
        int max=1;
        int r;  //记录右边界
        for (int num : nums) {
            r=num;
            while(map.containsKey(r+1)) r=map.get(r+1);
            max=Math.max(max,r-num+1);
        }
        return max;
    }
}
