package dataStructure.Leetcode.easy;

/**
 * @author Yawen Cao
 * @data 2021/12/4 9:06
 */
public class Question383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alpha = new int[30];
        for (char c : magazine.toCharArray()) {
            int alp=c-97;
            alpha[alp]+=1;
        }
        for (char c : ransomNote.toCharArray()) {
            int alp=c-97;
            alpha[alp]-=1;
            if(alpha[alp]<0) return false;
        }
        return true;
    }
}
