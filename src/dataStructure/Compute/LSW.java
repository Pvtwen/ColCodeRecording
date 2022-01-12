package dataStructure.Compute;

import dataStructure.Leetcode.Node.TreeNode;

/**
 * @author Yawen Cao
 * @data 2021/11/5 9:17
 * 二叉树最长路径
 */
public class LSW {
    int res=Integer.MIN_VALUE;
    public int lsw(TreeNode root){
        dfs(0,root);
        return res;
    }
    public void dfs(int sum,TreeNode root){
        if(root==null){
            res=Math.max(sum,res);
            return;
        }
        dfs(sum+root.val,root.left);
        dfs(sum+root.val,root.right);
    }
}
