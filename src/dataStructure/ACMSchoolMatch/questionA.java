package dataStructure.ACMSchoolMatch;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2021/12/20 11:46
 */
public class questionA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        int[] arr=new int[i];
        int[] ret=new int[i];
        int idx=0;
        while(i>0){
            int i1 = sc.nextInt();
            arr[idx]=i1;
            idx++;
            i--;
        }
        idx=0;
        for (int i1 : arr) {
            if(isPrime(i1+1)){
                ret[idx]=i1+1;
            }else ret[idx]=-1;
            idx++;
        }
        for (int i1 : ret) {
            System.out.println(i1);
        }
    }
    public static boolean isPrime(int x){
        if(x==2) return true;
        if(x==1) return false;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0) return false;
        }
        return true;
    }
}
