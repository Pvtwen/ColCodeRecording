package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/12/13 10:28
 */
public class Question807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] parel=new int[n];
        int[] vertical=new int[m];
        for (int i = 0; i < n; i++) {
            int max=grid[i][0];
            for (int j = 0; j < m; j++) {
                if(grid[i][j]>max) max=grid[i][j];
            }
            parel[i]=max;
        }

        for (int i = 0; i < m; i++) {
            int max=grid[0][i];
            for (int j = 0; j < n; j++) {
                if(grid[j][i]>max) max=grid[j][i];
            }
            vertical[i]=max;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int min = Math.min(parel[i], vertical[j]);
                sum+=grid[i][j]-min;
            }
        }
        return -sum;
    }
}
