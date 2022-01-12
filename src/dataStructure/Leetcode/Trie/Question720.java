package dataStructure.Leetcode.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/9/29 19:46
 */
public class Question720 {
    static class Trie {
        HashMap<Character, Trie> map;
        int flag;

        public Trie() {
            map = new HashMap<>();
            flag = 0;
        }

        public void insert(String word) {
            char[] arr = word.toCharArray();
            int n = arr.length;
            Trie node = this;

            for (int i = 0; i < n; i++) {
                HashMap<Character, Trie> nodeMap = node.map;
                if (!nodeMap.containsKey(arr[i])) {
                    Trie node1 = new Trie();
                    nodeMap.put(arr[i], node1);
                    node = node1;
                } else {
                    node = nodeMap.get(arr[i]);
                }
            }
            node.flag = 1;
        }

        public boolean search(String word) {
            char[] arr = word.toCharArray();
            int n = arr.length;
            Trie node = this;

            for (int i = 0; i < n; i++) {
                HashMap<Character, Trie> nodeMap = node.map;
                if (!nodeMap.containsKey(arr[i])) {
                    return false;
                } else {
                    node = nodeMap.get(arr[i]);
                }
            }
            return node.flag == 1;
        }

        public boolean isPrefix(String prefix) {
            char[] arr = prefix.toCharArray();
            int n = arr.length;
            Trie node = this;

            for (int i = 0; i < n; i++) {
                HashMap<Character, Trie> nodeMap = node.map;
                if (!nodeMap.containsKey(arr[i])) return false;
                else {
                    node = nodeMap.get(arr[i]);
                }
            }
            return true;
        }
    }

    public static String longestWord(String[] words) {
        int n = words.length;
        Trie tree = new Trie();
        for (int i = 0; i < n; i++) {
            tree.insert(words[i]);
        }

        HashMap<Integer, List<String>> map = new HashMap<>();
        int maxLengh = 0;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            boolean search = false;
            for (int j = 0; i < m; j++) {
                String sub = word.substring(0, j + 1);
                search = tree.search(sub);
                if (!search) break;
            }
            if (search) {
                if (m >= maxLengh) {
                    if (map.containsKey(m)) {
                        map.get(m).add(word);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(word);
                        map.put(m,list);
                    }
                    maxLengh=m;
                }
            }
        }

        List<String> maxList = map.get(maxLengh);
        String res=maxList.get(0);
        for (String s : maxList) {
            if(s.compareTo(res)>0) res=s;
        }

        return maxLengh == 0 ? null : res;
    }
}
