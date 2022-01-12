package dataStructure.Leetcode;

import dataStructure.Leetcode.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/4 9:58
 */
public class Question230 {
    List<Integer> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return list.get(k-1);
    }
    public void dfs(TreeNode root){
        if(root==null) return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
