package dataStructure.Leetcode;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/9/14 16:30
 */
public class Question2002 {
    public static int maxProduct(String s) {
        int max= 1<<s.length();
        int[] dp=new int[max];
        int res=0;
        // 用来记录dp数组当前的位置
        int t=0;
        // 枚举所有值  看是否是回文  如果是回文字符串  将其加入dp数组
        for(int i=1;i<max;i++){
            int start=i;
            int p;
            int index=s.length()-1;
            StringBuilder string=new StringBuilder();
            while(start>0){
                p=start&1;
                // 逐步右移 如果为 1 加入stringbuilder

                if(p==1) string.append(s.charAt(index));
                start>>=1;
                index--;
            }
            String string1 = string.toString();
            String string2 = string.reverse().toString();
            if(string1.equals(string2)) {
                // 此处dp不应该存回文字符串的长度  应该存取该二进制序列值  以便后面判断两个序列是否相交
                dp[t]=i;
                t++;
            }
        }
        // 遍历所有的dp 找到最大相乘的dp
        for(int i=0;i<t;i++){
            for(int j=i+1;j<t;j++){
                // 判断是否相交
                if((dp[i]&dp[j])==0){
                    int count1 = count(dp[i]);
                    int count2 = count(dp[j]);
                    res=Math.max(res,count1*count2);
                }
            }
        }

        return res;
    }

    public static int count(int t){
        int res=0;
        while(t>0){
            int p=t&1;
            if(p==1) res++;
            t>>=1;
        }
        return res;
    }
}
