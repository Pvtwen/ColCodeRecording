package dataStructure.Leetcode;

import dataStructure.Node.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 86153
 * @data 2021/7/28 19:44
 */
public class Question863 {
    public List<Integer> ans=new ArrayList<>();
    public HashMap<Integer,TreeNode> parents=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        generateMap(root,null);
        recursion(target,null,0,k);
        return ans;
    }
    // 生成 key:二叉树节点值 -- value: 该节点值的父节点TreeNode

    public void generateMap(TreeNode root,TreeNode from){
        if(root==null){
            return;
        }
        parents.put(root.val,from);
        generateMap(root.left,root);
        generateMap(root.right,root);
    }
    public void recursion(TreeNode node,TreeNode from,int depth,int k){
        // 递归结束条件
        if(node==null){
            return ;
        }
        // 如果深度为K,则结果集添加该值
        if(depth==k){
            ans.add(node.val);
        }
        // 如果目前节点的左节点不是来自递归调用的节点，则往左节点递归
        if(node.left!=from){
            recursion(node.left,node,depth+1,k);
        }
        // 如果目前节点的右节点不是来自递归调用的节点，则往右节点递归
        if(node.right!=from){
            recursion(node.right,node,depth+1,k);
        }
        // 如果目前节点的父节点不是来自递归调用的节点，则向父节点递归
        if(parents.get(node.val)!=from){
            recursion(parents.get(node.val),node,depth+1,k);
        }
    }
}
