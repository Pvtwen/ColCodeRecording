package dataStructure;

/**
 * @author Yawen Cao
 * @data 2021/10/25 15:20
 */
public class Question240 {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int n=matrix.length;
//        int m=matrix[0].length;
//
//        int[][] visited=new int[n][m];
//        return dfs(0,0,target,visited,matrix);
//    }
//
//    public boolean dfs(int i,int j,int target,int[][] visited,int[][] matrix){
//        if(visited[i][j]==1) return false;
//        if(matrix[i][j]==target) return true;
//        visited[i][j]=1;
//        if(matrix[i][j]>target){
//            int[][] directions={{-1,0},{0,-1}};
//            for (int[] direction : directions) {
//                int x = direction[0];
//                int y = direction[1];
//                int changeX=x+i;
//                int changeY=y+j;
//                if(condition(changeX,changeY,matrix) && dfs(changeX,changeY,target,visited,matrix)) return true;
//            }
//        }else{
//            int[][] directions={{0,1},{1,0}};
//            for (int[] direction : directions) {
//                int x = direction[0];
//                int y = direction[1];
//                int changeX=x+i;
//                int changeY=y+j;
//                if(condition(changeX,changeY,matrix) && dfs(changeX,changeY,target,visited,matrix)) return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean condition(int i,int j,int[][] matrix){
//        int m = matrix.length;
//        int n = matrix[0].length;
//        return i>=0 && i<m && j>=0 && j<n;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        int i=0,j=m-1;
        while(i<n && j>=0){
            if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }else return true;
        }
        return false;
    }
}
