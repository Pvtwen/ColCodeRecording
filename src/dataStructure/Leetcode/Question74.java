package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/10/27 9:37
 */
public class Question74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

            int l=0,r=m*n-1;
            while(l<=r){
                int mid=(l+r)/2;
                // 行
                int row=(mid+1)/m;
                // 列   -1
                int col=(mid+1)%m;
                int val = matrix[row][col - 1];
                if(val>target) r=mid-1;
                else if(val<target) l=mid+1;
                else return true;
            }
            return false;
    }
}
