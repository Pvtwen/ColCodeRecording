package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/9 17:59
 */
public class KY26 {
    // 二进制的大数加法
    public static String adding(String s) {
        String ret="0";
        String base="1";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='1'){
                ret=add(ret,base);
            }
            base = add(base, base);
        }
//        System.out.println(ret);
        return ret;
    }
    // 两个数相加
    public static String add(String s1,String  s2){
        String ret="";
        int carry=0;
        int l1 = s1.length();
        int l2 = s2.length();
        int i=0;
        while(i<l1 && i<l2){
            int i1 = l1 - i - 1;
            int i2 = l2 - i - 1;
            char c = s1.charAt(i1);
            char c1 = s2.charAt(i2);
            int s = Integer.parseInt("" + c) + Integer.parseInt("" + c1) + carry;
            int rem = s % 10;
            ret=rem+""+ret;
            if(s>=10) carry=1;
            else carry=0;
            i++;
        }
        while(i<l1){
            char c = s1.charAt(l1-i-1);
            int i1 = Integer.parseInt(c + "");
            int i2 = i1 + carry;
            carry=0;
            ret=i2+""+ret;
            i++;
        }
        while(i<l2){
            char c = s2.charAt(l2-i-1);
            int i1 = Integer.parseInt(c + "");
            int i2 = i1 + carry;
            carry=0;
            ret=i2+""+ret;
            i++;
        }
        if(l1==l2 && carry==1) return "1"+ret;
        return ret;
    }
    // 大数除法
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        int base=0;
        String ret="";
        String bin="";
        while (!s.equals("0")) {
            base=0;
            ret="";
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                base=base*10+Integer.parseInt(""+c);
                if(i==0&& base<2){
                    continue;
                }
                int i1 = base / 2;
                ret+=i1;
                base-=(i1*2);
            }
            bin=base+""+bin;
            if(ret.equals("")){
                s="0";
            }
            else s=ret;
        }
        // 得到了十进制数的二进制
        String adding = adding(bin);
        System.out.println(adding);
    }
}
