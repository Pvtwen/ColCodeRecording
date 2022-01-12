package dataStructure.Leetcode.Match275;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/9 10:49
 */
public class Question5978 {
    public int wordCount(String[] startWords, String[] targetWords) {
        Map<Integer,Integer> map=new HashMap<>();
        for (String s : targetWords) {
            int c = transform(s);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int ret=0;
        for (String s : startWords) {
            int transform = transform(s);
            for(int i=0;i<26;i++){
                int i1 = transform & (1 << i);
                if(i1==0){
                    int i2 = transform | (1 << i);
                    if(map.containsKey(i2)){
                        ret+=map.get(i2);
                        map.remove(i2);
                    }
                }
            }
        }
        return ret;
    }

    public int transform(String s){
        int idx=0;
        int base=0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            base|=(1<<(c-'a'));
            idx++;
        }
        return base;
    }
        //    public int wordCount(String[] startWords, String[] targetWords) {
//        Set<String> set=new HashSet<>();
//        int length = startWords.length;
//        for (String s : startWords) {
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//            String s1=new String(chars);
//            set.add(s1);
//        }
//        int ret=0;
//        for (String s : targetWords) {
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//            int flag=-1;
//            for(int i=0;i<chars.length;i++){
//                String ns=new String(chars,0,i)+new String(chars,i+1,chars.length-i-1);
//                if(set.contains(ns)){
//                    flag=1;
//                    break;
//                }
//            }
//            if(flag==1) ret++;
//        }
//        return ret;
//    }

//    public int wordCount(String[] startWords, String[] targetWords) {
//        int n = startWords.length;
//        int[][] arr=new int[n][30];
//        int idx=0;
//        for (String s : startWords) {
//            int m = s.length();
//            for(int i=0;i<m;i++){
//                char c = s.charAt(i);
//                int i1 = c - 'a';
//                arr[idx][i1]++;
//            }
//            idx++;
//        }
//
//        int m = targetWords.length;
//        int[][] arr1=new int[m][30];
//        idx=0;
//        for (String s : targetWords) {
//            int length = s.length();
//            for(int i=0;i<length;i++){
//                char c = s.charAt(i);
//                int i1 = c - 'a';
//                arr1[idx][i1]++;
//            }
//            idx++;
//        }
//        // 1. 如果比arr某个 存在的 字母的个数多 不行
//        // 2. 如果比arr某个字母少 不行
//        // 3. 如果比arr某个不存在的字母多两个及以上 不行
//        // 4. 如果比arr某个不存在的字母多一个的字母 有两个及以上 不行
//        int ret=0;
//        for(int i=0;i<m;i++){
//            int flag=-1;
//            for(int j=0;j<n;j++){
//                int l1 = startWords[j].length();
//                int l2 = targetWords[i].length();
//                if(l2<=l1) continue;
//                if(l2-l1>1) continue;
//                int ok=1;
//                int num=0;
//                for (char c : targetWords[i].toCharArray()) {
//                    int i1 = c - 'a';
//                    if(arr[j][i1]==arr1[i][i1]) continue;
//                    if(arr[j][i1]>arr1[i][i1]){
//                        ok=-1;
//                        break;
//                    }
//                    if(arr[j][i1]<arr1[i][i1]) num++;
//                    if(num>1){
//                        ok=-1;
//                        break;
//                    }
//                }
//                if(ok==1) {
//                    flag=1;
//                    break;
//                }
//            }
//            if(flag==1) ret++;
//        }
//        return ret;
//    }
}
