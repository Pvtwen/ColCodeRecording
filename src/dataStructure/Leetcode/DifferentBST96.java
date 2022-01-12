package dataStructure.Leetcode;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/7/19 11:07
 */
public class DifferentBST96 {
    public static int numTrees(int n){
        // 动态规划  卡特兰数
        //假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
        //G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
        //
        //当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
        //f(i) = G(i-1)*G(n-i)
        //
        //综合两个公式可以得到 卡特兰数 公式
        //G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        //内层循环根据G(0),G(1)求G(i)
        for(int i=2;i<n+1;i++){
            for(int j=1;j<i+1;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
