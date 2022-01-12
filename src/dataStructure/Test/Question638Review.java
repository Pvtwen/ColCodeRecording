package dataStructure.Test;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/19 16:58
 */
public class Question638Review {
    //BFS 边权不为1  边权为一的题目Quesiton397
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int size = needs.size();
        //needs
        Deque<List<Integer>> queue=new ArrayDeque<>();
        HashMap<List<Integer>,Integer> map=new HashMap<>();
        queue.offer(needs);
        map.put(needs,0);
        int res=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            List<Integer> needCopy = queue.poll();
            // all in 可以直接得到结果
            int compute = compute(price, needCopy);
            compute+=map.get(needCopy);
            res=Math.min(compute,res);
            for(int i=0;i<special.size();i++){
                List<Integer> copy=new ArrayList<>(needCopy);
                int flag=1;
                for(int j=0;j<needs.size();j++){
                    Integer num = copy.get(j);
                    num-=special.get(i).get(j);
                    if(num<0){
                        flag=-1;
                        break;
                    }
                    copy.set(j,num);
                }
                if(flag==1){
                    if(!map.containsKey(copy)){
                        queue.offer(copy);
                        map.put(copy,map.get(needCopy)+special.get(i).get(needs.size()));
                    }
                    else{
                        Integer money = map.get(copy);
                        int i1 = map.get(needCopy) + special.get(i).get(needs.size());
                        if(money>i1){
                            map.put(copy,i1);
                        }
                    }
                }
            }
        }
        return res;
    }
    public int compute(List<Integer> price,List<Integer> needs){
        int count=0;
        for(int i=0;i<needs.size();i++){
            count+=price.get(i)*needs.get(i);
        }
        return count;
    }
//    static HashMap<List<Integer>,Integer> map=new HashMap<>();
//    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
//        return dfs(price,special,needs);
//    }
//    public static int dfs(List<Integer> price,List<List<Integer>> special,List<Integer> needs){
//        if(map.containsKey(needs)) return map.get(needs);
//        // all in
//        int money=0;
//        for(int i=0;i<needs.size();i++){
//            money+=needs.get(i)*price.get(i);
//        }
//        for(int i=0;i<special.size();i++){
//            List<Integer> copyNeed=new ArrayList<>(needs);
//            int flag=1;
//            for(int j=0;j<needs.size();j++){
//                Integer num = copyNeed.get(j);
//                num-=special.get(i).get(j);
//                if(num<0) {
//                    flag=-1;
//                    break;
//                }
//                copyNeed.set(j,num);
//            }
//            if(flag==1){
//                money=Math.min(money,dfs(price,special,copyNeed)+special.get(i).get(needs.size()));
//            }
//        }
//        map.put(needs,money);
//        return money;
//    }
}
