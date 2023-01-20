package dataStructure.Leetcode.dp1.Tree;

import dataStructure.Leetcode.Node.TreeNode;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2022/2/16 16:09
 */
public class Q337 {
    // max
    int[][] dp;
    int cur=0;
    HashMap<TreeNode,Integer> map=new HashMap<>();
    public int rob(TreeNode root) {
        dp=new int[(int) 1e5][2];
        dfs(root);
        return Math.max(dp[0][0],dp[0][1]);
    }
    public void dfs(TreeNode node){
        if(node.left==null && node.right==null){
            dp[cur][0]=0;dp[cur][1]=node.val;
            map.put(node,cur++);
            return;
        }
        int temp=cur;
        map.put(node,cur++);
        if(node.left!=null){
            dfs(node.left);
            Integer idx = map.get(node.left);
            dp[temp][0]+=Math.max(dp[idx][0],dp[idx][1]);
            dp[temp][1]+=dp[idx][0];
        }
        if(node.right!=null){
            dfs(node.right);
            Integer idx = map.get(node.right);
            dp[temp][0]+=Math.max(dp[idx][0],dp[idx][1]);
            dp[temp][1]+=dp[idx][0];
        }
        dp[temp][1]+=node.val;
    }
}
