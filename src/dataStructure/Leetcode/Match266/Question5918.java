package dataStructure.Leetcode.Match266;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/11/7 10:44
 */
public class Question5918 {
    int res=0;
    public int countVowelSubstrings(String word) {
        int length = word.length();
        for(int i=0;i<length;i++){
            for(int j=i+4;j<length;j++){
                vowel(word.substring(i,j+1));
            }
        }
        return res;
    }

    public void vowel(String word){
        int length = word.length();
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a',0);
        map.put('e',0);
        map.put('i',0);
        map.put('o',0);
        map.put('u',0);
        for(int i=0;i<length;i++){
            char c = word.charAt(i);
            if(!map.containsKey(c)) return;
            map.put(c,map.get(c)+1);
        }
        if(map.get('a')>0 && map.get('e')>0 && map.get('i')>0 && map.get('o')>0 && map.get('u')>0) res++;
    }
}
