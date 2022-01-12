package dataStructure.Leetcode.dp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/12 9:07
 */
public class Question131 {
//    public static List<List<String>> partition(String s) {
//        dfs(s,1,""+s.charAt(0),new ArrayList<>());
//        return res;
//    }
//    public static void dfs(String s,int idx,String str,List<String> list){
//        ArrayList<String> copy = new ArrayList<>(list);
//        ArrayList<String> copy1 = new ArrayList<>(list);
//        if(idx==s.length()-1){
//            boolean b = isHuiwen(str);
//            boolean b1 = isHuiwen(str + s.charAt(idx));
//            if(b){
//                //1
//                copy.add(str);copy.add(""+s.charAt(idx));
//                res.add(copy);
//            }
//            if(b1){
//                copy1.add(str+s.charAt(idx));
//                res.add(copy1);
//            }
//            return;
//        }
//        boolean b = isHuiwen(str);
//        // "efe"  ef
//        if(!b){
//            dfs(s,idx+1,str+s.charAt(idx),list);
//        }else{
//            // 不与之前配对
//            copy.add(str);
//            dfs(s,idx+1,""+s.charAt(idx),copy);
//            // 与之前的配对
//            dfs(s,idx+1,str+s.charAt(idx),list);
//        }
//    }
    List<List<String>> res=new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int length = s.length();
        dp=new boolean[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<length;i++){
            for(int j=i-1;j>=0;j--){
                char c = s.charAt(i);
                char c1 = s.charAt(j);
                if(i-j==1){
                    dp[j][i]=(c==c1);
                }else{
                    dp[j][i]=(dp[j+1][i-1]&&c==c1);
                }
            }
        }
        Deque<String> queue=new ArrayDeque<>();
        dfs(s.toCharArray(),0,queue);
        return res;
    }
    public void dfs(char[] array, int start, Deque<String> queue){
        if(start==array.length){
            ArrayList<String> list = new ArrayList<>(queue);
            res.add(list);
        }
        for(int i=start;i<array.length;i++){
//            if(!isHuiwen(new String(array,start,i-start+1))){
//                continue;
//            }
            if(!dp[start][i]){
                continue;
            }
            queue.offer(new String(array,start,i-start+1));
            dfs(array,i+1,queue);
            queue.removeLast();
        }
    }

//    public static boolean isHuiwen(String s){
//        StringBuilder stringBuilder=new StringBuilder(s);
//        StringBuilder reverse = stringBuilder.reverse();
//        String string = reverse.toString();
//        return s.equals(string);
//    }
}
