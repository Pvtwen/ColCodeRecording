package dataStructure.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yawen Cao
 * @data 2021/9/28 19:50
 */
public class Question695Review {
//    static int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
//    public static int maxAreaOfIsland(int[][] grid) {
//        int res=0;
//        int area=0;
//        Queue<int[]> queue=new LinkedList<>();
//
//        int n=grid.length;
//        int m=grid[0].length;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(grid[i][j]==1) {
//                    queue.offer(new int[]{i,j});
//                    grid[i][j]=0;
//                    while(!queue.isEmpty()){
//                        area++;
//                        int[] poll = queue.poll();
//                        int pollX=poll[0];
//                        int pollY=poll[1];
//                        for (int[] direction : directions) {
//                            int x=pollX+direction[0];
//                            int y=pollY+direction[1];
//                            if(condition(grid,x,y) && grid[x][y]==1) {
//                                // 防止[1,1][1,1]这种情况 grid[1][1]会入队列两次
//                                grid[x][y]=0;
//                                queue.offer(new int[]{x,y});
//                            }
//                        }
//                    }
//                    res=Math.max(res,area);
//                    area=0;
//                }
//            }
//        }
//        return res;
//    }
//
//    public static boolean condition(int[][] grid,int i,int j){
//        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
//    }

    int[][] directions={{0,1},{1,0}};
    class UnionFind{
        int[] parent;
        int[] rank;
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

        public int find(int i){
            if(i!=parent[i]) parent[i]=find(parent[i]);
            return parent[i];
        }

        public void union(int i,int j){
            int rootx = find(i);
            int rooty = find(j);
            if(rootx!=rooty){
                parent[rooty]=rootx;
                area[rootx]+=area[rooty];
            }
            ans=Math.max(ans,Math.max(area[rootx],area[rooty]));
        }
}
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        UnionFind uf=new UnionFind(grid);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    for (int[] direction : directions) {
                        int changeX=direction[0]+i;
                        int changeY=direction[1]+j;
                        if(condition(grid,changeX,changeY) && grid[changeX][changeY]==1){
                            uf.union(i*n+j,changeX*n+changeY);
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
