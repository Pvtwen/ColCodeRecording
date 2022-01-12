package dataStructure.Leetcode.LUCCUP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2021/9/25 15:50
 */
public class Quesiton2 {
    int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    int index=0;
    int[][] res;
    int v=1;
    int initialX;
    int initialY;
    boolean[][][] visited;

    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        int n=terrain.length;
        int m=terrain[0].length;

        visited=new boolean[n][m][102];
        res=new int[n*m][2];

        initialX=position[0];
        initialY=position[1];

        dfs(1,initialX,initialY,terrain,obstacle);

        res = Arrays.copyOf(res, index);
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]) return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });
        return res;
    }

    public  void dfs(int v,int i,int j,int[][] terrain,int[][]obstacle){
        if(v>101 || v<=0 || visited[i][j][v]) return;
        int n=terrain.length;
        int m=terrain[0].length;

        visited[i][j][v]=true;

        if(v==1) {
            if(!(i==initialX && j==initialY)){
                res[index][0]=i;
                res[index][1]=j;
                index++;
            }
        }

        for (int[] direction : directions) {
            int x=i+direction[0];
            int y=j+direction[1];
            if(condition(x,y,n,m)){
                dfs(v+terrain[i][j]-terrain[x][y]-obstacle[x][y],x,y,terrain, obstacle);
            }}
    }

    public boolean condition(int i,int j,int n,int m){
        return i<n && i>=0 && j<m && j>=0;
    }
}
