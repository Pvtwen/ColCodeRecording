package dataStructure.Leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/8 11:54
 */
public class Question22 {
    public List<String> generateParenthesis(int n) {
        // 一维动态规划 且依赖于之前的m,k 不能转化为0维
        ArrayList<String>[] dp=new ArrayList[n+1];

        for(int i=0;i<n+1;i++){
            dp[i]=new ArrayList<>();
        }
        dp[0].add("");
        for(int i=0;i<=n;i++){
            for(int m=0;m<i;m++){
                int k=i-1-m;
                ArrayList<String> ListM= dp[m];
                ArrayList<String> ListK=dp[k];
                for (java.lang.String s : ListM) {
                    for (java.lang.String s1 : ListK) {
                        String str="";
                        // 状态转移方程
                        str+="("+s+")"+s1;
                        dp[i].add(str);
                    }
                }
            }
        }
        return dp[n];
    }
}
