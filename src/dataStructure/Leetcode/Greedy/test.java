package dataStructure.Leetcode.Greedy;

import java.util.Scanner;
public class test {
    static int m,n;
    static int [][] grid;
    static int [][] dp;
    static int [][] paths;
    static int getPath(int i,int j){
        if(j == n)
            return 0;
        else if(dp[i][j] != 0){
            return dp[i][j];
        }else{
            int down = (i+1) %m;
            int beside = i;
            int up = (i + m -1) %m;
            int min,index,check;
            min = getPath(down,j+1);
            index = down;
            check = getPath(beside, j+1);
            if(check < min || (check == min && beside < index)){
//              System.out.println("beside" + min + " " + check);
                min = check;
                index = beside;
            }
            check = getPath(up, j+1);
            if(check < min || (check == min && up < index)){
                min = check;
                index = up;
            }
            paths[i][j] = index;
            return dp[i][j] = grid[i][j] + min;
        }

    }
    public static void main(String[] args) throws Exception {
        Scanner in  = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int min,start,check;
        while(in.hasNext()){
            m = in.nextInt();
            n = in.nextInt();
            grid = new int [m][n];
            dp = new int [m][n];
            paths = new int [m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = in.nextInt();
                }
            }
            min = getPath(0, 0);
            start = 0 ;
            for (int i = 1; i < m; i++) {
                check = getPath(i, 0);
                if(check < min){
                    min = check;
                    start = i;
                }
            }
            for (int i = 0; i < n; i++) {
                out.append(start+1);
                start = paths[start][i];
                if(i < n-1)
                    out.append(" ");
            }
            out.append("\n");
            out.append(min+"\n");
        }
        System.out.print(out);
    }
}