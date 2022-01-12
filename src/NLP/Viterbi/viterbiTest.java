package NLP.Viterbi;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/12/27 21:20
 */
public class viterbiTest {
    // 伪代码
    // dp    n:列数  假设每一列有三个状态
    // 数塔问题
    public int viterbiTest(int n){
        int[][] dp=new int[n][3];
        int weigh=100000;
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                if(i==1) {
                    dp[i][0]=dp[0][0]+weigh;
                    dp[i][1]=dp[0][0]+weigh;
                    dp[i][2]=dp[0][0]+weigh;
                }
                else if(i==n-1){
                    dp[i][0]=Math.min(Math.min(dp[i-1][0]+weigh,dp[i-1][1]+weigh),dp[i-2][2]+weigh);
                }
                else {
                    dp[i][0]=Math.min(Math.min(dp[i-1][0]+weigh,dp[i-1][1]+weigh),dp[i-1][2]+weigh);
                    dp[i][1]=Math.min(Math.min(dp[i-1][0]+weigh,dp[i-1][1]+weigh),dp[i-1][2]+weigh);
                    dp[i][2]=Math.min(Math.min(dp[i-1][0]+weigh,dp[i-1][1]+weigh),dp[i-1][2]+weigh);
                }
            }
        }
        return dp[n-1][0];
    }
    // 伪代码 记忆化递归
    // 哈希表存储该节点到尾节点距离的最小值 因为是从后往前出栈  所以不是求的开始节点到idx对应下标节点的最短路径
    // 反思校赛g题  如果要求的是所有节点到初始节点的最小值 那么反着递归就行了
    // 最后从哈希表中分类找最小值 构成一条路径即可
    HashMap<Integer,Integer> map=new HashMap<>();
    public int hashRecursion(int n,int weigh){
        return dfs(0,n,weigh);
    }
    public int dfs(int idx,int n,int weigh){
        if(idx==n) return weigh;
        if(map.containsKey(idx)) return map.get(idx);
        int dis=1000000;
        for(int i=0;i<3;i++){
            dis=Math.min(dfs(idx+1,n,weigh),dis);
        }
        map.put(idx,dis);
        return dis;
    }
    // dfs 设立一个临时最大值矩阵 再设立一个总的最大值的矩阵 最后从矩阵中找到最大值构成的哪条路径
    int min=Integer.MAX_VALUE;
    int[] tempMax;
    public void dfs1(int idx,int n,int state,int weigh){
        if(idx==n){
            min=Math.min(min,weigh);
            return;
        }
        for(int i=0;i<3;i++){
            dfs1(idx+1,n,i,weigh+weigh);
        }
    }
}
