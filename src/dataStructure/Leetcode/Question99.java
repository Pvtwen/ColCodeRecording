package dataStructure.Leetcode;

import dataStructure.Leetcode.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/2 14:40
 */
public class Question99 {
//    int idx=0;
    static List<TreeNode> list=new ArrayList<>();
    public static void recoverTree(TreeNode root) {
        dfs(root);

        TreeNode[] arr=new TreeNode[list.size()];
        arr=list.toArray(arr);

        TreeNode first=null;
        int idx=1;
        int firstIdx=-1;
        for(int i=0;i+1<arr.length;i++){
            TreeNode node = arr[i];
            TreeNode node1 = arr[i + 1];

            int val = node.val;
            int val1 = node1.val;

            if(idx==1 && val>val1){
                first=node;
                idx++;
                firstIdx=i;
            }  else if(idx==2 && val>val1){
                int v = first.val;

                first.val=node1.val;
                node1.val=v;

                idx++;
            }
        }
        if(idx==2){
            TreeNode node = arr[firstIdx + 1];
            int temp = first.val;
            first.val=node.val;
            node.val=temp;
        }
    }

    public static void dfs(TreeNode root){
        if(root==null) return;

        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}
