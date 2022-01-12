package dataStructure.Leetcode;

import com.sun.source.tree.Tree;
import dataStructure.Leetcode.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/4 9:25
 */
public class Question114 {
    static List<TreeNode> list=new ArrayList<>();
    public static void flatten(TreeNode root) {
        dfs(root);
        root.left=null;
        root.right=null;
        int size = list.size();
        for(int i=1;i<size;i++){
            TreeNode treeNode = list.get(i);
            treeNode.left=null;
            treeNode.right=null;
            root.right=treeNode;
            root=treeNode;
        }
    }

    public static void dfs(TreeNode root){
        if(root==null) return;
        list.add(root);

        dfs(root.left);
        dfs(root.right);
    }
}
