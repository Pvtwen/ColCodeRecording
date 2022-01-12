package dataStructure.Leetcode.Match262;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Yawen Cao
 * @data 2021/10/13 19:03
 */
public class Question2034 {
    HashMap<Integer,Integer> map;
    PriorityQueue<int[]> max;
    PriorityQueue<int[]> min;
    int current;
    public Question2034() {
        current=-1;
        max=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        min=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        map=new HashMap<>();
    }

    public void update(int timestamp, int price) {
        int[] data=new int[2];

        if(current<timestamp) current=timestamp;
        data[0]=timestamp;
        data[1]=price;

        map.put(timestamp,price);
        max.add(data);
        min.add(data);
    }

    public int current() {
        return map.get(current);
    }

    public int maximum() {

        while(!max.isEmpty() && map.get(max.peek()[0])!=max.peek()[1]){
            max.poll();
        }
        return max.peek()[1];
    }

    public int minimum() {
        while(!min.isEmpty() && map.get(min.peek()[0])!=min.peek()[1]){
            min.poll();
        }
        return min.peek()[1];
    }
}
