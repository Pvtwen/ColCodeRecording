package dataStructure.Graph7Chapter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/11/29 15:57
 */
public class Graph {
    Set<Node> nodes=new HashSet<>();
    public void addNode(Node node){
        nodes.add(node);
    }
}
