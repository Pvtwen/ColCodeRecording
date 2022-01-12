package dataStructure.Leetcode.Trie;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/10/1 9:22
 */
public class Question692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String> res=new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getKey());
        }
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer count1 = map.get(o1);
                Integer count2 = map.get(o2);
                if(count1==count2) return o1.compareTo(o2);
                else return count2-count1;
            }
        });

        while(k <res.size()){
            res.remove(k);
        }
        return res;
    }
}
