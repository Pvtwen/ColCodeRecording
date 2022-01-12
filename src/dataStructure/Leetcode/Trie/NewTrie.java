package dataStructure.Leetcode.Trie;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/10/19 16:07
 */
public class NewTrie {
    HashMap<Character,NewTrie> map;
    int flag;
    Character val;
    public NewTrie() {
        map=new HashMap<>();
        flag=0;
    }

    public void insert(String word) {
        int length=word.length();
        NewTrie root=this;
        HashMap<Character, NewTrie> rootMap = root.map;
        for(int i=0;i<length;i++){
            char c = word.charAt(i);
            if(!rootMap.containsKey(c)){
                NewTrie childNode=new NewTrie();
                rootMap.put(c,childNode);
                root=childNode;
            }else{
                root = rootMap.get(c);
            }
            rootMap = root.map;
        }
        root.flag=1;
    }

    public boolean search(String word) {
        int length=word.length();
        NewTrie root = this;
        for(int i=0;i<length;i++){
            char c = word.charAt(i);
            HashMap<Character, NewTrie> rootMap = root.map;
            if(!rootMap.containsKey(c)) return false;
            else{
                root = rootMap.get(c);
            }
        }
        return root.flag==1;
    }

    public boolean startsWith(String prefix) {
        int length=prefix.length();
        NewTrie root = this;
        for(int i=0;i<length;i++){
            char c = prefix.charAt(i);
            HashMap<Character, NewTrie> rootMap = root.map;
            if(!rootMap.containsKey(c)) return false;
            else{
                root = rootMap.get(c);
            }
        }
        return true;
    }
}
