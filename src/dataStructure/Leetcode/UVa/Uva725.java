package dataStructure.Leetcode.UVa;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/3 11:31
 */
public class Uva725 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        List<Integer> list=new ArrayList<>();
        while(i!=0){
            list.add(i);
            i = sc.nextInt();
        }
        Integer[] arr= new Integer[list.size()];
        arr = list.toArray(arr);
        //There are no solutions for 61.
        int idx=0;
        for (Integer sample : arr) {
            // 枚举分母 1~100000
            int flag=-1;
            for(int denome=1;denome<100000;denome++){
                // compute nomirator
                int nomirator=sample*denome;
                String[] same = isSame(nomirator, denome);
                if(same!=null){
                    flag=1;
                    //79546 / 01283 = 62
                    System.out.println(same[0]+" / "+same[1]+" = "+sample);
                }
            }
            if(flag==-1) {
                System.out.println("There are no solutions for "+sample+".");
            }
            System.out.println();
            idx++;
        }
    }
    public static String[] isSame(int i,int j){
        String s1=String.valueOf(i);
        String s2=String.valueOf(j);
        if(s1.length()+s2.length()>10)return null;
        // add prefix 0
        int len=s1.length();
        while(len<5){
            s1="0"+s1;
            len++;
        }
        len=s2.length();
        while(len<5){
            s2="0"+s2;
            len++;
        }
        // i:分子 j：分母
        Set<Character> set=new HashSet<>();
        Set<Character> set1=new HashSet<>();
        // 分母
        for(int k=0;k<s2.length();k++){
            char c = s2.charAt(k);
            if(set.contains(c)) return null;
            set.add(c);
        }
        for(int k=0;k<s1.length();k++){
            char c = s1.charAt(k);
            if(set1.contains(c)) return null;
            set1.add(c);
        }
        // iteration i
        for(int m=0;m<s1.length();m++){
            char c = s1.charAt(m);
            if(set.contains(c)) return null;
        }
        return new String[]{s1,s2};
    }
}
