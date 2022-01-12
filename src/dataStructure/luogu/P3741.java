package dataStructure.luogu;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/9 23:12
 */
public class P3741 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int i = sc.nextInt();
        String s = sc.next();
        solution(i,s);
    }
    public static void solution(int len,String s){
        // 统计vk的个数
        int ret=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i+1<len;i++){
            char c = s.charAt(i);
            char c1 = s.charAt(i + 1);
            if(c=='V' && c1=='K') {
                set.add(i);
                i++;
                ret++;
            }
        }
        // 找VV 和 KK
        int j=0;
        while(j+1<len){
            char c = s.charAt(j);
            if(set.contains(j)){
                j+=2;
                continue;
            }
            char c1 = s.charAt(j + 1);
            if(c=='V' && c1=='V' && !set.contains(j+1)){
                ret++;
                System.out.print(ret);
                return;
            }
            if(c=='K' && c1=='K'){
                ret++;
                System.out.print(ret);
                return;
            }
            j++;
        }
        System.out.print(ret);
    }
//    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        int i = sc.nextInt();
//        String s = sc.next();
//        solution(i,s);
//    }
//    public static void solution(int len,String s){
//        int ret=0;
//        String s1="";
//        for(int i=0;i<len;i++){
//            char c = s.charAt(i);
//            if(i+1<len){
//                char c1 = s.charAt(i + 1);
//                if(c=='V' && c1=='K'){
//                    i++;
//                    ret++;
//                    s1+='X';
//                }else{
//                    s1+=c;
//                }
//            }else{
//                s1+=c;
//            }
//        }
//        int j=0;
//        while(j+1<s1.length()){
//            char c = s1.charAt(j);
//            if(c=='X') {
//                j++;
//            }else{
//                char c1 = s1.charAt(j + 1);
//                if(c=='K' && c1=='K'){
//                    ret++;
//                    System.out.print(ret);
//                    return;
//                }
//                if(c=='V' && c1=='V'){
//                    ret++;
//                    System.out.print(ret);
//                    return;
//                }
//                j++;
//            }
//        }
//        System.out.print(ret);
//    }
}
