package dataStructure.Leetcode.NiuKe;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/25 11:40
 */
public class KY7 {
    static int N=(int) (1e5+1);
    // 个人理解: 为什么可以是1e6+1，尽管没有囊括1e9以内的所有质数
    // 但是题设要我们找的不是所有的素数，而是找因子的个数
    // 解释：一个<=1e9的数字，不可能两个因子都大于1e6,那样的话就是1e6*1e6=1e12
    // 越界，所以1e6的范围可以将一个1e9的数字因式分解，如果最后n>1,就说明该因子就是
    // 它本身，ret++即可。
    //测试用例举例：799043235，分解因式3x5x5x29x1259x1459
//    static int N= (int) (1e6+1);

    static int[] primes=new int[N];
    static HashSet<Integer> set=new HashSet<>();
    static int[] st=new int[N];

    public static void main(String[] args) {
        int cnt=0;
        for(int i=2;i<N;i++){
//            if(!set.contains(i)) primes[cnt++]=i;
            if(st[i]==0) primes[cnt++]=i;
            for(int j=0;j<cnt;j++){
                if(i*primes[j]>=N) break;
//                set.add(i*primes[j]);
                st[i*primes[j]]=1;
                if(i%primes[j]==0) break;
            }
        }
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int ret=0;
        for(int i=0;i<cnt && primes[i]<=n;i++){
            while(n%primes[i]==0){
                System.out.println(primes[i]);
                ret++;
                n/=primes[i];
            }
        }
        // 有一种情况 质因子大于1e6+1 那本身就是质因子 还得+1
        if(n>1) ret++;
        System.out.println(ret);
    }
}
