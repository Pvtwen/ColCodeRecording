package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/10/27 9:21
 */
public class Question240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++){
            int l=0,r=n;
            while(l<=r){
                int mid=(1+l+r)/2;
                if(matrix[i][mid]<target) l=mid+1;
                else if(matrix[i][mid]>target) r=mid;
                else return true;
            }
        }
        return false;
    }
}
