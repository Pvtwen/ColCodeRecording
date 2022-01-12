package dataStructure.Leetcode.Match275;

/**
 * @author Yawen Cao
 * @data 2022/1/9 10:30
 */
public class Question5976 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // 先判断每一行
        for(int i=0;i<n;i++){
            int[] arr=new int[n+1];
            for(int j=0;j<n;j++){
                int val = matrix[i][j];
                if(arr[val]==0){
                    arr[val]=1;
                }else return false;
            }
        }
        // 判断每一列
        for(int i=0;i<n;i++){
            int[] arr=new int[n+1];
            for(int j=0;j<n;j++){
                int val = matrix[j][i];
                if(arr[val]==0){
                    arr[val]=1;
                }else return false;
            }
        }
        return true;
    }
}
