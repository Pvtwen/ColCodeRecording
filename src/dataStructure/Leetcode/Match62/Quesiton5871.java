package dataStructure.Leetcode.Match62;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/10/2 22:45
 */
public class Quesiton5871 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length!=(m*n)) return new int[][]{};
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            res[i]= Arrays.copyOfRange(original,i*n,(i+1)*n);
        }
        return res;
    }
}
