package dataStructure.Leetcode.Match283;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2022/3/6 11:09
 */
public class Q3 {
    HashMap<Integer,TreeNode> map=new HashMap<>();
    HashMap<Integer,Integer> map1=new HashMap<>();
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        for(int i=0;i<n;i++){
            int par = descriptions[i][0];
            int cur = descriptions[i][1];
            int isLeft = descriptions[i][2];
            TreeNode curNode=null;
            if(map.containsKey(cur)){
                curNode = map.get(cur);
            }else{
                curNode = new TreeNode();
                curNode.val=cur;
                map.put(cur,curNode);
            }
            TreeNode parent=null;
            if(map.containsKey(par)){
                parent = map.get(par);
            }else{
                 parent= new TreeNode();
                 parent.val=par;
                 map.put(par,parent);
            }
            if(isLeft==1) parent.left=curNode;
            else parent.right=curNode;
            map1.put(cur,par);
        }
        // 找根
        int root = descriptions[0][1];
        while(map1.containsKey(root)){
            root = map1.get(root);
        }
        return map.get(root);
    }
}
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
