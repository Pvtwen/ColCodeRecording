package dataStructure.Leetcode;

import dataStructure.Leetcode.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/3 15:11
 */
public class Question113 {
    List<List<Integer>> res=new ArrayList<>();
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum=targetSum;
        dfs(root,0,new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root,int sum,List<Integer> list){
        // 空点
        if(root==null) return ;
        //判断是叶子节点
        int val = root.val+sum;
        if(root.left==null && root.right==null){
            if(val==targetSum){
                list.add(root.val);
                res.add(list);
            }
            return;
        }
        List<Integer> copy=new ArrayList<>(list);
//        List<Integer> copy1=new ArrayList<>(list);
        copy.add(root.val);
//        copy1.add(root.val);
        dfs(root.left,val,copy);
        dfs(root.right,val, copy);
    }
}
