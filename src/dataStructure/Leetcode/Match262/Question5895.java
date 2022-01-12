package dataStructure.Leetcode.Match262;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/10/10 11:01
 */
public class Question5895 {
    public static int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;

        int[] gridX=new int[m*n];

        //
        int t=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                gridX[t]=grid[i][j];
                t++;
            }
        }

        // 同余定理将时间复杂度降一个指数  之前直接暴力判断然后超时了
        int y=gridX[0]%x;
        for(int i=0;i<t;i++){
            if(y!=gridX[i]%x) return -1;
        }

        Arrays.sort(gridX);

        // 前缀和
        int sum=0;
        int[] prefixSum=new int[m*n+1];
        for(int i=1;i<m*n+1;i++){
            sum+=gridX[i-1];
            prefixSum[i]=sum;
        }

        //
        int res=Integer.MAX_VALUE;
        for(int i=1;i<m*n+1;i++){
            // i后面的数字操作步数
            // 比如数字 1 2 3 4  基数为1    2 3 4与1的距离就是 (2-1)+(3-1)+(4-1)  也就是 2+3+4-1*3  如果是 1 2 3 4 5 那就是 2+3+4+5-1*4 以此类推
            int i1 = prefixSum[m * n] - prefixSum[i] - gridX[i-1] * (m * n - i);
            // i前面的数字的操作步数
            int i2 = Math.abs(prefixSum[i - 1] - gridX[i-1] * (i - 1));
            int r=(i1+i2)/x;
            res=Math.min(res,r);
        }
        return res;
    }
}
