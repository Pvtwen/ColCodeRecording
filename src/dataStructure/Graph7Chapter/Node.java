package dataStructure.Graph7Chapter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Yawen Cao
 * @data 2021/11/29 15:49
 */
public class Node {
    String name;
    List<Node> shortestPath=new LinkedList<>();
    Integer distance=Integer.MAX_VALUE;
    Map<Node,Integer> adjacentNodes=new HashMap<>();    // key: 节点 Integer: 权值
    public void addDestination(Node destination,int distance){
        adjacentNodes.put(destination,distance);
    }
    public Node(String name){
        this.name=name;
    }
}
