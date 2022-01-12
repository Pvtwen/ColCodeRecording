package dataStructure.RIP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/10/26 14:55
 */
public class LAN {
    Set<Route> set;
    public LAN(){
        set=new HashSet<>();
    }
    public void addRoute(Route route,HashSet<Route> neighbourRoutes){
        set.add(route);
        // 获取新路由的邻接路由
        Set<Route> routeSet = route.neighbourRoutes;
        for (Route neighbourRoute : neighbourRoutes) {
            Set<Route> routeSet1 = neighbourRoute.neighbourRoutes;
            routeSet.add(neighbourRoute);
            routeSet1.add(route);
        }
    }

    public void removeRoute(Route route){
        Set<Route> routeSet = route.neighbourRoutes;
        for (Route route1 : routeSet) {
            Set<Route> routeSet1 = route1.neighbourRoutes;
            routeSet1.remove(route);
        }
        set.remove(route);
    }
}
