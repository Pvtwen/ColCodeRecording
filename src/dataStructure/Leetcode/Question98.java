package dataStructure.Leetcode;

import dataStructure.Node.TreeNode;

/**
 * @author 86153
 * @data 2021/8/1 10:48
 * 验证二叉搜索树
 * 1，递归
 * 2. 递归+回溯
 */
public class Question98 {
    public boolean isValidBST(TreeNode root) {
        return recursion(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean recursion(TreeNode root,long minVal,long maxVal){
        if(root==null){
            return true;
        }
        if(minVal<root.val && root.val<maxVal){
            return recursion(root.left,minVal,root.val) && recursion(root.right,root.val,maxVal);
        }else{
            return false;
        }
    }
}
