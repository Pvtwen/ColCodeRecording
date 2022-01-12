package dataStructure.RIP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/10/26 14:48
 */
public class Route {
    RouteTable SourceTable;
    Set<Route> neighbourRoutes;
    HashMap<Route,Integer> TTL;
    public Route(){
        SourceTable=new RouteTable();
        neighbourRoutes=new HashSet<>();
        TTL=new HashMap<>();
    }

    public void setNeighbourRoutes(Route route){
        neighbourRoutes.add(route);
    }

    public void getNewPackage(RouteTable newTable){
        SourceTable=newTable;
        // 向相邻的路由器发送局域网内的的所有表
        for (Route neighbourRoute : neighbourRoutes) {
            neighbourRoute.updateRouteTable(this,SourceTable);
        }
    }

    // route：路由表来源的路由器
    // table: 路由表
    // 距离向量算法
    public void updateRouteTable(Route route,RouteTable table){
        HashMap<String, distanceAndNextRoute> sourceMap = SourceTable.map;
        HashMap<String, distanceAndNextRoute> destMap = table.map;
        HashMap<String,distanceAndNextRoute> destMapCopy=new HashMap<>(destMap);

        int n = destMap.size();
        String[] discards=new String[n];
        int i=0;
        // 距离加一  目标路由全部换成route
        for (Map.Entry<String, distanceAndNextRoute> entry : destMapCopy.entrySet()) {
            distanceAndNextRoute distanceAndNextRoute = entry.getValue();
            distanceAndNextRoute.distance+=1;
            distanceAndNextRoute.nextRoute=route;
            if(distanceAndNextRoute.distance>16) discards[i++]=entry.getKey();
        }

        // 扔掉所有距离大于16的组
        for (String discard : discards) {
            destMapCopy.remove(discard);
        }

        for (Map.Entry<String, distanceAndNextRoute> entry : destMapCopy.entrySet()) {
            String network = entry.getKey();
            distanceAndNextRoute distanceAndNextRoute = entry.getValue();
            if(!sourceMap.containsKey(network)){
                sourceMap.put(network,distanceAndNextRoute);
            }else{
                distanceAndNextRoute route1 = sourceMap.get(network);
                if(route1.distance<=distanceAndNextRoute.distance) continue;
                else{
                    sourceMap.put(network,distanceAndNextRoute);
                }
            }
        }

        TTL.put(route,0);
        getNewPackage(SourceTable);
    }
}
