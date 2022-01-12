package dataStructure.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/10/3 20:11
 */
public class Question402 {
    public static String removeKdigits(String num, int k) {
        Deque<Character> deque=new ArrayDeque<>();
        int n=num.length();
        int i=0;
        int temp=k;
        while(i<n){
            char c = num.charAt(i);
            while(!deque.isEmpty() && k>0 && c<deque.getLast()){
                deque.removeLast();
                k--;
            }
            deque.add(c);
            i++;
            // 注意：此处当k==0时，不能提前终止遍历   用例："9876500000" k=1.   报空指针异常
//            if(k==0) break;
        }

        StringBuilder string=new StringBuilder();
        for(int j=0;j<n-temp;j++){
            char ch = deque.poll();
            if(ch=='0' && string.length()==0) continue;
            string.append(ch);
        }
        return string.toString().equals("")?"0":string.toString();
    }
}
