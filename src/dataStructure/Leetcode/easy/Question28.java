package dataStructure.Leetcode.easy;

/**
 * @author 86153
 * @data 2021/8/2 21:33
 */
public class Question28 {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.startsWith(needle,i)){
                return i;
            }
        }
        return -1;
    }
}
