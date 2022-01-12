package dataStructure.Leetcode;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/11/5 16:57
 */
public class Question1218 {
     static HashMap<Integer,Integer> map=new HashMap<>();
    public static int longestSubsequence(int[] arr, int difference) {
        int length=arr.length;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            int j = arr[i];

            Integer a = map.getOrDefault(j - difference, 0);
            map.put(j,a+1);
            res=Math.max(res,a+1);
        }

        return res;
    }
}
