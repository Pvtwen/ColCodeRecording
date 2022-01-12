package dataStructure.Leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/12/30 11:25
 */
public class Question846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int length = hand.length;
        // 每组的大小
        if(length%groupSize!=0) return false;

        Arrays.sort(hand);
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i : hand) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // stimulate
        for(int i=0;i<length;i++){
            if(map.get(hand[i])!=0){
                for(int j=hand[i];j<hand[i]+groupSize;j++){
                    if(!map.containsKey(j) || map.get(j)==0 ) return false;
                    map.put(j,map.get(j)-1);
                }
            }
        }
        return true;
    }
}
