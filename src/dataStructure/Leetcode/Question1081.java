package dataStructure.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/10/4 20:33
 */
public class Question1081 {
    public static String smallestSubsequence(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> dequeMap=new HashMap<>();
        int len=s.length();

        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        Deque<Character> deque=new ArrayDeque<>();
        int i=0;
        while(i<len){
            char c = s.charAt(i);
            while(!deque.isEmpty() && c<deque.getLast() && map.get(deque.getLast())-dequeMap.get(deque.getLast())>0){
                Character ch = deque.removeLast();
                map.put(ch,map.get(ch)-1);
                dequeMap.remove(ch);
            }
            if(!dequeMap.containsKey(c)) {
                deque.add(c);
                dequeMap.put(c,1);
            }else map.put(c,map.get(c)-1);

            i++;
        }

        StringBuilder string=new StringBuilder();
        int size = deque.size();
        for(int j=0;j<size;j++){
            Character ch = deque.poll();
            string.append(ch);
        }
        return string.toString();
    }
}
