package dataStructure.luogu.MonthlyMatch1;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/21 16:05
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 值存放的是第几条边 0:不连通
        int[][] l=new int[n+1][n+1];
        int idx=1;
        int l1=0;
        int l2=0;
        while(idx<=m){
            int i = sc.nextInt();
            int i1 = sc.nextInt();
            if(idx==1){
               l1=i;
               l2=i1;
            }
            l[i][i1]=l[i1][i]=idx;
            idx++;
        }
        solution(l,n,m,l1,l2);
    }
    static int[] ans;
    public static void solution(int[][] l,int n,int m,int i1,int i2){
        ans=new int[m];
        Arrays.fill(ans,Integer.MAX_VALUE);
        int[] point=new int[n+1];
        int[] P=new int[m];
        point[i1]=point[i2]=1;
        P[0]=1;
        dfs(l,point,P,1);
        int base=ans[0]*1;
        for(int i=1;i<m;i++){
            base^=ans[i]*(i+1);
        }
        System.out.println(base);
    }
    // int[] point:已经删除的点 curPoint:删除了几个点 P:删除的边 curLine:删除了几个边
    public static void dfs(int[][] l,int[] point,int[] P,int curLine){
        if(curLine==P.length){
            // ans compare
            for(int i=0;i<P.length;i++){
                if(P[i]<ans[i]) {
                    ans=Arrays.copyOf(P,P.length);
                    return;
                }else if(P[i]>ans[i]) return;
            }
            return;
    }
        // 剪枝
        for(int i=0;i<curLine;i++){
            if(P[i]<ans[i]) break;
            if(P[i]>ans[i]) return;
        }
        // Meiju
        int tmepLine=curLine;
        for(int i=1;i<point.length;i++){
            // 如果已经删除
            if(point[i]==1) continue;
            // 连接的边
            PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for(int j=1;j<point.length;j++){
                if(l[i][j]!=0){
                    // 如果边的两个顶点都删除 删除边
                    if(point[j]==1){
                        int line = l[i][j];
                        queue.offer(line);
                    }
                }
            }
            // queue 遍历
            while(!queue.isEmpty()){
                Integer line = queue.poll();
                P[curLine]=line;
                curLine++;
            }
            point[i]=1;
            dfs(l,point,P,curLine);
            point[i]=0;
            curLine=tmepLine;
        }
    }
}
