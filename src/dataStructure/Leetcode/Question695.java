package dataStructure.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 86153
 * @data 2021/8/17 10:57
 */
public class Question695 {
//    static final int[][] directions={{0,1},{1,0}};
//    static int maxNum=0;
//    public static int maxAreaOfIsland(int[][] grid) {
//        //行
//        int m=grid.length;
//        int n=grid[0].length;
//        int num=0;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j]==1){
//                    num = dfs(grid, i, j, num);
//                    //搜索完毕之后  最大值
//                    maxNum= Math.max(num, maxNum);
//                }
//            }
//        }
//        return maxNum;
//    }
//    public static int dfs(int[][] grid,int i,int j,int num){
//        if(grid[i][j]==0){
//            return num;
//        }
//        num++;
////        grid[i][j]=0;
//        for (int[] direction : directions) {
//            int changeX=direction[0]+i;
//            int changeY=direction[1]+j;
//            if(condition(grid,changeX,changeY))
//                num=dfs(grid,changeX,changeY,num);
//        }
//        return num;
//    }
//    public static boolean condition(int[][] grid,int x,int y){
//        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
//    }

//    static int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
//    public int maxAreaOfIsland(int[][] grid) {
//        int maxNum=0;
//        int num=0;
//        Queue<int[]> queue=new LinkedList<>();
//        //行
//        int m=grid.length;
//        int n=grid[0].length;
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j]==1){
//                    queue.offer(new int[]{i,j});
//                    grid[i][j]=0;
//                    while(!queue.isEmpty()){
//                        int[] poll = queue.poll();
//                        num++;
//                        int x=poll[0];
//                        int y=poll[1];
//                        for (int[] direction : directions) {
//                            int changeX=direction[0]+x;
//                            int changeY=direction[1]+y;
//                            if(condition(grid,changeX,changeY)){
//                                if(grid[changeX][changeY]==1){
//                                    queue.offer(new int[]{changeX,changeY});
//                                    grid[changeX][changeY]=0;
//                                }
//                            }
//                        }
//                    }
//                }
//                maxNum=Math.max(num,maxNum);
//                num=0;
//            }
//        }
//        return maxNum;
//    }
//    public boolean condition(int[][] grid,int i,int j){
//        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
//    }

    //并查集
    static int[][] directions={{0,1},{1,0}};
    static class UnionFind{
        int[] rank;
        int[] parent;
        int[] area;
        int ans=0;

        public UnionFind(int[][] grid){
            int m=grid.length;
            int n=grid[0].length;
            rank=new int[m*n];
            parent=new int[m*n];
            area=new int[m*n];

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        rank[i*n+j]=1;
                        parent[i*n+j]=i*n+j;
                        area[i*n+j]=1;
                        ans=1;
                    }
                }
            }
        }

        //路径优化
        public int find(int i){
            if(i!=parent[i]) parent[i]=find(parent[i]);
            return parent[i];
        }

        // Union
        public void Union(int i,int j){
            int rootx = find(i);
            int rooty = find(j);
            if(rootx!=rooty){
                if(rank[rootx]>rank[rooty]){
                    parent[rooty]=rootx;
                    area[rootx]+=area[rooty];
                }else if(rank[rootx]<rank[rooty]){
                    parent[rootx]=rooty;
                    area[rooty]+=area[rootx];
                }else{
                    parent[rooty]=rootx;
                    area[rootx]+=area[rooty];
                    rank[rootx]++;
                }
            }
            ans=Math.max(ans,Math.max(area[rootx],area[rooty]));
        }
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        UnionFind uf=new UnionFind(grid);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    for (int[] direction : directions) {
                        int changeX=direction[0]+i;
                        int changeY=direction[1]+j;
                        if(condition(grid,changeX,changeY) && grid[changeX][changeY]==1){
                            uf.Union(i*n+j,changeX*n+changeY);
                        }
                    }
                }
            }
        }
        return uf.ans;
    }
    public static boolean condition(int[][] grid,int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}
