package dataStructure.Leetcode.Trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/10/19 17:04
 * Question211
 */
public class WordDictionary {

    HashMap<Character,WordDictionary> map;
    int flag;

    public WordDictionary() {
        map=new HashMap<>();
        flag=0;
    }

    public void addWord(String word) {
        int length=word.length();
        WordDictionary root = this;
        HashMap<Character,WordDictionary> rootMap;
        for(int i=0;i<length;i++){
            rootMap=root.map;
            char c = word.charAt(i);
            if(!rootMap.containsKey(c)){
                WordDictionary newDict = new WordDictionary();
                rootMap.put(c,newDict);
                root=newDict;
            }else{
                root = rootMap.get(c);
            }
        }
        root.flag=1;
    }

    public boolean search(String word) {
        WordDictionary dict = this;
        return dfs(word,0,dict);
    }

    private boolean dfs(String word,int idx,WordDictionary dict){
        HashMap<Character, WordDictionary> map = dict.map;

        if(idx==word.length()) return dict.flag==1;
        char c = word.charAt(idx);
        if(c!='.'){
            // 字典树中不包含c 剪枝
            if(!map.containsKey(c)) return false;
            else{
                WordDictionary nextDict = map.get(c);
                // 直接返回
                return dfs(word,idx+1,nextDict);
            }
        }
        else{
            Set<Character> set = getAllWordDict(dict);
            for (Character ch : set) {
                WordDictionary nextDict = map.get(ch);
                boolean flag = dfs(word, idx+1, nextDict);
                if(flag==true) return true;
            }
        }

        return false;
    }

    private Set<Character> getAllWordDict(WordDictionary dict){
        Set<Character> set=new HashSet<>();
        HashMap<Character, WordDictionary> map = dict.map;
        for (Character c : map.keySet()) {
            set.add(c);
        }
        return set;
    }
}
