package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2022/1/3 10:14
 */
public class Question678 {
    // f[i][j]: 前i个字符  能否与j个右括号形成合法括号序列
    public boolean checkValidString(String s) {
        int length = s.length();
        boolean[][] dp=new boolean[length+1][length+1];
        dp[0][0]=true;
        for(int i=1;i<=length;i++){
            char c = s.charAt(i - 1);
            for(int j=0;j<=i;j++){
                if(c=='('){
                    if(j-1>=0) dp[i][j]=dp[i-1][j-1];
                }else if(c==')') {
                    if(j+1<=i) dp[i][j]=dp[i-1][j+1];
                }else {
                    dp[i][j]=dp[i-1][j];
                    if(j-1>=0) dp[i][j]|=dp[i-1][j-1];
                    if(j+1<=i) dp[i][j]|=dp[i-1][j+1];
                }
            }
        }
        return dp[length][0];
    }
//    public boolean checkValidString(String s) {
//        return dfs(s,0,0);
//    }
//    public boolean dfs(String s,int left,int idx){
//        if(left<0) return false;
//        if(idx==s.length()){
//            if(left==0) return true;
//            else return false;
//        }
//        char c = s.charAt(idx);
//        if(c=='*'){
//            // *变为(
//            boolean dfs = dfs(s, left + 1, idx + 1);
//            if(dfs) return true;
//            // *变为)
//            boolean dfs1 = dfs(s, left - 1, idx + 1);
//            if(dfs1) return true;
//            //  *为空字符
//            boolean dfs2 = dfs(s, left, idx + 1);
//            if(dfs2) return true;
//        }else if(c=='(') {
//            boolean dfs = dfs(s, left + 1, idx + 1);
//            if(dfs) return true;
//        }else if(c==')'){
//            boolean dfs = dfs(s, left - 1, idx + 1);
//            if(dfs) return true;
//        }
//        return false;
//    }
}
