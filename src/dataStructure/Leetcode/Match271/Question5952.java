package dataStructure.Leetcode.Match271;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Yawen Cao
 * @data 2021/12/12 10:40
 */
public class Question5952 {
    static  HashMap<Integer, HashSet<Character>> map=new HashMap<>();
    public static int countPoints(String rings) {
        int length = rings.length();
        boolean[] visited = new boolean[10];
        int res=0;
        for(int i=0;i<length;i+=2){
            char color=rings.charAt(i);
            char num = rings.charAt(i + 1);
            int n = Integer.parseInt("" + num);
            HashSet<Character> set = map.getOrDefault(n, new HashSet<>());
            set.add(color);
            if(set.size()==3){
                if(!visited[n]) {
                    res++;
                    visited[n]=true;
                }
            }
            map.put(n,set);
        }
        return res;
    }
}
