package dataStructure.Leetcode.Match282;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2022/2/27 10:36
 */
public class Q2 {
    public int minSteps(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> map1=new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : t.toCharArray()) {
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        int num=0;
        for (Character c : map.keySet()) {
            if(map1.containsKey(c)){
                Integer i = map1.get(c);
                if(i>map.get(c)) num+=(i-map.get(c));
                else continue;
            }else num+=map.get(c);
        }
        for (Character c : map1.keySet()) {
            if (map.containsKey(c)) {
                Integer i = map.get(c);
                if(i>map1.get(c)) num+=(i-map1.get(c));
                else continue;
            }else num+=map1.get(c);
        }
        return num;
    }
}
