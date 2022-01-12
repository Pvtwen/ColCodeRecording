package dataStructure.Leetcode.Match274;

/**
 * @author Yawen Cao
 * @data 2022/1/2 10:30
 */
public class Question5967 {
    public boolean checkString(String s) {
        int length = s.length();
        int flag=1;
        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            if(c=='a' && flag==1)continue;
            else if(c=='a' && flag==-1){
                return false;
            }else if(c=='b') flag=-1;
        }
        return true;
    }
}
