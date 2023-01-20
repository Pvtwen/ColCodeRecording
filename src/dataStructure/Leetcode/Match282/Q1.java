package dataStructure.Leetcode.Match282;

/**
 * @author Yawen Cao
 * @data 2022/2/27 10:33
 */
public class Q1 {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int num=0;
        for (String word : words) {
            if(word.startsWith(pref)) num++;
        }
        return num;
    }
}
