package dataStructure.Leetcode.UVa;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/9 14:59
 */
public class Uva140 {
    static Map<Integer, List<Integer>> set;
    static int minBroad=Integer.MAX_VALUE;
    static int[] ret;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        while(!s.equals("#")){
            solution(s);
            minBroad=Integer.MAX_VALUE;
            ret=null;
            set.clear();
            s = sc.next();
        }
    }
    public static void solution(String s){
        String[] split = s.split(";");
        set=new HashMap<>();
        for (String s1 : split) {
            char[] arr = s1.toCharArray();
            int i = arr[0] - 'A';
            set.put(i,new ArrayList<>());
            List<Integer> l1 = set.get(i);
            for(int j=2;j<arr.length;j++){
                int val = arr[j] - 'A';
                if(!set.containsKey(val)){
                    set.put(val,new ArrayList<>());
                }
                List<Integer> l2 = set.get(val);
                l1.add(val);
                l2.add(i);
            }
        }
        int n = set.size();
        int[][] arr=new int[n][2];
        int idx=0;
        for (Integer integer : set.keySet()) {
            arr[idx][0]=integer;
            arr[idx][1]=0;
            idx++;
        }
        int[] res=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        dfs(n,0,res,arr,map);
        //print
        for (int i : ret) {
            char c = (char) (i + 'A');
            System.out.print(c+" ");
        }
        System.out.print("-> "+minBroad+"\n");
    }
    // n:结点的个数
    public static void dfs(int n,int cur,int[] res,int[][] arr,Map<Integer,Integer> map){
        // 计算带宽
        if(cur==n){
            int[] bandWidth=new int[n];
            int idx=0;
            for (int i : res) {
                int distance = distance(i, map, set);
                bandWidth[idx]=distance;
                idx++;
            }
            // 找到最大的带宽
            int max=bandWidth[0];
            for(int i=1;i<bandWidth.length;i++){
                max=Math.max(max,bandWidth[i]);
            }
            if(max==minBroad){
                for(int i=0;i<n;i++){
                    int i1 = res[i];
                    int i2 = ret[i];
                    if(i1<i2) {
                        ret=Arrays.copyOf(res,res.length);
                        return;
                    }else if(i1>i2) return;
                }
            }
            if(max<minBroad){
                minBroad=max;
                ret=Arrays.copyOf(res,res.length);
            }
            return;
        }
        // 剪枝 如果有错 把该步注释 不一定正确
        for (int i=0;i<cur;i++) {
            List<Integer> list = set.get(res[i]);
            int m=0;
            for (Integer neigh : list) {
                // 如果还没有访问到邻接点 +1
                if(!map.containsKey(neigh)){
                    m++;
                }
                // 如果已经访问过该邻接点 则计算两点之间的距离 如果大于等于minBroad 那么最优解比不可能是该条路径 剪枝
                else{
                    int abs = Math.abs(map.get(neigh) - map.get(res[i]));
                    if(abs>=minBroad) return;
                }
            }
            // 遍历完之后 还需要再剪枝 看m的值和minBroad。m的意思就是还没有确定位置的邻接点的最优位置就是挨着该节点
            // cur-map.get(res[i]) +m 即为当前最优解 如果m>=minBroad同样不可能得到更优解 剪枝
            if(cur-map.get(res[i])+m>=minBroad) return;
        }
        for(int i=0;i<n;i++){
            if(arr[i][1]==0){
                 Map<Integer,Integer> copy=new HashMap<>(map);
                 copy.put(arr[i][0],cur);
                arr[i][1]=1;
                res[cur]=arr[i][0];
                dfs(n,cur+1,res,arr,copy);
                arr[i][1]=0;
            }
        }
    }
    public static int distance(int node,Map<Integer,Integer> map,Map<Integer,List<Integer>> set){
        Integer pos1 = map.get(node);
        int maxDis=1;
        List<Integer> list = set.get(node);
        for (Integer neigh : list) {
            Integer pos2 = map.get(neigh);
            int abs = Math.abs(pos2 - pos1);
            maxDis=Math.max(maxDis,abs);
        }
        return maxDis;
    }
}
