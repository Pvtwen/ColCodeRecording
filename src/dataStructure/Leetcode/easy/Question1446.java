package dataStructure.Leetcode.easy;

/**
 * @author Yawen Cao
 * @data 2021/12/1 16:07
 */
public class Question1446 {
    public int maxPower(String s) {
        int i=0,j=1,maxLength=1;
        int length = s.length();
        int len=1;
        while(j<length && i<=j){
            char c = s.charAt(i);
            char c1 = s.charAt(j);
            if(c==c1){
                len++;
                j++;
                if(len>maxLength) maxLength=len;
            }else{
                i=j;
                j++;
                len=0;
            }
        }
        return maxLength;
    }
}
