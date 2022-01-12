package dataStructure.Leetcode;

import dataStructure.Test.Node;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * @author Yawen Cao
 * @data 2021/10/23 11:28
 */
public class Question133 {
//    public static Node cloneGraph(Node node) {
//        if(node==null) return null;
//        boolean[] visited=new boolean[101];
//        HashMap<Integer,Node> map=new HashMap<>();
//
//        Node root=new Node(1);
//        Node rootCopy=root;
//
//        map.put(1,root);
//        visited[1]=true;
//        Queue<Node> queue=new ArrayDeque<>();
//        Queue<Node> copyQueue=new ArrayDeque<>();
//        copyQueue.offer(root);
//        queue.offer(node);
//        while(!queue.isEmpty() && !copyQueue.isEmpty()){
//            Node poll = queue.poll();
//            root = copyQueue.poll();
//
//            int pollVal = poll.val;
//            List<Node> neighbors = poll.neighbors;
//            visited[pollVal]=true;
//
//            List<Node> list = root.neighbors;
//            for (Node neighbor : neighbors) {
//                int val = neighbor.val;
//                if(!map.containsKey(val)){
//                        Node copy=new Node(val);
//                        list.add(copy);
//                        copy.neighbors.add(root);
//                        queue.offer(neighbor);
//                        copyQueue.offer(copy);
//                        map.put(val,copy);
//                    }else if(map.containsKey(val) && !visited[val]){
//                        Node childNode = map.get(val);
//                        list.add(childNode);
//                        childNode.neighbors.add(root);
//                    }
//                }
//            }
//        return rootCopy;
//        }
//    }
    static HashMap<Integer,Node> map=new HashMap<>();
//    boolean[] visited=new boolean[101];
    public static Node cloneGraph(Node node) {
        Node root=new Node(1);
        map.put(1,root);
        dfs(node,root);
        return root;
    }

    public static void dfs(Node node,Node root){
        int val = node.val;

        List<Node> neighbors = node.neighbors;
        List<Node> list = root.neighbors;
        for (Node neighbor : neighbors) {
            int val1 = neighbor.val;

            if(!map.containsKey(val1)){
                Node newNode=new Node(val1);
                list.add(newNode);
                map.put(val1,newNode);
                dfs(neighbor,newNode);
            }else{
                Node node1 = map.get(val1);
                list.add(node1);
            }
        }
    }
}
//class Node {
//    public int val;
//    public List<Node> neighbors;
//    public Node() {
//        val = 0;
//        neighbors = new ArrayList<Node>();
//    }
//    public Node(int _val) {
//        val = _val;
//        neighbors = new ArrayList<Node>();
//    }
//    public Node(int _val, ArrayList<Node> _neighbors) {
//        val = _val;
//        neighbors = _neighbors;
//    }
//}