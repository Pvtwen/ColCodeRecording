package dataStructure.Leetcode;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/9/8 20:32
 */
public class Question1986 {
    public int minSessions(int[] tasks,int sessionTime){
        int len=tasks.length;
        int m=1<<len;
        int[] dp=new int[m-1];

        int state,p;
        Arrays.fill(dp,20);

        for(int i=1;i<m;i++){
            int session=0,idx=0;
            state=i;
            while(state!=0){
                p=state&1;
                if(p==1) session+=tasks[idx];
                state>>=1;
                idx++;
            }
            if(session<=sessionTime) dp[i-1]=1;
        }

        for(int i=1;i<m;i++){
            if(dp[i-1]==1) continue;
            for(int j=i;j>0;j=(j-1)&i){
                dp[i-1]=Math.min(dp[i-1],dp[i-1]+dp[j^(i-1)]);
            }
        }
        return dp[m-2];
    }
}
