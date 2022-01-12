package dataStructure.Leetcode.Match261;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/10/7 20:39
 */
public class Question2030 {
    public static String smallestSubsequence(String s, int k, char letter, int repetition) {
        int len=s.length();
        int totalLetterNum=0;
//        int dequeLetterNum=0;
        int del=0;
        Deque<Character> deque=new ArrayDeque<>();

        for(int i=0;i<len;i++){
            if(s.charAt(i)==letter) totalLetterNum++;
        }

        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            // 数组元素有多余 可以删除
            while(!deque.isEmpty() && len-k>del && deque.size()+len-i>k && c<deque.getLast()){
                if(deque.getLast()==letter){
                    if(totalLetterNum>repetition) {
                        deque.removeLast();
                        totalLetterNum--;
                        del++;
                    }else if(totalLetterNum==repetition) break;
                }else if(deque.getLast()!=letter){
                    deque.removeLast();
                    del++;
                }
            }
//            if(deque.isEmpty()) deque.add(c);
//            else if(c==letter) deque.add(c);
//            else if(deque.getLast()!=letter) deque.add(c);
//            else if(len-k==del) deque.add(c);
//            else if(totalLetterNum>=repetition && deque.getLast()==letter && c>deque.getLast()) deque.add(c);
//            else if(totalLetterNum==repetition && c<)
            deque.add(c);
        }

        StringBuilder string=new StringBuilder();
        while(!deque.isEmpty() && string.length()<k){
            Character poll = deque.poll();
            if(poll==letter){
                string.append(poll);
                repetition--;
            }else if(k-string.length()>repetition){
                string.append(poll);
            }
        }

        return string.toString();
    }
}
