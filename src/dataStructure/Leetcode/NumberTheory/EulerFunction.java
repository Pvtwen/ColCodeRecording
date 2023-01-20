package dataStructure.Leetcode.NumberTheory;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/26 14:28
 * 欧拉函数
 */
public class EulerFunction {
    // 求一个数的欧拉函数
    // i<=sqrt(n).因为只需要找出n以内的合数 和埃氏筛原理一样
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        int ans=n;
//        // 分解质因数
//        for(int i=2;i<=Math.sqrt(n);i++){
//            if(n%i==0){
//                ans=ans*(i-1)/i;
//                while(n%i==0){
//                    n/=i;
//                }
//            }
//        }
//        if(n>1) ans=ans*(n-1)/n;
//        System.out.println(ans);
//    }

    // 求范围内的所有数的欧拉函数
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] phi=new int[n+1];
        // 是找所有的数的欧拉函数 所以这里i<=n ,类比埃氏筛，其中只需要筛出合数，剩下的就是素数，所以i<=sqrt(n).
        // 再进一步类比欧拉筛，因为需要找出所有的素数,所以i<=n.但是素数空间没必要开得很大,对于1e9的
        // 范围，只需要1e6+10即可（素数定理).但是isPrimes数组中开的大小应当和1e9等同。
        // 再进一步类比牛客网KY7题，因为题设要求找出的是因子的个数，所以利用欧拉筛时，i<=1e6.剩下的大质数+1即可
        for(int i=2;i<=n;i++){
            if(phi[i]==0){
                for(int j=i;j<=n;j+=i){
                    if(phi[j]==0){
                        phi[j]=j;
                    }
                    phi[j]=phi[j]*(i-1)/i;
                }
            }
        }
    }
}
