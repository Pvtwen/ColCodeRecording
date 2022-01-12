package dataStructure.Leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/11/12 19:06
 */
public class Question139 {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet<>(wordDict);
//        return dfs(s.toCharArray(),set,0);
//    }
//    public boolean dfs(char[] array, Set<String> set,int start){
//        if(start==array.length){
//            return true;
//        }
//        for(int i=start;i<array.length;i++){
//            if(!set.contains(new String(array,start,i-start+1))) continue;
//            if(dfs(array,set,i+1)) return true;
//        }
//        return false;
//    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        char[] arr = s.toCharArray();
        int length = s.length();
        Set<String> set=new HashSet<>(wordDict);
        set.add("");
        boolean[][] dp=new boolean[length][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<=i;j++){
                String s1 = new String(arr, 0, j + 1);
                String s2="";
                if(j<i){
                    s2=new String(arr,j+1,i-j);
                }
                boolean b=((dp[0][j]||set.contains(s1))&&set.contains(s2));
                if(b) {
                    dp[0][i]=true;
                    break;
                }
            }
        }
        return dp[0][length-1];
    }
}
