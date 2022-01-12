package dataStructure.Leetcode.dp;

import java.util.HashSet;

/**
 * @author Yawen Cao
 * @data 2021/12/31 10:13
 */
public class Question647 {
    HashSet<String> set=new HashSet<>();
    int ans=0;
    boolean[][] dp;
    public int countSubstrings(String s) {
        int length = s.length();
        dp=new boolean[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=true;
            ans++;
        }
        for(int i=1;i<length;i++){
            for(int j=i-1;j>=0;j--){
                if(i-j==1) dp[j][i]=(s.charAt(j)==s.charAt(i));
                else{
                    dp[j][i]=(s.charAt(j)==s.charAt(i))&&dp[j+1][i-1];
                }
                if(dp[j][i]) ans++;
            }
        }

//        dfs(s,0);
        return ans;
    }
    public void dfs(String s,int start){
        if(start==s.length()) return;
        char[] arr = s.toCharArray();
        // 构造字符串
        String rem=start+""+new String(arr,start,s.length()-start);
        if(set.contains(rem)) return;
        if(dp[start][s.length()-1]){
            set.add(rem);
            ans++;
        }
        for(int i=start;i<s.length();i++){
            // 构造字符串
            rem=start+""+new String(arr,start,i-start+1);
            if(set.contains(rem)){
                return;
            }
            if(dp[start][i]){
                ans++;
                set.add(rem);
            };
            dfs(s,i+1);
        }
    }
}
