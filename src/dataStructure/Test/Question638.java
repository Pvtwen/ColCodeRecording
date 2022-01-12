package dataStructure.Test;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/7 10:16
 */
public class Question638 {
    // 记忆化搜索  动态规划  存状态

    HashMap<List<Integer>,Integer> map=new HashMap<>();
    int n;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n=price.size();
        return dfs(price,special,needs);
    }

    public int dfs(List<Integer> price,List<List<Integer>> speicial,List<Integer> needs){
        // 如果map中包含needs状态 那么返回的价格一定是最优价格
        if(map.containsKey(needs)) return map.get(needs);
        int moneyAllIn=0;
        // 不买大礼包
        for(int i=0;i<needs.size();i++){
            moneyAllIn+=price.get(i)*needs.get(i);
        }

        for(int i=0;i<speicial.size();i++){
            int flag=1;
            List<Integer> copy=new ArrayList<>(needs);
            for(int j=0;j<n;j++){
                if(needs.get(j)<speicial.get(i).get(j)){
                    flag=-1;
                    break;
                }
                copy.set(j,copy.get(j)-speicial.get(i).get(j));
            }
            if(flag==1){
                // 此时dfs返回的copy状态所需要的价格一定是最小价格吗？
                // 答案是肯定的 动态规划的实质就是由已知推结果
                moneyAllIn=Math.min(moneyAllIn,speicial.get(i).get(n)+dfs(price,speicial,copy));
                map.put(needs,moneyAllIn);
            }
        }
        return moneyAllIn;
    }
}
