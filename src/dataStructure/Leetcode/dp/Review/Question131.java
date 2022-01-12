package dataStructure.Leetcode.dp.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/12/10 20:46
 */
public class Question131 {
    static List<List<String>> res = new ArrayList<>();
    static boolean[][] dp;
    public static List<List<String>> partition(String s) {
        int length = s.length();
        dp= new boolean[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=true;
        }
        for(int i=1;i<length;i++){
            for(int j=i-1;j>=0;j--){
                if(i-j<2) dp[j][i]=(s.charAt(i)==s.charAt(j));
                else dp[j][i]=(s.charAt(i)==s.charAt(j) && dp[j+1][i-1]);
            }
        }
        dfs(s, new ArrayList<String>(), 0);
        return res;
    }

    public static void dfs(String s, List<String> list,int start) {
        if(start==s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        char[] arr = s.toCharArray();
        for(int i=start;i<s.length();i++){
            if(!condition(arr,start,i)) continue;
            list.add(new String(arr,start,i-start+1));
            dfs(s, list, i + 1);
            list.remove(list.size()-1);
        }
    }
    public static boolean condition(char[] arr,int start,int end){
        return dp[start][end];
    }
}
