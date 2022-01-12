package dataStructure.Leetcode.Match;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/8/29 11:33
 */
public class Question5856 {
    public static int minSessions(int[] tasks, int sessionTime) {
        int n=tasks.length,m=1<<n;
        final int INF=20;
        int[] dp=new int[m];
        Arrays.fill(dp,INF);

        //预处理每个状态  能一次做完的状态dp设置为1
        for(int i=1;i<m;i++){
            int state=i,idx=n-1;
            int spend=0;
            while(state>0){
                //二进制的第一位数是否为1
                int bit=state&1;
                if(bit==1){
                    spend+=tasks[idx];
                }
                state>>=1;
                idx--;
            }
            if(spend<=sessionTime){
                dp[i]=1;
            }
        }
        //对每个状态遍历其子集 如果能一遍做完 跳过 不能的 则找到他的最优解
        for(int i=1;i<m;i++){
            if(dp[i]==1){
                continue;
            }
            //如果该状态不能在一个sessionTime内做完 则遍历其子集
            // 最小的做完次数由子集和子集的补集决定
            for(int j=i;j>0;j=(j-1)&i){
                dp[i]=Math.min(dp[i],dp[j]+dp[j^i]);
            }
        }
        //返回1111状态的完成次数
        return dp[m-1];
    }
}
