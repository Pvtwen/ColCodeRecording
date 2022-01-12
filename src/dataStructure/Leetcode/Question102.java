package dataStructure.Leetcode;

import dataStructure.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author 86153
 * @data 2021/7/24 9:30
*/

public class Question102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> nodes=new ArrayList<>();
        List<TreeNode> children=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        nodes.add(root);

        while(nodes.size()!=0){
        for (TreeNode node : nodes) {
            list.add(node.val);
            if(node.left!=null){
                children.add(node.left);
            }
            if(node.right!=null){
                children.add(node.right);
            }

        }
            nodes=children;
            ans.add(list);
            list=new ArrayList<>();
            children=new ArrayList<>();
        }
        return ans;
    }
}
