package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/12/9 10:52
 */
public class Question794 {
    public static boolean validTicTacToe(String[] board) {
        String row1=board[0];
        String row2=board[1];
        String row3=board[2];
        String col1=""+board[0].charAt(0)+board[1].charAt(0)+board[2].charAt(0);
        String col2=""+board[0].charAt(1)+board[1].charAt(1)+board[2].charAt(1);
        String col3=""+board[0].charAt(2)+board[1].charAt(2)+board[2].charAt(2);
        String angle1=""+board[0].charAt(0)+board[1].charAt(1)+board[2].charAt(2);
        String angle2=""+board[0].charAt(2)+board[1].charAt(1)+board[2].charAt(0);
        String[] arr=new String[8];
        arr[0] = row1;arr[1]=row2;arr[2]=row3;arr[3]=col1;arr[4]=col2;arr[5]=col3;arr[6]=angle1;arr[7]=angle2;
        int countX=0,countO=0;
        for (String s : board) {
            char c = s.charAt(0);
            char c1 = s.charAt(1);
            char c2 = s.charAt(2);
            if(c=='O') countO++;
            else if(c=='X') countX++;
            if(c1=='O') countO++;
            else if(c1=='X') countX++;
            if(c2=='O') countO++;
            else if(c2=='X') countX++;
        }
        if(countO>countX) return false;
        if(countX-countO>=2 || countO-countX>=2) return false;
        if(countX+countO<=5) return true;
        int x=0,o=0;
        if(countX+countO>=6 && countX+countO<=8){
            for (String s : arr) {
                if(s.equals("XXX")) x++;
                if(s.equals("OOO")) o++;
            }
            if((countX+countO)%2==0 && x==1) return false;
            else return true;
        }else{
            for (String s : arr) {
                if(s.equals("XXX")) x++;
                if(s.equals("OOO")) o++;
            }
            if(o==1) return false;
            if((condition(row1)&&condition(row3))||(condition(col1)&&condition(col3))) return false;
            else return true;
        }
    }
    public static boolean condition(String s){
        return s.equals("XXX")||s.equals("OOO");
    }
}
