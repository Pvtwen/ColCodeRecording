package dataStructure.GPLT;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/20 19:39
 */
public class L22 {
    static int[][] directions={{-1,-2},{1,-2},{-2,-1},{2,-1},{-1,2},{1,2},{-2,1},{2,1}};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
//        dp(n,1,1,x,y);
//        dp(n,1,n,x,y);
//        dp(n,n,1,x,y);
//        dp(n,n,n,x,y);
        bfs(n,x,y);
    }
    static int[] ret=new int[4];
    public static void bfs(int n,int stx,int sty){
        Deque<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{stx,sty,0});
        int[][] visited=new int[n+1][n+1];
        Arrays.fill(ret,-1);
        visited[stx][sty]=1;
        while(!queue.isEmpty()){
            int[] grid = queue.pollFirst();
            int x = grid[0];
            int y = grid[1];
            int step = grid[2];
            if(x==1 && y==1){
                ret[0]=step;
            }
            if(x==1 && y==n){
                ret[1]=step;
            }
            if(x==n && y==1){
                ret[2]=step;
            }
            if(x==n && y==n){
                ret[3]=step;
            }
            for (int[] d : directions) {
                int cx = d[0];
                int cy = d[1];
                if(condition(n,x+cx,y+cy) && visited[x+cx][y+cy]==0){
                    visited[x+cx][y+cy]=1;
                    queue.offer(new int[]{x+cx,y+cy,step+1});
                }
            }
        }
        for(int i=0;i<3;i++){
            System.out.println(ret[i]);
        }
        System.out.print(ret[3]);
    }
    public static void dp(int n,int endx,int endy,int stx,int sty){
        // f[i][j]:从i，j开始到终点至少还需要多少步
//        int[][] f=new int[n+1][n+1];
        Deque<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{endx,endy,0});
        int[][] visited=new int[n+1][n+1];
        visited[endx][endy]=1;
        while(!queue.isEmpty()){
            int[] grid = queue.pollFirst();
            int x = grid[0];
            int y = grid[1];
            int step = grid[2];
            if(x==stx && y==sty){
                if(stx==n && sty==n){
                    System.out.print(step);
                }else{
                    System.out.println(step);
                }
                return;
            }
            for (int[] d : directions) {
                int cx = d[0];
                int cy = d[1];
                if(condition(n,x+cx,y+cy) &&visited[x+cx][y+cy]==0 ){
                    visited[x+cx][y+cy]=1;
                    queue.offer(new int[]{x+cx,y+cy,step+1});
                }
            }
        }
    }
    public static boolean condition(int n,int x,int y){
        return x>=1 && x<=n && y>=1 && y<=n;
    }
}
