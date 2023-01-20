package dataStructure.Leetcode.UVa;

import dataStructure.Test.S;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/19 11:04
 */
public class Uva1601 {
    public static int ID(int a,int b,int c){
        int ret=(a<<16)|(b<<8)|c;
        return ret;
    }
    public static boolean isConflict(int a,int b,int a1,int b1){
        return (a1==b1)||(a==b1 && b==a1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();
        while(w!=0 && h!=0 && n!=0){
            char[][] maze=new char[h][w];
            String s1 = sc.nextLine();
            for(int i=0;i<h;i++){
                s1=sc.nextLine();
                for(int j=0;j<w;j++){
                    maze[i][j]=s1.charAt(j);
                }
            }
            solution(maze,n);
            s=new int[maxN][maxN][maxN][2];
            st=new int[3];
            en=new int[3];

            w = sc.nextInt();
            h = sc.nextInt();
            n = sc.nextInt();
        }
    }
    static int maxN=150;
    static int[][][][] s=new int[maxN][maxN][maxN][2];
//    static int[][][] e=new int[maxN][maxN][maxN];
    // st en中存放的是对应空格的下标
    static int[] st=new int[3];
    static int[] en=new int[3];
    static int[] deg;
    static int[][] G;
    static int[][] direct={{-1,0},{1,0},{0,1},{0,-1},{0,0}};
    public static void solution(char[][] maze,int n){
        extractGraph(maze,n);
        Queue<Integer> start=new ArrayDeque<>();
        for (int[][][] ints : s) {
            for (int[][] anInt : ints) {
                for (int[] ints1 : anInt) {
                    Arrays.fill(ints1,-1);
                }
            }
        }
        start.offer(ID(st[0],st[1],st[2]));
        start.offer(ID(en[0],en[1],en[2]));
        s[st[0]][st[1]][st[2]][0]=0;
        s[en[0]][en[1]][en[2]][1]=0;
        // 0: 正向 1:负向
        int d=0;
        while(!start.isEmpty()){
            Integer p1 = start.poll();
            int a1=(p1>>16)&0xff;int b1=(p1>>8)&0xff;int c1=(p1)&0xff;
            if(s[a1][b1][c1][0]!=-1 && s[a1][b1][c1][1]!=-1) {
                System.out.println(s[a1][b1][c1][0]+s[a1][b1][c1][1]);
                return;
            }
            if(s[a1][b1][c1][0]!=-1) d=0;
            if(s[a1][b1][c1][1]!=-1) d=1;
            for(int i=0;i<deg[a1];i++){
                int i1 = G[a1][i];
                for(int j=0;j<deg[b1];j++){
                    int i2 = G[b1][j];
                    if(isConflict(a1,b1,i1,i2)) continue;
                    for(int k=0;k<deg[c1];k++){
                        int i3 = G[c1][k];
                        if(isConflict(a1,c1,i1,i3)) continue;
                        if(isConflict(b1,c1,i2,i3))continue;
                        if(s[i1][i2][i3][d]!=-1) continue;
                        s[i1][i2][i3][d]=s[a1][b1][c1][d]+1;
                        start.offer(ID(i1,i2,i3));
                    }
                }
            }
        }
    }
    public static void extractGraph(char[][] maze,int n){
        int m = maze.length;
        int n1 = maze[0].length;
        int[] x=new int[maxN];
        int[] y=new int[maxN];
        G=new int[maxN][5];
        int[][] id=new int[m][n1];
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n1;j++){
                if(maze[i][j]!='#'){
                    x[cnt]=i;y[cnt]=j;
                    id[i][j]=cnt;
                    if(Character.isLowerCase(maze[i][j])) st[maze[i][j]-'a']=cnt;
                    if(Character.isUpperCase(maze[i][j])) en[maze[i][j]-'A']=cnt;
                    cnt++;
                }
            }
        }
        deg=new int[maxN];
        for(int i=0;i<cnt;i++){
            int x1 = x[i];
            int y1 = y[i];
            deg[i]=0;
            for (int[] ints : direct) {
                int cx = x1 + ints[0];
                int cy = y1 + ints[1];
                if(maze[cx][cy]!='#'){
                    G[i][deg[i]++]=id[cx][cy];
                }
            }
        }
        if(n<=2){
            cnt++;deg[cnt]=1;G[cnt][0]=cnt;st[2]=en[2]=cnt++;
        }
        if(n<=1){
            cnt++;deg[cnt]=1;G[cnt][0]=cnt;st[1]=en[1]=cnt++;
        }
    }
//    public static void solution(char[][] maze,int n){
//        // 抽象成图
//        extractGraph(maze,n);
//        // bfs
//        for (int[][] ints : s) {
//            for (int[] anInt : ints) {
//                Arrays.fill(anInt,-1);
//            }
//        }
//        Queue<Integer> queue=new ArrayDeque<>();
//        queue.offer(ID(st[0],st[1],st[2]));
//        s[st[0]][st[1]][st[2]]=0;
//        while(!queue.isEmpty()){
//            Integer state = queue.poll();
//            // decode
//            int a=(state>>16)&0xff;
//            int b=(state>>8)&0xff;
//            int c=(state) & 0xff;
//            if(a==en[0] && b==en[1] && c==en[2]) {
//                System.out.println(s[a][b][c]);
//                return;
//            };
//            for(int i=0;i<deg[a];i++){
//                // a变化后的值
//                int i1 = G[a][i];
//                for(int j=0;j<deg[b];j++){
//                    int i2 = G[b][j];
//                    if(isConflict(a,b,i1,i2)) continue;
//                    for(int k=0;k<deg[c];k++){
//                        int i3 = G[c][k];
//                        if(isConflict(a,c,i1,i3)) continue;
//                        if(isConflict(b,c,i2,i3)) continue;
//                        if(s[i1][i2][i3]!=-1) continue;
//                        s[i1][i2][i3]=s[a][b][c]+1;
//                        queue.offer(ID(i1,i2,i3));
//                    }
//                }
//            }
//        }
////        System.out.println();
//    }
//    // true:冲突
//    public static boolean isConflict(int a,int b,int a1,int b1){
//        // 不能交换节点 或者 不能移到同一个block
//        return (a1==b && b1==a)||(a1==b1);
//    }
//    public static void extractGraph(char[][] maze,int n){
//        int m = maze.length;
//        int k = maze[0].length;
//        // 建立空格图
//        int[] x=new int[maxN];
//        int[] y=new int[maxN];
//        int[][] id=new int[m][k];
//        int cnt=0;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<k;j++){
//                if(maze[i][j]!='#'){
//                    x[cnt]=i;y[cnt]=j;id[i][j]=cnt;
//                    if(Character.isLowerCase(maze[i][j])) st[maze[i][j]-'a']=cnt;
//                    else if(Character.isUpperCase(maze[i][j])) en[maze[i][j]-'A']=cnt;
//                    cnt++;
//                }
//            }
//        }
//        deg=new int[cnt+10];
//        G=new int[cnt+10][5];
//        for(int i=0;i<cnt;i++){
//            deg[i]=0;
//            for (int[] ints : direct) {
//                int cx = ints[0]+x[i];
//                int cy = ints[1]+y[i];
//                if(maze[cx][cy]!='#'){
//                    G[i][deg[i]++]=id[cx][cy];
//                }
//            }
//        }
//        //这里创建fake node不用担心isconflict函数中可能会走到同一个节点 因为不存在cnt个空格 走不到cnt
//        if(n<=2){
//            deg[cnt]=1;G[cnt][0]=cnt;st[2]=en[2]=cnt++;
//        }
//        if(n<=1){
//            deg[cnt]=1;G[cnt][0]=cnt;st[1]=en[1]=cnt++;
//        }
//    }
}
