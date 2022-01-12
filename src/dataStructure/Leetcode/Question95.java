package dataStructure.Leetcode;

import dataStructure.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86153
 * @data 2021/7/23 12:42
 */
public class Question95 {
    public List<TreeNode> generateTrees(int n){
        return getAns(1,n);
    }
    public List<TreeNode> getAns(int start,int  end){
        ArrayList<TreeNode> ans = new ArrayList<>();
        // 该情况说明节点无左子树或者右子树
        if(start>end){
            ans.add(null);
            return ans;
        }
        if(start==end){
            TreeNode treeNode = new TreeNode(start);
            ans.add(treeNode);
            return ans;
        }

        //第一个for：所有的元素做根节点的情况（包括已经进入递归后，也可能根节点有多种情况)
        for(int i=start;i<=end;i++){
            // 递归得到所有的拼接情况
            List<TreeNode> leftTreeNodes = getAns(start,i-1);
            List<TreeNode> rightTreeNodes = getAns(i + 1, end);
            // 遍历得到所有的节点
            for (TreeNode leftTreeNode : leftTreeNodes) {
                for (TreeNode rightTreeNode : rightTreeNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left=leftTreeNode;
                    root.right=rightTreeNode;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
