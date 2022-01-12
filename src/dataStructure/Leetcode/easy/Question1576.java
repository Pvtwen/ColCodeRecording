package dataStructure.Leetcode.easy;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/1/5 9:37
 */
public class Question1576 {
    public String modifyString(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        for(int i=0;i<length;i++){
            char c = chars[i];
            if(c=='?'){
                // head tail
                if(i==0){
                    char b = chars[i + 1];
                    c='a';
                    while(c==b){
                        c++;
                    }
                    chars[i]=c;
                }
                else if(i==length-1){
                    char b=chars[i-1];
                    c='a';
                    while(c==b){
                        c++;
                    }
                    chars[i]=c;
                }else{
                    char b = chars[i - 1];
                    char a = chars[i + 1];
                    c='a';
                    while(c==b || c==a){
                        c++;
                    }
                    chars[i]=c;
                }
            }
        }
        String ret="";
        for (char c : chars) {
            ret+=c;
        }
        return ret;
    }
}
