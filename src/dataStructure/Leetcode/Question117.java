package dataStructure.Leetcode;

import dataStructure.Leetcode.Node.Node;

/**
 * @author Yawen Cao
 * @data 2021/11/1 11:55
 */
public class Question117 {
//    public Node connect(Node root) {
//        if(root==null) return null;
//        dfs(null,root,1);
//        return root;
//    }
//
//    public void dfs(Node from,Node to,int depth){
//        if(to==null) return;
//        if(depth==1) to.next=null;
//
//        // 左节点
//        else if(to==from.left && from.right!=null) to.next=from.right;
//        else to.next=checkFirstNode(from.next);
//
//        Node left = to.left;
//        Node right = to.right;
//        dfs(to,right,depth+1);
//        dfs(to,left,depth+1);
//    }
//
//    public Node checkFirstNode(Node then){
//        if(then==null) return null;
//        if(then.left!=null) return then.left;
//        if(then.right!=null) return then.right;
//        else return checkFirstNode(then.next);
//    }

    // 层次遍历
    public Node connect(Node root) {
        Node cur=root;

        while(cur!=null){
            Node dummy=new Node(0);
            Node pre=dummy;

            while(cur!=null){
                if(cur.left!=null){
                    pre.next=cur.left;
                    pre=pre.next;
                }
                if(cur.right!=null){
                    pre.next=cur.right;
                    pre=pre.next;
                }
                cur=cur.next;
            }
            cur=dummy.next;
        }
        return root;
    }
}
