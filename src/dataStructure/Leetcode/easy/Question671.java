package dataStructure.Leetcode.easy;

import dataStructure.Node.TreeNode;

/**
 * @author 86153
 * @data 2021/7/27 15:13
 * 二叉树中第二小的节点
 */
public class Question671 {
    public int findSecondMinimumValue(TreeNode root) {
        // 如果root为空 返回-1
        if(root==null){
            return -1;
        }
        int val=recursion(root,root.val);
        // 判断返回的值是否与根节点的值相同，如果相同 则返回-1
        return val==root.val?-1:val;
    }
    //用一个形参来保存根结点的值
    public int recursion(TreeNode root,int rootVal){
        // 因为要么子节点的个数为0 要么为 2  则没有左节点 就说明没有右节点
        if(root.left==null){
            return root.val;
        }
        // 递归 从叶节点向根节点出发，将左边子树的最小值和右子树的最小值相互比较
        // 如果两者的最小值都不是根结点的值  则返回最小的
        // 如果其中一者的最小值=根节点的值 则返回较大者
        int leftMin = recursion(root.left, rootVal);
        int rightMin = recursion(root.right, rootVal);
        if(leftMin!=rootVal && rightMin!=rootVal){
            return leftMin>rightMin?rightMin:leftMin;
        }
        return leftMin==rootVal? rightMin:leftMin;
    }
}
