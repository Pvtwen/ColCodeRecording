package dataStructure.Test;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/12/4 11:13
 */
public class Question638Review2 {
    // bfs
    HashMap<List<Integer>,Integer> map=new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Deque<List<Integer>> queue=new ArrayDeque<>();
        queue.offer(needs);
        map.put(needs,0);
        int res=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            List<Integer> need = queue.poll();
            // all in
            int ret = computeAllIn(price, need);
            Integer money = map.get(need);
            // 直接计算
            res=Math.min(res,money+ret);

            for(int i=0;i<special.size();i++){
                ArrayList<Integer> copy = new ArrayList<>(need);
                List<Integer> bag = special.get(i);
                int flag=1;
                for(int j=0;j<copy.size();j++){
                    Integer i1 = copy.get(j);
                    Integer i2 = bag.get(j);
                    if(i1-i2<0) {
                        flag=-1;
                        break;
                    }
                    copy.set(j,i1-i2);
                }
                // 如果计算超时 就在加入队列之前就计算res ，但是此时的bfs相当于是暴搜，所以不用提前计算
                // 如果是类似于找迷宫出口，那么bfs的效率非常高，一旦找到出口，立即返回
                // 注意，测试用例 【1，2，3】【1，2，5】两个礼包重复了，价格高的礼包会覆盖之前map存在的map价格低的礼包
                // 所以此处要做判断
                boolean b = AllZero(copy);
                if(b && flag==1) {
                    res=Math.min(res,money+special.get(i).get(needs.size()));
                    continue;
                }
                else{
                    if(flag==1){
                        if(map.containsKey(copy)){
                            Integer backup = map.get(copy);
                            if (backup < money + special.get(i).get(needs.size())) {
                                continue;
                            }
                        }
                        map.put(copy,money+special.get(i).get(needs.size()));
                        queue.offer(copy);
                    }
                }
            }
        }
        return res;
    }
    public boolean AllZero(List<Integer> copy){
        for (Integer integer : copy) {
            if(integer!=0) return false;
        }
        return true;
    }
    public int computeAllIn(List<Integer> price,List<Integer> needs){
        int money=0;
        for(int i=0;i<price.size();i++){
            money+=price.get(i)*needs.get(i);
        }
        return money;
    }
//     dfs+记忆化
//    HashMap<List<Integer>,Integer> map=new HashMap<>();
//    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
//        return dfs(price,special,needs);
//    }
//    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
//        if(map.containsKey(needs)) return map.get(needs);
//        int money=0;
//        // 全部零买
//        for(int i=0;i<needs.size();i++){
//            money+=price.get(i)*needs.get(i);
//        }
//        for(int i=0;i<special.size();i++){
//            int flag=1;
//            ArrayList<Integer> copy = new ArrayList<>(needs);
//            List<Integer> bag = special.get(i);
//            for(int j=0;j<needs.size();j++){
//                Integer i1 = copy.get(j);
//                Integer i2 = bag.get(j);
//                if(i1-i2<0){
//                    flag=-1;
//                    break;
//                }
//                copy.set(j,i1-i2);
//            }
//            if(flag==1){
//                money=Math.min(money,dfs(price,special,copy)+special.get(i).get(needs.size()));
//            }
//        }
//        map.put(needs,money);
//        return money;
//    }
}
