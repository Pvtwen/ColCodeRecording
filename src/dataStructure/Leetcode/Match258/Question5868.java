package dataStructure.Leetcode.Match258;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/9/12 10:42
 */
public class Question5868 {
//    class UnionFind{
//        int[] parent;
//        int[] rank;
//        public UnionFind(int[][] rectangles){
//            parent=new int[rectangles.length];
//            rank=new int[rectangles.length];
//            for(int i=0;i<rectangles.length;i++){
//                parent[i]=i;
//                rank[i]=1;
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
//            rank[rootx]+=1;
//        }
//    }
//    public long interchangeableRectangles(int[][] rectangles) {
//        long res=0;
//        UnionFind uf=new UnionFind(rectangles);
//        for(int i=0;i<rectangles.length-1;i++){
//            if(uf.parent[i]!=i) continue;
//            for(int j=i+1;j<rectangles.length;j++){
//                if(uf.parent[j]!=j) continue;
//                if(rectangles[i][0]*rectangles[j][1]==rectangles[i][1]*rectangles[j][0]) uf.union(i,j);
//            }
//        }
//
//        for(int i=0;i<rectangles.length;i++){
//            int count=uf.rank[i];
//            if(count!=1) res+=(count*(count-1))/2;
//        }
//        return res;
//    }

//    public long interchangeableRectangles(int[][] rectangles) {
//        long res=0;
//        HashMap<Integer,Integer> map=new HashMap<>();
//        boolean[] visited=new boolean[rectangles.length];
//
//        for(int i=0;i<rectangles.length-1;i++){
//            if(visited[i]==true) continue;
//            for(int j=i+1;j<rectangles.length;j++){
//                if(visited[j]==true) continue;
//                if(rectangles[i][0]*rectangles[j][1]==rectangles[i][1]*rectangles[j][0]){
//                    visited[j]=true;
//                    if(!map.containsKey(i)) map.put(i,2);
//                    else{
//                        Integer count = map.get(i);
//                        map.put(i,count +1);
//                    }
//                }
//            }
//        }
//
//        for (Integer index : map.keySet()) {
//            Integer count = map.get(index);
//            res+=(count*(count-1))/2;
//        }
//        return res;
//    }

//    public long interchangeableRectangles(int[][] rectangles) {
//        HashMap<Double,Long> map=new HashMap<>();
//        long res=0;
//        for(int i=0;i<rectangles.length;i++){
//            double num=rectangles[i][0]/(double)rectangles[i][1];
//            if(!map.containsKey(num)) map.put(num, (long) 1);
//            else map.put(num,map.get(num)+1);
//        }
//        for (Double num : map.keySet()) {
//            Long count = map.get(num);
//            if(count>1) res+=(count*(count-1))/2;
//        }
//        return res;
//    }

    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Long,Long> map=new HashMap<>();
        long res=0;
        for(int i=0;i<rectangles.length;i++){
            int div = gcd(rectangles[i][1], rectangles[i][0]);
            long frac=(rectangles[i][1]/div*10000)+(rectangles[i][0]/div);
//            if(!map.containsKey(frac)) map.put(frac, (long) 1);
//            else map.put(frac,map.get(frac)+1);
            map.put(frac,map.getOrDefault(frac,(long)0)+1);
        }

        for (Long value : map.values()) {
            res+=(value*(value-1))/2;
        }
        return res;
    }
    // a>b
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
