package dataStructure.Graph7Chapter;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/29 11:30
 * 1.从unsettledNodes中找到路径最短的节点，将该节点加入到settledNode(此时所有unsettledNodes中节点的距离已经更新)
 * 2. 将刚删除节点的相邻节点遍历，若距离小于原来的距离，则更新，并把相邻节点的最短路径链表更新。
 *
 */
public class Dijtstra {
    public Graph calculateSP(Graph graph,Node source){
        source.distance=0;
        HashSet<Node> settledNodes = new HashSet<>();
        HashSet<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);
        source.shortestPath.add(source);

        while(unsettledNodes.size()!=0){
            Node lowestDistanceNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(lowestDistanceNode);
            settledNodes.add(lowestDistanceNode);
            // 把删除节点的相邻节点加入unsettledNodes
            for (Map.Entry<Node, Integer> adja : lowestDistanceNode.adjacentNodes.entrySet()) {
                Node neigh = adja.getKey();

                Integer weigh = adja.getValue();
                if (!settledNodes.contains(neigh)) {
                    calculateMinDistance(neigh,weigh,lowestDistanceNode);
                    unsettledNodes.add(neigh);
                }
            }
        }
        return graph;
    }
    // 从没有安置的节点中找到最短路径的节点
    public Node getLowestDistanceNode(Set<Node> unsettledNode){
        Node lowestDistanceNode=null;
        int lowestDistance=Integer.MAX_VALUE;
        for (Node node : unsettledNode) {
            Integer distance = node.distance;
            if(distance<lowestDistance){
                lowestDistance=distance;
                lowestDistanceNode=node;
            }
        }
        return lowestDistanceNode;
    }
    // 更新每个节点的最短路径
    public void calculateMinDistance(Node evaluationNode,Integer edgeWeigh,Node sourceNode){
        Integer sourceDistance = sourceNode.distance;
        if (sourceDistance + edgeWeigh < evaluationNode.distance) {
            evaluationNode.distance=sourceDistance+edgeWeigh;
            LinkedList<Node> lists=new LinkedList<>(sourceNode.shortestPath);
            lists.add(evaluationNode);
            evaluationNode.shortestPath=lists;
        }
    }
//    public int[] dijtstra(int[][] gragh,int[][] distance,int n){
//        return null;
//        vec<> ans;
//        list[i].for:
//        if(distace[i][j]<initDistace[i][j]) initDistace[i][j]=distance[i][j];
        // 找目前还没加入向量且距离的最短路径
//        for(distance: all distance){
//            minIdx=Math.min();
//        }
//        idx=minIdx;
//        ans.add(idx);
//    }

}
