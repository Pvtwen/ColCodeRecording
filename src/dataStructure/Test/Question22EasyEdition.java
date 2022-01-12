package dataStructure.Test;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/8 11:04
 */
public class Question22EasyEdition {
    // 给定一个字符串 判断括号是否生效
    public static void generateParenthesis(String s) {
//        int length = s.length();
//
//        Deque<Character> queue=new ArrayDeque<>();
//        int i=0;
//        while(i<length){
//            char c = s.charAt(i);
//            if(queue.isEmpty()){
//               queue.offer(c);
//            }else{
//                Character last = queue.getLast();
//                if(last==')'){
//                    System.out.println(false);
//                    return;
//                }else if(c>last){
//                    queue.removeLast();
//                }else if(c==last){
//                    queue.offer(c);
//                }
//            }
//            i++;
//        }
//        if(!queue.isEmpty()) System.out.println(false);
//        else System.out.println(true);
    }
}
