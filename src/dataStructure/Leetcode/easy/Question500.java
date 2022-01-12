package dataStructure.Leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/10/31 9:47
 */

public class Question500 {
    static HashSet<Character> set1=new HashSet<Character>();
    static HashSet<Character> set2=new HashSet<>();
    static HashSet<Character> set3=new HashSet<>();
        static {
        set1.add('q');set1.add('w');set1.add('e');set1.add('r');set1.add('t');set1.add('y');set1.add('u');set1.add('i');set1.add('o');set1.add('p');
        set2.add('a');set2.add('s');set2.add('d');set2.add('f');set2.add('g');set2.add('h');set2.add('j');set2.add('k');set2.add('l');
            set3.add('z');set3.add('x');set3.add('c');set3.add('v');set3.add('b');set3.add('n');set3.add('m');
    }
    public String[] findWords(String[] words) {
        List<String> list=new ArrayList<>();
            for (String word : words) {
                int flag=-1;
            int length=word.length();
            char c1 = Character.toLowerCase(word.charAt(0));
            HashSet<Character> set;
            if(set1.contains(c1)){
                set=new HashSet<>(set1);
            }else if(set2.contains(c1)){
                set=new HashSet<>(set2);
            }else{
                set=new HashSet<>(set3);
            }
            for(int i=1;i<length;i++){
                char c = Character.toLowerCase(word.charAt(i));
                if(!set.contains(c)) {
                    flag=1;
                    break;
                }

            }
            if(flag==-1) list.add(word);
        }
        return list.toArray(new String[0]);
    }
}
