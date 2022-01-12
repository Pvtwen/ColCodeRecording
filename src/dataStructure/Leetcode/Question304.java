package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/9/22 19:55
 */
public class Question304 {
//    int n;
//    int m;
//    int sum;
//    int[][] arr;
//    public Question304(int[][] matrix) {
//        n=matrix.length;
//        m=matrix[0].length;
//        arr=new int[n][m+1];
//        for(int i=0;i<n;i++){
//            sum=0;
//            for(int j=1;j<m+1;j++){
//                sum+=matrix[i][j-1];
//                arr[i][j]=sum;
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum1=0;
//        for(int i=row1;i<=row2;i++){
//            sum1+=arr[i][col2+1]-arr[i][col1];
//        }
//        return sum1;
//    }

    int[][] sums;
    public Question304(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        sums=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sums[i+1][j+1]=sums[i][j+1]+sums[i+1][j]+matrix[i][j]-sums[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1]-sums[row1][col2+1]-sums[row2+1][col1]+sums[row1][col1];
    }
}
