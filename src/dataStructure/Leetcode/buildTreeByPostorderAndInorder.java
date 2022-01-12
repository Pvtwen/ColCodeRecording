package dataStructure.Leetcode;

import dataStructure.Node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 86153
 * @data 2021/7/3 11:34
    根据中序和后序遍历构造二叉树
 */
public class buildTreeByPostorderAndInorder {
    private static Map<Integer,Integer> map=new HashMap<>();

    public static TreeNode buildTree(int[] inorder,int[] postorder){
        if(inorder.length!=postorder.length){
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return BuildUtil(postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public static TreeNode BuildUtil(int[] postorder,int postLeft,int postRight,int inLeft,int inRight){
        if(postLeft>postRight){
            return null;
        }
        // 得到后序遍历 根节点的索引
        int rootIndex=map.get(postorder[postRight]);
        //构建 节点
        TreeNode treeNode = new TreeNode(postorder[postRight]);
        //postLeft: 右子树在后序遍历区间的左区间 inLeft: 右子树在中序遍历区间的左区间
        treeNode.right=BuildUtil(postorder,rootIndex+postLeft-inLeft,postRight-1,rootIndex+1,inRight);
        //postleft: 左子树在后序遍历区间的左区间 inLeft: 左子树在中序遍历区间的左区间
        treeNode.left=BuildUtil(postorder,postLeft,rootIndex+postLeft-inLeft-1,inLeft,rootIndex-1);
        return treeNode;
    }
}
