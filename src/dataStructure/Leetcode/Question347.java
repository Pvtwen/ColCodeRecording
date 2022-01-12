package dataStructure.Leetcode;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/10/16 15:53
 */
public class Question347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

//        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        HashMap<Integer, List<Integer>> map1=new HashMap<>();
//
//        for (Integer integer : map.keySet()) {
//            Integer hez = map.get(integer);
//            priorityQueue.add(hez);
//
//            if(!map1.containsKey(hez)){
//                List<Integer> list=new ArrayList<>();
//                list.add(integer);
//                map1.put(hez,list);
//            }else{
//                map1.get(hez).add(integer);
//            }
//        }

        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            priorityQueue.offer(new int[]{key,value});
        }

        int[] res=new int[k];

        for(int i=1;i<=k;i++){
            int[] max = priorityQueue.poll();
            int val = max[0];
            res[i-1]=val;
        }
        return res;
    }
}
