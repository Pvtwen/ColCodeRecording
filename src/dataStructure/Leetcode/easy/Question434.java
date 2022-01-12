package dataStructure.Leetcode.easy;

/**
 * @author Yawen Cao
 * @data 2021/10/7 19:41
 */
public class Question434 {
    public int countSegments(String s) {
        int len=s.length();
        int res=0;
        int flag=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)!=' ' && flag!=1) {
                res++;
                flag=1;
            }else if(s.charAt(i)==' ') flag=0;
        }
        return res;
    }
}
