package dataStructure.Leetcode.dp1;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/2/7 10:34
 */
public class Coins {
    // 最长路 最短路
    public void solution(int[] coins,int amount){
        int n = coins.length;
        int[] dMax=new int[amount+1];
        int[] dMin=new int[amount+1];
        Arrays.fill(dMax, (int) -1e8);
        Arrays.fill(dMax, (int) 1e8);
        dMin[0]=dMax[0]=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i]){
                    dMax[j]=Math.max(dMax[j],dMax[j-coins[i]]+1);
                    dMin[j]=Math.min(dMin[j],dMin[j-coins[i]]+1);
                }
            }
        }
    }
}
