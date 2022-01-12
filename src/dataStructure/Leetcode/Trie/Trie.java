package dataStructure.Leetcode.Trie;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/9/29 15:45
 * Question208
 */
public class Trie {
//    Trie root;
    HashMap<Character,Trie> map;
    int flag;
    Character val;
    public Trie() {
//        root=new Trie();
        map=new HashMap<>();
        flag=0;
    }

    public void insert(String word) {
        char[] arr = word.toCharArray();
        int n=arr.length;
        Trie node=this;
        for(int i=0;i<n;i++){
            HashMap<Character, Trie> nodeMap = node.map;
            if(!nodeMap.containsKey(arr[i])){
                Trie node1=new Trie();
                node1.val=arr[i];
                nodeMap.put(arr[i],node1);
                node=node1;
            }else{
                node= nodeMap.get(arr[i]);
            }
        }
        node.flag=1;
    }

    public boolean search(String word) {
        char[] arr = word.toCharArray();
        int n=arr.length;
        Trie node=this;

        for(int i=0;i<n;i++){
            HashMap<Character, Trie> nodeMap = node.map;
            if(!nodeMap.containsKey(arr[i])){
                return false;
            }else{
                node= nodeMap.get(arr[i]);
            }
        }
        return node.flag == 1;
    }

    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        int n=arr.length;
        Trie node=this;
        for(int i=0;i<n;i++){
            HashMap<Character, Trie> nodeMap = node.map;
            if(nodeMap.containsKey(arr[i])){
                node=nodeMap.get(arr[i]);
            }else{
                return false;
            }
        }
        return true;
    }
}
