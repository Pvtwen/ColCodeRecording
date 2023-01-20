package dataStructure.Leetcode.Match276;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/16 10:30
 */
public class Question5980 {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int rem = n % k;
        int div = n / k;
        String[] ret;
        if(rem==0){
            ret=new String[div];
        }else{
            ret=new String[div+1];
        }
        int m=0;
        if(rem==0){
            String s1=new String();
            int idx=0;
            for(int i=0;i<n;i++){
                char c = s.charAt(i);
                idx++;
                s1+=c;
                if(idx==k){
                    idx=0;
                    ret[m]=s1;
                    m++;
                    s1=new String();
                }
            }
        }else{
            String s1=new String();
            int idx=0;
            for(int i=0;i<div*k;i++){
                char c = s.charAt(i);
                idx++;
                s1+=c;
                if(idx==k){
                    idx=0;
                    ret[m]=s1;
                    m++;
                    s1=new String();
                }
            }
            //剩下 n-div*n
            String s2=new String();
            for(int i=div*k;i<n;i++){
                s2+=s.charAt(i);
            }
            for(int j=1;j<=k-n+div*k;j++){
                s2+=fill;
            }
            ret[m]=s2;
        }
        return ret;
}
}
