package dataStructure.Leetcode.NumberTheory;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/24 17:54
 */
public class ACMQL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        int idx=0;
        while(idx<n){
            arr[idx]=sc.nextInt();
            idx++;
        }
        solution(arr);
    }
    public static void solution(int[] arr){
        HashMap<Integer,Long> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int i1 = arr[i];
            int num=0;
            while(i1!=0){
                int bit = i1 & 1;
                if(bit==1) break;
                else num++;
                i1>>=1;
            }
            map.put(num,map.getOrDefault(num,0L)+1);
        }
        long ret=0;
        for (Integer key : map.keySet()) {
            Long integer = map.get(key);
            long i = integer * (integer - 1) / 2;
            ret+=i;
        }
        System.out.println(ret);
    }
//    public static void solution(int[] arr){
//        int num=0;
//        for(int i=0;i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                int gcd = gcd(arr[i], arr[j]);
//                if((arr[i]/gcd+arr[j]/gcd)%2==0) num++;
//            }
//        }
//        System.out.println(num);
//    }
//    public static int gcd(int x,int y){
//        while(y!=0){
//            int temp=x;
//            x=y;
//            y=temp%y;
//        }
//        return x;
//    }
}
