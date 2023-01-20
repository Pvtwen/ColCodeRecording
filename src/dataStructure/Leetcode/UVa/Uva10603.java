package dataStructure.Leetcode.UVa;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/13 14:58
 */
public class Uva10603 {
    static int sample;
    static int[][] visited=new int[201][201];
    static int[] ans=new int[201];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sample=sc.nextInt();
        while(sample>0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            solution(a,b,c,d);
            sample--;
            visited=new int[201][201];
            ans=new int[201];
        }
    }
    // 设置访问变量visited防止重复访问, 相当于大礼包bfs方法中的hashmap
    // 其中的一维的值代表容器a的水量,二维代表容器b的水量
    // 存储到达当前水量的所需要的最小水量
    public static void solution(int a,int b,int  c,int  d){
        // 设置初始状态(a,b,c的状态以及到达该状态的距离) 初始容量capA,capBCD.
        List<Integer> init=new ArrayList<>();
        init.add(0);init.add(0);init.add(c);init.add(0);
        int[] cap=new int[3];
        cap[0]=a;cap[1]=b;cap[2]=c;
        // 将水量由小到大排序
        PriorityQueue<List<Integer>> queue=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(3)-o2.get(3);
            }
        });
        queue.offer(init);
        // 初始化ans
        Arrays.fill(ans,-1);
//        ans[a]=0;ans[b]=0;ans[c]=0;
        //刚开始的时候a=0 b=0
        visited[0][0]=1;
        while(!queue.isEmpty()){
            List<Integer> state = queue.poll();
            updateAns(state);
            // 至关重要，只要找到了capD，立即退出，因为是优先队列结合dijtsra算法，如果不是dijtsra，此处还不能立即返回，因为还可能存在
            // 更小的水量，还需要继续寻找
            if(ans[d]>=0) break;
            // 更新访问变量
            int[] cur=new int[3];
            cur[0]=state.get(0);
            cur[1]=state.get(1);
            cur[2]=state.get(2);
//            Integer a1 = state.get(0);
//            Integer b1 = state.get(1);
//            visited[a1][b1]=1;

            // 倒水 i->j
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++) {
                    if(i!=j){
                        // 计算要倒入的水量
                        int amount = Math.min(cap[j], state.get(j) + state.get(i)) - state.get(j);
                        int[] copy = Arrays.copyOf(cur, 3);
                        // 倒入之后i的剩余  j的剩余 查看状态是否到达过
                        int remainI = state.get(i) - amount;
                        int remainJ = state.get(j) + amount;
                        copy[i]=remainI;
                        copy[j]=remainJ;
                        if(visited[copy[0]][copy[1]]==1) continue;
                        else{
                            visited[copy[0]][copy[1]]=1;
                            List<Integer> st=new ArrayList<>();
                            st.add(copy[0]);st.add(copy[1]);st.add(copy[2]);st.add(state.get(3)+amount);
                            queue.offer(st);
                        }
                    }
                }
            }
        }
        while(d>=0){
            if(ans[d]>=0){
                System.out.println(ans[d]+" "+d);
                return;
            }
            d--;
        }
    }
    public static void updateAns(List<Integer> state){
        Integer minStep = state.get(3);
        // 将当前的状态和之前的ans中的比较 如果当前较小 则更新之
        for(int i=0;i<3;i++){
            Integer sta = state.get(i);
            if(ans[sta]<0 || ans[sta]>minStep) ans[sta]=minStep;
        }
    }
}
