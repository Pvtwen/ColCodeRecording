package dataStructure.GPLT;

import java.lang.instrument.ClassDefinition;
import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/3/20 18:42
 */
public class L21 {
    static int color=1;
    static class UnionFind{
        int[] parents;
        public UnionFind(){};
        public UnionFind(int num){
            parents=new int[num+1];
            for(int i=1;i<=num;i++){
                parents[i]=i;
            }
        }
        public int find(int x){
            if(parents[x]!=x) parents[x]=find(parents[x]);
            return parents[x];
        }
    }
    public static void solution3(int[][] arr,int num){
        UnionFind uf=new UnionFind(num);
        int[] parents = uf.parents;
        for(int i=0;i<arr.length;i++){
            int i1=arr[i][0];
            int i2 = arr[i][1];
            if(parents[i1]==i1){
                parents[uf.find(i2)]=parents[uf.find(i1)];
            }else if(parents[i2]==i2){
                parents[uf.find(i1)]=parents[uf.find(i2)];
            }else parents[uf.find(i1)]=parents[uf.find(i2)];
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=num;i++){
            int p = uf.find(i);
            set.add(p);
        }
        System.out.println(set.size());
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=num;i++){
            int i1 = uf.find(i);
            map.put(i1,map.getOrDefault(i1, 0)+1);
        }
        int[] ret=new int[set.size()];
        int  idx=0;
        for (Integer v : map.values()) {
            ret[idx]=v;
            idx++;
        }
        Arrays.sort(ret);
        for(int i=ret.length-1;i>0;i--){
            System.out.print(ret[i]+" ");
        }
        System.out.print(ret[0]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        int inf = sc.nextInt();
        int[][] arr=new int[inf][2];
        int idx=0;
        while(idx<inf){
            arr[idx][0]=sc.nextInt();
            arr[idx][1]=sc.nextInt();
            idx++;
        }
        solution3(arr,num);
    }
    public static void solution1(int[][] arr,int  num){
        ArrayList<Integer>[] lists=new ArrayList[num+1];
        for(int  i=1;i<=num;i++){
            lists[i]=new ArrayList<>();
        }
        for(int  i=0;i<arr.length;i++){
            int i1 = arr[i][0];
            int i2 = arr[i][1];
            lists[i1].add(i2);
            lists[i2].add(i1);
        }
        int[] col=new int[num+1];
        Deque<Integer> queue=new ArrayDeque<>();
        for(int i=1;i<=num;i++){
            if(col[i]==0){
                col[i]=color;
                color++;
                queue.offer(i);
                while(!queue.isEmpty()){
                    Integer cur = queue.pollFirst();
                    int i1 = col[cur];
                    for (Integer nei : lists[cur]) {
                        if(col[nei]==0){
                            col[nei]=i1;
                            queue.offer(nei);
                        }
                    }
                }
            }
        }
        int[] sort=new int[color-1];
        for(int i=1;i<=num;i++){
            // 第i只蜥蜴的颜色
            int i1 = col[i];
            sort[i1-1]++;
        }
        System.out.println(sort.length);
        Arrays.sort(sort);
        for(int i=sort.length-1;i>0;i--){
            System.out.print(sort[i]+" ");
        }
        System.out.print(sort[0]);
    }
    public static  void solution(int[][] arr,int num){
        ArrayList<Integer>[] lists=new ArrayList[num+1];
        for(int  i=1;i<=num;i++){
            lists[i]=new ArrayList<>();
        }
        for(int  i=0;i<arr.length;i++){
            int i1 = arr[i][0];
            int i2 = arr[i][1];
            lists[i1].add(i2);
            lists[i2].add(i1);
        }
        // 每只蜥蜴的颜色 如果为零代表没有上色
        int[] col=new int[num+1];
        for(int i=1;i<=num;i++){
            if(col[i]==0) {
                col[i]=color;
                dfs(lists,col,color,i);
                color++;
            }
        }
        // 找没有上色的
        for(int i=1;i<=num;i++){
            if(col[i]==0) {
                col[i]=color;
                color++;
            }
        }
        // 记录每个颜色的蜥蜴的个数
        int[] sort=new int[color-1];
        for(int i=1;i<=num;i++){
            // 第i只蜥蜴的颜色
            int i1 = col[i];
            sort[i1-1]++;
        }
        System.out.println(sort.length);
        Arrays.sort(sort);
        for(int i=sort.length-1;i>0;i--){
            System.out.print(sort[i]+" ");
        }
        System.out.print(sort[0]);
    }
    public static void dfs(ArrayList<Integer>[] lists,int[] col,int curCol,int  cur){
        int size = lists[cur].size();
        if(size==0) return;
        for (Integer nei : lists[cur]) {
            if(col[nei]==0) {
                col[nei]=curCol;
                dfs(lists,col,curCol,nei);
            }
        }
    }
}