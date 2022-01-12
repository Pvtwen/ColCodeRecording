package dataStructure.Leetcode.Match260;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/9/26 11:52
 * 反思点：
 * 1. 不要以为机器A拿到了最大值，就可以限制B拿到最大值
 * 2. 数据格式限制 long型
 * 3. 在遍历过程中，每次遍历求出B两条路的最大值，最后再将res与该最大值进行比较，res取其中的最小值。
 * 而不是res=Math.max(max,res);
 */
public class Question5882 {
//    static int[][] directions=new int[][]{{0,1},{1,0}};
//    // 记录最大值路径
//    static  int[][] step;
//    static  int index=0;
//    static int index1=0;
//    static  int sum=0;
//    static  int[] s;
//    static int[] s1;
//
//    public static long gridGame(int[][] grid) {
//        int res=Integer.MIN_VALUE;
//
//        int n=grid[0].length;
//        int[] walk=new int[n];
//        int t=0;
//
//        s=new int[n];
//        s1=new int[n];
//        int[] maxIndex=new int[n];
//        int max=Integer.MIN_VALUE;
//        int max1=Integer.MIN_VALUE;
//
//        step=new int[n][n];
//        dfs(grid,0,0,0,walk,0);
//
//        for(int i=0;i<n;i++){
//            if(s[i]>max) max=s[i];
//        }
//
//        for(int i=0;i<n;i++){
//            if(s[i]==max) {
//                maxIndex[t]=i;
//                t++;
//            }
//        }
//
//        for(int i=0;i<t;i++){
//            int index=maxIndex[i];
//            int x=0,y=0;
//            int[][] copy = Arrays.copyOf(grid, 2);
//            copy[0][0]=0;
//            for (int direction : step[index]) {
//                if(direction==1) copy[x][++y]=0;
//                else copy[++x][y]=0;
//            }
//            dfs(copy, 0, 0, 0);
//            for(int j=0;j<n;j++){
//                if(s1[j]>max1) max1=s1[j];
//            }
//            res=Math.min(res,max1);
//        }
//        return res;
//    }
//    // 向右为1  向下为0
//    public static  void dfs(int[][] grid,int sum,int i,int j,int[] walk,int depth){
//        sum+=grid[i][j];
//        if(i==1 && j==grid[0].length-1) {
//            s[index]=sum;
//            step[index]=Arrays.copyOf(walk,walk.length);
//            index++;
//            return ;
//        }
//
//        for (int[] direction : directions) {
//            int x=direction[0]+i;
//            int y=direction[1]+j;
//            if(condition(grid,x,y)) {
//                if(direction[0]==0) walk[depth]=1; //向右移动
//                else walk[depth]=0; // 向下移动
//                dfs(grid,sum,x,y,walk,depth+1);
//            }
//        }
//    }
//
//    public static void dfs(int[][] grid,int sum,int i,int j){
//        sum+=grid[i][j];
//        if(i==1 && j==grid[0].length-1) {
//            s1[index1]=sum;
//            index1++;
//        }
//        for (int[] direction : directions) {
//            int x=direction[0]+i;
//            int y=direction[1]+j;
//            if(condition(grid,x,y)){
//                dfs(grid,sum,x,y);
//            }
//        }
//    }
//
//    public static boolean condition(int[][] grid,int i,int j){
//        return i>=0 && i<=1 && j>=0 && j<grid[0].length;
//    }
    public static long gridGame(int[][] grid) {
        int n=grid[0].length;
        long[] prefixArr1=new long[n+1];
        long[] prefixArr2=new long[n+1];
        long res=Long.MAX_VALUE;
        long sum=0;
        long sum1=0;
        for(int i=1;i<n+1;i++){
            sum+=grid[0][i-1];
            sum1+=grid[1][i-1];
            prefixArr1[i]=sum;
            prefixArr2[i]=sum1;
        }

        for(int i=1;i<n+1;i++){
            long sub1=prefixArr1[n]-prefixArr1[i];
            long sub2=prefixArr2[i-1];
            long max=Math.max(sub1,sub2);
            res=Math.min(max,res);
        }
        return res;
    }
}
