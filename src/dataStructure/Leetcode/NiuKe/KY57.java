package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/8 18:16
 */
public class KY57 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        int flag=1;
        int idx=0;
        while(idx<s.length()){
            char c = arr[idx];
            if(c=='\n' || c==' ' || c=='\t') flag=1;
            if(flag==1){
                if(c>='a' && c<='z'){
                    arr[idx]=Character.toUpperCase(c);
                    flag=0;
                }else if(c!='\n' && c!=' ' && c!='\t') flag=0;
            }
            idx++;
        }
        String s1 = new String(arr, 0, arr.length);
        System.out.println(s1);
    }
}
