package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/8 18:27
 */
public class KY24 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String next = sc.next();
            int i = Integer.parseInt(next);
            for(int k=i-1;k>=2;k--){
                String s2=""+k;
                next = solution(next, s2);
            }
            System.out.println(next);
        }
    }
    public static String solution(String s1,String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int[] res=new int[l1+l2];
        int[] ret=new int[l1+l2];
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                int i1 = l1 - i - 1;
                int i2 = l2 - j - 1;
                int i3 = i+j;
                char c = s1.charAt(i1);
                char c1 = s2.charAt(i2);
                int i4 = Integer.parseInt("" + c);
                int i5 = Integer.parseInt("" + c1);
                ret[i3]+=i4*i5;
                if(i==l1-1 || j==0 ){
                    res[i3]=ret[i3]%10;
                    if(ret[i3]/10!=0){
                        ret[i3+1]+=ret[i3]/10;
                        if(i==l1-1 && j==l2-1){
                            res[i3+1]=ret[i3+1];
                        }
                    }
                }
            }
        }
        int len;
        int re = res[l1 + l2 - 1];
        if(re==0) len=l1+l2-2;
        else len=l1+l2-1;
        String s="";
        for(int i=len;i>=0;i--){
            s+=res[i];
        }
        return s;
    }
}
