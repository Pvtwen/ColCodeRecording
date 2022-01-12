package dataStructure.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/9/25 10:22
 */
public class Question3 {
//    public int lengthOfLongestSubstring(String s) {
//        Set<String> set=new HashSet<>();
//        int n=s.length();
//        int left=0,right=0;
//        int len=Integer.MIN_VALUE;
//
//        while(right<n){
//            String sub = s.substring(right, right + 1);
//            while(set.contains(sub)){
//                String sub1 = s.substring(left, left + 1);
//                set.remove(sub1);
//                left++;
//            }
//            set.add(sub);
//            len=Math.max(len,right-left+1);
//            right++;
//        }
//        return len==Integer.MIN_VALUE?0:len;
//    }
    public static int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int right=0,left=0;
        HashMap<String,Integer> map=new HashMap<>();
        int len=Integer.MIN_VALUE;

        while(right<n){
            String sub = s.substring(right, right + 1);
            if(map.containsKey(sub))
                left=Math.max(left,map.get(sub)+1);
            len=Math.max(len,right-left+1);
            map.put(sub,right);
            right++;
        }
        return len==Integer.MIN_VALUE?0:len;
    }
}
