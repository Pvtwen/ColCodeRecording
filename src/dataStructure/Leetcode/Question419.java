package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/11/6 14:59
 */
public class Question419 {
//    static int res=0;
//    static char[][] board;
//    static int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
//    static int[][] visited;
//    public static  int countBattleships(char[][] board1) {
//        board=board1;
//        int n=board.length;
//        int m=board[0].length;
//        visited=new int[n][m];
//        dfs(0,0,'.',null);
//
//        return res;
//    }
//    public static void dfs(int x,int y,char from,int[] direct){
//        if(visited[x][y]==1) return ;
//        visited[x][y]=1;
//        if(board[x][y]=='X'){
//            if(from=='.') {
//                res++;
//                if(x+1<board.length && board[x+1][y]=='X') direct=new int[]{1,0};
//                else if(y+1<board[0].length && board[x][y+1]=='X') direct=new int[]{0,1};
//                else if(x-1>=0 && board[x-1][y]=='X') direct=new int[]{-1,0};
//                else if(y-1 >=0 && board[x][y-1]=='X') direct=new int[]{0,-1};
//                else direct=null;
//            }
//            if(direct!=null && condition(board,x+direct[0],y+direct[1])) dfs(x+direct[0],y+direct[1],'X',direct);
//        }
//        for (int[] direction : directions) {
//            int i = direction[0]+x;
//            int j = direction[1] + y;
//            if(condition(board,i,j)){
//                dfs(i,j,board[x][y],direct);
//            }
//        }
//    }
//    public static boolean condition(char[][] board,int i,int j){
//        return i>=0 && i<board.length && j>=0 && j<board[0].length;
//    }

//    public int countBattleships(char[][] board) {
//        int n=board.length;
//        int m=board[0].length;
//
//        int res=0;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(board[i][j]=='X'){
//                    if(i==0 && j==0) res++;
//                    else if(j==0 && board[i-1][j]!='X') res++;
//                    else if(i==0 && board[i][j-1]!='X') res++;
//                    else if(i-1>=0 && j-1>=0 && board[i-1][j]!='X' && board[i][j-1]!='X') res++;
//                }
//            }
//        }
//        return res;
//    }
    int[][] id;
    int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};

    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        id=new int[n][m];
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // 如果是战舰 且没有被编号 则dfs
                if(id[i][j]==0 && board[i][j]=='X') dfs(board,i,j,++idx);
            }
        }
        return idx;
    }

    public void dfs(char[][]board,int i,int j,int idx){
        // 如果被编号 回溯
        if(id[i][j]>0) return;
        // 如果是'.' 回溯
        if(board[i][j]!='X') return;
        id[i][j]=idx;
        // 遍历四个方向
        for (int[] direction : directions) {
            int x = direction[0] + i;
            int y = direction[1] + j;
            if(condition(board,x,y)){
                dfs(board,x,y,idx);
            }
        }
    }
    public  boolean condition(char[][] board,int i,int j){
        return i>=0 && i<board.length && j>=0 && j<board[0].length;
    }
}
