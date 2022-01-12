package dataStructure.Leetcode.Match273;

/**
 * @author Yawen Cao
 * @data 2021/12/26 10:31
 */
public class Question5963 {
    public static void main(String[] args) {
        isSameAfterReversals(1800);
    }
    public static boolean isSameAfterReversals(int num) {
        StringBuilder str=new StringBuilder();
        str.append(num);
        String string = str.reverse().toString();
        int length = string.length();
        int i=0;
        while(length>1 && i<length && string.charAt(i)=='0'){
            i++;
        }
        char[] chars = string.toCharArray();
        string=new String(chars,i,chars.length-i+1);
        StringBuilder str1=new StringBuilder();
        str1.append(string);
        String string1 = str1.reverse().toString();
        return Integer.parseInt(string1)==num;
    }
}
