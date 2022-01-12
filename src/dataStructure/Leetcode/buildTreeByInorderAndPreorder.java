package dataStructure.Leetcode;

import dataStructure.Node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 86153
 * @data 2021/6/28 20:26
 * 根据前序和中序遍历构造二叉树
 */
public class buildTreeByInorderAndPreorder {
    private Map<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] preorder,int[] inorder) throws Exception {
        if(preorder.length!=inorder.length){
            throw new Exception("incorrect!");
        }
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return BuildUtil(preorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode BuildUtil(int[] preorder,int preLeft,int preRight,int inLeft,int inRight){
        if(preLeft>preRight){
            return null;
        }
        int rootIndex=map.get(preorder[preLeft]);

        TreeNode treeNode = new TreeNode(preorder[preLeft]);
        treeNode.left=BuildUtil(preorder,preLeft+1,preLeft+rootIndex-inLeft,inLeft,rootIndex-1);
        treeNode.right=BuildUtil(preorder,preLeft+1+rootIndex-inLeft,preRight,rootIndex+1,inRight);
        return treeNode;
    }
}
