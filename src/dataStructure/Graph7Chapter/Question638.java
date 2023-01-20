package dataStructure.Graph7Chapter;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/14 10:20
 * 优先队列Dijtsra
 */
public class Question638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        // visited访问变量 只存状态 不存价格  存在说明已确定最小价格 不存在还不确定
        HashSet<List<Integer>> visited=new HashSet<>();
        // distance距离 存状态 存在说明可达 不存在不可达、
        HashMap<List<Integer>,Integer> distance=new HashMap<>();
        // 优先队列以distance由小到大排序
        PriorityQueue<List<Integer>> queue=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return distance.get(o1)-distance.get(o2);
            }
        });
        // 0000 存储最终状态
        List<Integer> desti=new ArrayList<>();
        for(int i=0;i<n;i++){
            desti.add(0);
        }
        distance.put(desti,Integer.MAX_VALUE);

        queue.offer(needs);
        // 开始状态distance为0
        distance.put(needs,0);
        while(!queue.isEmpty()){
            // 选择当前所能到达的所有状态中 价格最便宜(最短路径)的那一个状态
            List<Integer> pack = queue.poll();
            // 如果已经是最短路径 跳过
            if(visited.contains(pack)) continue;
            visited.add(pack);
            Integer p = distance.get(pack);
            // 每次都需要更新最终状态
            int i = allIn(pack,price);
            Integer p1 = distance.get(desti);
            // update 0000
            if(p1>i+p) distance.put(desti,i+p);

            // 遍历所有的大礼包
            for (List<Integer> packs : special) {
                ArrayList<Integer> copy=new ArrayList<>(pack);
                int flag=-1;
                for(int j=0;j<packs.size()-1;j++){
                    int i1 = pack.get(j) - packs.get(j);
                    if(i1<0) {
                        flag=1;
                        break;
                    }
                    copy.set(j,i1);
                }
                if(flag==-1){
                    if(!visited.contains(copy)){
                        int p2 = packs.get(n) + p;
                        if(distance.containsKey(copy)){
                            Integer p3 = distance.get(copy);
                            if(p2<p3) distance.put(copy,p2);
                        }else distance.put(copy,p2);
                        queue.offer(copy);
                    }
                }
            }
        }
        return distance.get(desti);
    }
   public int allIn(List<Integer> list,List<Integer> price){
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i)*price.get(i);
        }
        return sum;
    }
}
