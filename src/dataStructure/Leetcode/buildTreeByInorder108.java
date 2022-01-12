package dataStructure.Leetcode;

import dataStructure.Node.TreeNode;

/**
 * @author 86153
 * @data 2021/7/19 10:19
 * 108. 将有序数组转换为二叉搜索树
 */
public class buildTreeByInorder108 {
    /*
      根据题设，二叉搜索树的中序遍历是升序序列 ，因此可以确保数组是二叉搜索树的中序遍历序列.
      根据中序遍历来构造 高度平衡二叉树 (左右两个子树的高度差的绝对值不能超过1)

    */
    public static TreeNode buildTree(int[] inorder){
        return BuildTree(inorder,0,inorder.length-1);
    }

    public static TreeNode BuildTree(int[] inorder,int left,int right){
        //递归结束的条件
        if(left>right){
            return null;
        }
        //找到根节点
        int pIndex=(left+right+1)/2;
        TreeNode treeNode = new TreeNode(inorder[pIndex]);
        treeNode.left=BuildTree(inorder,left,pIndex-1);
        treeNode.right=BuildTree(inorder,pIndex+1,right);

        return treeNode;
    }
}
