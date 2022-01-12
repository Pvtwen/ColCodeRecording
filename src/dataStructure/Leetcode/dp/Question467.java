package dataStructure.Leetcode.dp;

import java.util.HashSet;

/**
 * @author Yawen Cao
 * @data 2021/12/11 15:08
 */
public class Question467 {
    public int findSubstringInWraproundString(String p) {
        int length = p.length();
        int[] dp = new int[27];
        char c2 = p.charAt(0);
        dp[c2]=1;
        int cnt=1;
        for(int i=1;i<length;i++){
            if(isContinuous(p.charAt(i-1),p.charAt(i))){
                cnt++;
            }else{
                cnt=1;
            }
            char c = p.charAt(i);
            dp[c]=Math.max(dp[c],cnt);
        }
        int ret=0;
        for(int i=0;i<=25;i++){
            ret+=dp[i];
        }
        return ret;
    }

    public boolean isContinuous(char a,char b){
        if(a=='z' && b=='a') return true;
        return b-a==1;
    }
//    public int findSubstringInWraproundString(String p) {
//        int ret=1;
//        int length = p.length();
//        int[] dp = new int[length];
//        HashSet<String> set = new HashSet<>();
//        char[] arr = p.toCharArray();
//        dp[0]=1;
//        set.add(""+p.charAt(0));
//        for(int i=1;i<length;i++){
//            char c = p.charAt(i);
//            char c1 = p.charAt(i - 1);
//            if(c=='a'){
//                if(c-c1==-25) dp[i]=dp[i-1]+1;
//                else dp[i]=1;
//            }else{
//                if(c-c1==1) dp[i]=dp[i-1]+1;
//                else dp[i]=1;
//            }
//            for(int j=i;j>=i-dp[i]+1;j--){
//                String s = new String(arr, j, i - j + 1);
//                if(!set.contains(s)) {
//                    ret++;
//                    set.add(s);
//                }
//            }
//        }
//        return ret;
//    }
}
