package dataStructure.ACMSchoolMatch;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2021/12/20 11:27
 */
public class questionL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int idx = 0;
        int[] numberZero = new int[32];
        long sum=0;
        while(n>0){
            int i = sc.nextInt();
            int i1 = zeroNum(i);
            numberZero[i1]++;
            sum+=numberZero[i1]-1;
            idx++;
            n--;
        }
        // int型整数最多有三十多个零(二进制)
//        long sum=0;
//        for(int i=0;i<numberZero.length;i++){
//            sum+=numberZero[i]*(numberZero[i]-1)/2;
//        }
        System.out.println(sum);
    }
    // 求数字的末尾0的个数 二进制
    public static int zeroNum(int x){
        int num=0;
        while(x!=0){
            if ((x & 1) != 1) {
                x>>=1;
                num++;
            }else break;
        }
        return num;
    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr=new int[n];
//        // 空间换时间
//        int[][] newArr = new int[n * (n - 1) / 2][2];
//        int idx=0;
//        while (n>0){
//            arr[idx]=sc.nextInt();
//            n--;
//            idx++;
//        }
//        idx=0;
//        for(int i=0;i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                newArr[idx][0]=arr[i];
//                newArr[idx][1]=arr[j];
//                idx++;
//            }
//        }
//        int total=0;
//        for (int[] array : newArr) {
//            int i = array[0];
//            int j = array[1];
//            int right = i + j;
//            if(i>=j){
//                int gcd = gcd(2*i, 2*j);
//                if(right%gcd==0) total++;
//            }else{
//                int gcd = gcd(2 * j, 2 * i);
//                if(right%gcd==0) total++;
//            }
//        }
//        System.out.println(total);
//    }
//    // x>y
//    public static int gcd(long x,long y){
//        long rem=-1;
//        while(rem!=0){
//            rem=x%y;
//            x=y;
//            y=rem;
//        }
//        return (int) x;
//    }
}
