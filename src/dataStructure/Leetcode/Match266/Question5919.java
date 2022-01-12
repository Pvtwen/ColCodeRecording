package dataStructure.Leetcode.Match266;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/11/7 11:01
 */
public class Question5919 {
//    static Set<Character> set=new HashSet<>();
//    static{
//        set.add('a');
//        set.add('e');
//        set.add('i');
//        set.add('o');
//        set.add('u');
//    }
//    public long countVowels(String word) {
//
//        int length=word.length();
//        long res=0;
//        for(int i=0;i<length;i++){
//            char c=word.charAt(i);
//            if(set.contains(c)){
//                res+=(long)(i+1)*(length-i);
//            }
//        }
//        return res;
//    }

    // dp[i]只依赖于dp[i-1]
    public long countVowels(String word) {
        int length=word.length();

        long dp=0;
        long sum=0;
        if(isWord(word.charAt(0)))dp=1;
        for(int i=1;i<length;i++){
            if(isWord(word.charAt(i))) {
                dp+=i+1;
            }
            sum+=dp;
        }
        return sum;
    }
    public boolean isWord(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}
