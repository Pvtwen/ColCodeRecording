package dataStructure.Leetcode.UVa;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/14 14:38
 */
public class Uva10603PriorityQueue {
    // 全局变量一定要更新
    static int[] ans=new int[201];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sample = sc.nextInt();
        while(sample>0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            solution(a,b,c,d);    
            sample--;
            ans=new int[201];
        }
    }
    public static void solution(int a,int b,int c,int d){
        int[] cap=new int[3];
        cap[0]=a;cap[1]=b;cap[2]=c;
        // 按水量 由小到大排序
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3]-o2[3];
            }
        });
        // 初始化初始状态
        int[] init={0,0,c,0};
        queue.offer(init);
        // 初始化为小于0的数
        Arrays.fill(ans,-1);

        // Dijtsra算法 定义两个变量 一个用来记录是否已经是最少水量能够到达的状态visited[a][b] 一个用来记录还没有记录的状态的当前的最低水量
        int[][] visited=new int[201][201];
        int[][] distance=new int[201][201];
        // 设置初始状态的水量为0 设置其他状态的水量为不可达
        for (int[] ints : distance) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }
        distance[0][0]=0;
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int a1 = state[0];
            int b1 = state[1];
            if(visited[a1][b1]==1) continue;
            visited[a1][b1]=1;
            updateAns(state);

            // i-》j倒水
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(i!=j){
                        // 获取到水量
                        int amount = Math.min(cap[j], state[i] + state[j]) - state[j];
                        // i和j倒了水之后的水量
                        int i1 = state[i] - amount;
                        int i2 = state[j] + amount;
                        int[] copy = Arrays.copyOf(state, 4);
                        copy[i]=i1;copy[j]=i2;
                        if(visited[copy[0]][copy[1]]==1) continue;
                        // 获取当前的水量
                        int i3 = state[3] + amount;
                        // 更新距离
                        if(i3<distance[copy[0]][copy[1]]){
                            distance[copy[0]][copy[1]]=i3;
                            copy[3]=i3;
                            queue.offer(copy);
                        }
                    }
                }
            }
        }
        // 到达最接近d目标水量的最小到水量ans[d]
        while(d>=0){
            if(ans[d]>=0){
                System.out.println(ans[d]+" "+d);
                return;
            }
            d--;
        }
    }
    public static void updateAns(int[] state){
        // 当前状态倒的水量
        int result = state[3];
        for(int i=0;i<3;i++){
            int vol = state[i];
            if(ans[vol]==-1 || ans[vol]>result) ans[vol]=result;
        }
    }
}