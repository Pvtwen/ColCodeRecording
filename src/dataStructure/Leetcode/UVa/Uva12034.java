package dataStructure.Leetcode.UVa;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/28 15:46
 */
public class Uva12034 {
    static int MOD=10056;
    //
    static int[][] C=new int[1001][1001];
    static int[] f=new int[1001];
//    public static void init(){
//        for(int i=1;i<=1000;i++){
//            C[i][0]=C[i][i]=1;
//            for(int j=1;j<i;j++){
//                C[i][j]=(C[i-1][j-1]+C[i-1][j])%MOD;
//            }
//        }
//    }
    public static void init(){
        C[0][0]=1;
        for(int i=1;i<=1000;i++){
//            C[i][1]=1;
            for(int j=1;j<=i;j++){
                C[i][j]=(((C[i-1][j-1]+C[i-1][j])%MOD)*j)%MOD;
                f[i]=(f[i]+C[i][j])%MOD;
            }
        }
    }
    // 思路2：n-1个人，可能形成[1,n-1]范围的名次.
    public static void main(String[] args) {
        init();
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int idx=1;
        while(n>0){
//            int sum=0;
//            for(int i=1;i<=n;i++){
//                sum=(sum+C[n][i])%MOD;
//            }
            int i = sc.nextInt();
            System.out.println("Case "+idx+": "+f[i]);
            idx++;
            n--;
        }
    }

    // 思路1：有n个人，先确定名词最前面的人有C(n,i)种方法，之后有f(n-i)种方法。
    // 总的方法就是 SUM(C(n,i)*f(n-i))
//    public static void main(String[] args) {
//        init();
//       // System.out.println("init out");
//        f[0]=f[1]=1;
//        for(int i=2;i<=1000;i++){
//            int sum=0;
//            for(int j=1;j<=i;j++){
//                sum=(sum+C[i][j]*f[i-j])%MOD;
//            }
//            f[i]=sum%MOD;
//        }
//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        int idx=0;
//        while(n>0){
//            int i = sc.nextInt();
//            System.out.println("Case "+ (idx+1)+": "+f[i]);
//            n--;
//            idx++;
//        }
//    }
}
