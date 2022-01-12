package dataStructure.Leetcode;

import dataStructure.Node.TreeNode;

/**
 * @author 86153
 * @data 2021/7/25 10:25
 * 完全二叉树的节点个数
 */
public class Question222 {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftCounts=countLevels(root.left);
        int rightCounts=countLevels(root.right);
        //完全二叉树的左右子树的高度相等
        if(leftCounts==rightCounts){
            return countNodes(root.right) + (1<<leftCounts);
        }
        // 左右子树的高度不相等 右子树一定是满二叉树 2^right-1个节点
        else{
            return countNodes(root.left)+(1<<rightCounts);
        }
    }
    public int countLevels(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
