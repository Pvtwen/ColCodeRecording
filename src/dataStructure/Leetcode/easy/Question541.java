package dataStructure.Leetcode.easy;

/**
 * @author 86153
 * @data 2021/8/20 10:14
 */
public class Question541 {
    public static String reverseStr(String s, int k) {
        int remain;
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i+=2*k){
            StringBuilder stringBuilder=new StringBuilder();
            // 剩余字符
            remain=s.length()-i;
            if(remain>=2*k){
                stringBuilder.append(s.substring(i,i+k)).reverse().append(s.substring(i+k,i+2*k));
            }else if(remain>=k && remain<2*k){
                stringBuilder.append(s.substring(i,i+k)).reverse().append(s.substring(i+k));
            }else{
                stringBuilder.append(s.substring(i,s.length())).reverse();
            }
            result.append(stringBuilder);
        }
        return result.toString();
    }
}
