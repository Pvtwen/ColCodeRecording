package dataStructure.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/10/8 18:06
 */
public class Question187 {
//    public List<String> findRepeatedDnaSequences(String s) {
        // 1.  哈希表
//        if(s.length()<10) return new ArrayList<>();
//        HashMap<String,Integer> map=new HashMap<>();
//        List<String> list=new ArrayList<>();
//        int length = s.length();
//
//        for(int i=0,j=i+10;j<length+1;i++,j++){
//            String substring = s.substring(i, j);
//            map.put(substring,map.getOrDefault(substring,0)+1);
//        }
//        for (String s1 : map.keySet()) {
//            if(map.get(s1)>1) list.add(s1);
//        }
//        return list;

        // 2. 哈希表+位运算+滑动窗口
        public List<String> findRepeatedDnaSequences(String s) {
            HashMap<Character,Integer> map=new HashMap<>(){{
                put('A',0);
                put('T',1);
                put('C',2);
                put('G',3);
            }};
            int length=s.length();

            int x=0;
            // 构造滑动窗口
            for(int i=0;i<9;i++){
                x=(x<<2) | map.get(s.charAt(i)); // 滑动窗口进新元素
            }

            HashMap<Integer,Integer> map1=new HashMap<>();
            List<String> list=new ArrayList<>();
            for(int i=9;i<length;i++){
                x= (x<<2) | map.get(s.charAt(i));
                x= x & ((1<<20)-1);
                map1.put(x,map1.getOrDefault(x,0)+1);
                if(map1.get(x)==2){
                    list.add(s.substring(i-9,i));
                }
            }
            return list;
    }
}
