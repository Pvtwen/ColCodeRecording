package dataStructure.ACMSchoolMatch;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2021/12/20 19:45
 */
public class question1007 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        int idx=0;
        while(n>0){
            arrA[idx]=sc.nextInt();
            idx++;
            n--;
        }
        int m = sc.nextInt();
        int[] arrB=new int[m];
        idx=0;
        while(m>0){
            arrB[idx]=sc.nextInt();
            idx++;
            m--;
        }
        n=arrA.length;
        int[] gcd = new int[n * (n - 1) / 2];
        idx=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arrA[i]>=arrA[j]){
                    int gcd1 = gcd(arrA[i], arrA[j]);
                    gcd[idx]=gcd1;
                    idx++;
                }else{
                    int gcd1=gcd(arrA[j],arrA[i]);
                    gcd[idx]=gcd1;
                    idx++;
                }
            }
        }
        for (int i : arrB) {
            int flag=-1;
            for (int k = 0; k < gcd.length; k++) {
                if (i % gcd[k] == 0) {
                    flag=1;
                    break;
                }
            }
            if(flag==-1){
                System.out.println("Oh No");
                return;
            }
        }
        System.out.println("I got it");
    }
    public static int gcd(int x,int y){
        int rem=-1;
        while(rem!=0){
            rem = x % y;
            x=y;
            y=rem;
        }
        return x;
    }
}
