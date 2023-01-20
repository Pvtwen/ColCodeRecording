package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/3 9:25
 */
public class KY6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            solution(s);
        }
    }
    public static void solution(String s){
        int n = s.length();
        int cur=-1;
        int ret=0;
        char c1 = s.charAt(0);
        int i1 = (c1 - 'a')/3;
        int i3 = (c1 - 'a') % 3+1;
        cur=i1;
        ret+=i3;
        for(int i=1;i<n;i++){
            char c = s.charAt(i);
            int i2 = (c - 'a') / 3;
            int i4 = (c - 'a') % 3 + 1;
            // 位于同一个键上
            if(cur==i2){
                ret+=2;
                ret+=i4;
            }else{
                ret+=i4;
                cur=i2;
            }
        }
        System.out.println(ret);
    }
}
