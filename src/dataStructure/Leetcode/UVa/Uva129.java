package dataStructure.Leetcode.UVa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/7 22:24
 */
public class Uva129 {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        while(n!=0 || L!=0){
            cnt=0;
            solution(n,L);
            n=sc.nextInt();
            L=sc.nextInt();
        }
    }
    public static void solution(int n,int L){
        List<Integer> list=new ArrayList<>();
        dfs(n,L,0,list);
    }
    public static int dfs(int n,int L,int cur,List<Integer> list){
        if(cnt==n){
            for(int i=0;i<list.size()-1;i++){
                Integer integer = list.get(i);
                char c1= (char) (integer+'A');
                if(i==63){
                    System.out.println(c1);
                }else if((i+1)%4==0){
                    System.out.print(c1+" ");
                }else{
                    System.out.print(c1);
                }
            }
            Integer integer = list.get(list.size() - 1);
            char c= (char) (integer+'A');
            System.out.println(c);
            System.out.println(cur);
            return 1;
        }
        cnt++;
        list.add(-1);
        for(int i=0;i<L;i++){
            List<Integer> copy=new ArrayList<>(list);
            copy.set(cur,i);
            int ok=1;
            for(int j=1;2*j<=cur+1;j++){
                int flag=-1;
                for(int k=0;k<j;k++){
                    Integer i1 = copy.get(cur - k);
                    Integer i2 = copy.get(cur - k - j);
                    if(!i1.equals(i2)){
                        flag=1;
                        break;
                    }
                }
                if(flag==-1){
                    ok=-1;
                    break;
                }
            }
            if(ok==1){
                int dfs = dfs(n, L, cur + 1, copy);
                if(dfs==1) return 1;
            }
        }
        return 0;
    }
//    public static int  dfs(int n, int L, int cur, List<Integer> list){
//        if(cnt==n){
//            // print
//            for(int i=0;i<list.size()-1;i++){
//                char c= (char) (list.get(i)+'A');
//                if(i==63) System.out.println(c);
//                else if((i+1)%4==0){
//                    System.out.print(c+" ");
//                }else{
//                    System.out.print(c);
//                }
//            }
//            char c1= (char) (list.get(list.size()-1)+'A');
//            System.out.println(c1);
//            System.out.println(cur);
//            return 1;
//        }
//        cnt++;
//        list.add(-1);
////        System.out.println("list size:"+list.size());
//        for(int i=0;i<L;i++){
//            List<Integer> copy=new ArrayList<>(list);
//            copy.set(cur,i);
//            int ok=1;
//            for(int j=1;2*j<=cur+1;j++){
//                int flag=-1;
//                for(int k=0;k<j;k++){
//                    Integer i1 = copy.get(cur - k);
//                    Integer i2 = copy.get(cur - k - j);
//                    if(!i1.equals(i2)){
//                        flag=1;
//                        break;
//                    }
//                }
//                if(flag==-1){
//                    ok=0;
//                    break;
//                }
//            }
//            if(ok==1){
//                int dfs = dfs(n, L, cur + 1, copy);
//                if(dfs==1) return 1;
//            }
//        }
//        return 0;
//    }
}
