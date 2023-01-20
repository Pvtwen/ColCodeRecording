package dataStructure.Test;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/13 11:05
 */
public class Question638NewThought {
    HashMap<List<Integer>,Integer> map=new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Deque<List<Integer>> queue=new ArrayDeque<>();
        queue.offer(needs);
        map.put(needs,0);
        int ret=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            List<Integer> need = queue.poll();
            // money
            Integer money = map.get(need);
            // all in
            int o=0;
            for(int i=0;i<price.size();i++){
                o+=price.get(i)*need.get(i);
            }
            ret=Math.min(o+money,ret);
            for (List<Integer> pack : special) {
                int flag=-1;
                ArrayList<Integer> copy=new ArrayList<>(need);
                for(int i=0;i<pack.size()-1;i++){
                    int i1 = need.get(i) - pack.get(i);
                    if(i1<0){
                        flag=1;
                        break;
                    }
                    copy.set(i,i1);
                }
                // check zero
                boolean b = isNull(copy);
                // 如果为空
                if(b && flag==-1){
                    ret=Math.min(ret,money+pack.get(pack.size()-1));
                }else{
                    if(flag==-1){
                        if(map.containsKey(copy)){
                            Integer integer = map.get(copy);
                            if(integer<money+pack.get(pack.size()-1)){
                                continue;
                            }
                        }
                        map.put(copy,money+pack.get(pack.size()-1));
                        queue.offer(copy);
                    }
                }
            }
        }
        return ret;
    }
    public boolean isNull(List<Integer> need){
        for(int i=0;i<need.size();i++){
            if(need.get(i)!=0){
                return false;
            }
        }
        return true;
    }
//    HashMap<List<Integer>,Integer> map=new HashMap<>();
//    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
//        return dfs(price,special,needs);
//    }
//    public int dfs(List<Integer> price,List<List<Integer>> special,List<Integer> need){
//        int sum=0;
//        for(int i=0;i<need.size();i++){
//            sum+=need.get(i);
//        }
//        if(sum==0) return 0;
//        if(map.containsKey(need)) return map.get(need);
//        int money=0;
//        // all in
//        for(int i=0;i<need.size();i++){
//            money+=need.get(i)*price.get(i);
//        }
//        // package
//        for (List<Integer> pack : special) {
//            int flag=-1;
//            ArrayList<Integer> copy=new ArrayList<>(need);
//            for(int i=0;i<pack.size()-1;i++){
//                int i1 = need.get(i) - pack.get(i);
//                if(i1<0) {
//                    flag=1;
//                    break;
//                }
//                copy.set(i,i1);
//            }
//            if(flag==-1){
//                money=Math.min(money,dfs(price,special,copy)+pack.get(pack.size()-1));
//            }
//        }
//        map.put(need,money);
//        return money;
//    }
}
