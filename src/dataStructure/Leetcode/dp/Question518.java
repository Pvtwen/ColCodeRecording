package dataStructure.Leetcode.dp;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/12/18 17:04
 */
public class Question518 {
    int res = 0;
    HashSet<List<Integer>> map = new HashSet<>();

    //    HashMap<List<Integer>,Integer> map=new HashMap<>();
    public int change(int amount, int[] coins) {
        dfs(0, amount, coins, new ArrayList<>());
        return res;
    }

    public void dfs(int sum, int amount, int[] coins, List<Integer> list) {
        Collections.sort(list);
        if (map.contains(list)) {
            return;
        }
        if (sum > amount) {
            map.add(list);
            return;
        }
        if (sum == amount) {
            if (!map.contains(list)) {
                res++;
                map.add(list);
            }
            return;
        }
        map.add(list);
        for (int i = 0; i < coins.length; i++) {
            int s = coins[i] + sum;
            ArrayList<Integer> copy = new ArrayList<>(list);
            copy.add(coins[i]);
            dfs(s, amount, coins, copy);
        }
    }
}
