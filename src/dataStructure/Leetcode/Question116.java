package dataStructure.Leetcode;

import dataStructure.Leetcode.Node.*;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Yawen Cao
 * @data 2021/11/1 10:51
 */
public class Question116 {
    public static Node connect(Node root) {
//        if(root==null) return null;
//        HashMap<Node,Integer> map=new HashMap<>();
//        Queue<Node> queue=new ArrayDeque<>();
//
//        Node q=root;
//        queue.offer(root);
//        root.next=null;
//        map.put(root,1);
//
//        while(!queue.isEmpty()){
//            Node poll = queue.poll();
//            Node leftNode = poll.left;
//            Node rightNode = poll.right;
//            if(leftNode!=null) {
//                queue.offer(leftNode);
//                queue.offer(rightNode);
//            }else continue;
//            Integer rootDepth = map.get(poll);
//            map.put(leftNode,rootDepth+1);
//            map.put(rightNode,rootDepth+1);
//
//            Integer depth = map.get(q);
//            if(depth==rootDepth+1) q.next=leftNode;
//            leftNode.next=rightNode;
//            q=rightNode;
//
//        }
//        return null;
        if(root==null) return null;
        dfs(null,root,1);
        return root;
    }

    public static void dfs(Node from,Node to,int depth){
        if(to==null) return;
        if(depth==1)to.next=null;
            // 左节点
        else if(to==from.left) to.next=from.right;
        // 右节点
        else if(to==from.right){
            if(from.next==null) to.next=null;
            else to.next=from.next.left;
        }
        Node left = to.left;
        Node right = to.right;

        dfs(to,left,depth+1);
        dfs(to,right,depth+1);
    }
}
