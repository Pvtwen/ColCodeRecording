package dataStructure.Leetcode;

import java.util.Stack;

/**
 * @author Yawen Cao
 * @data 2021/12/5 9:59
 */
public class Question372 {
    static int MOD = 1337;

    public static int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    public static int dfs(int a, int[] b, int u) {
        if (u == -1) return 1;
        return pow(a, b[u]) * pow(dfs(a, b, u - 1), 10) % MOD;
    }

    // 快速幂运算 真实模拟内存栈版
//    public static int pow(int a,int b){
//        Stack<Long> stack=new Stack<>();
//        while (b != 0) {
//            //b为偶数
//            if (b % 2 == 0) {
//                stack.push(1L);
//                b>>=1;
//            }
//            else if(b%2==1){
//                stack.push(a*1L%MOD);
//                b-=1;
//            }
//        }
//        long base = 1;
//        while(!stack.isEmpty()){
//            Long pop = stack.pop();
//            if(pop==1){
//                base=base*base%MOD;
//            }else{
//                base=base*a%MOD;
//            }
//        }
//        return (int) base;
//    }

    // 快速幂运算 非递归版
    public static int pow(int a, int b) {
        // 利用了二进制 例如 7^10 ，10的二进制为(1010),7^(1010)=7^(10)*7^(1000)
        // 也就是说只有碰到了1才需要计算结果，其他时刻只管a*=a就行了
        if (b == 0) return 1;
        a = a % MOD;
        int ans = 1;
        while (b != 0) {
            // 奇数
            if ((b & 1) != 0) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }
    // 快速幂运算 递归版
    // 如果b为0 如果b为偶数 如果b为奇数  用long型 防止溢出
//    public static int pow(int a,int b){
//        if(b==0) return 1;
//        else if(b%2==0){
//            int i = b / 2;
//            long p = pow(a, i);
//            return (int) (p*p%MOD);
//        }
//        // 奇数
//        else{
//            long p = pow(a, b - 1);
//            return (int) (p*a%MOD);
//        }
//    }

    // 常规幂运算
//    public static int pow(int a, int b) {
//        int base = 1;
//        a%=MOD;
//        while(b!=0){
//            base=base*a%MOD;
//            b--;
//        }
//        System.out.println(base);
//        return base;
//    }

    // 采用二进制优化的快速幂,但是时间复杂度依然很高，甚至比不上纯递归
//    public static int pow(int a, int b) {
//        a%=MOD;
//        // 后面还需要用到a
//        int temp = a;
//        int base = 1;
//        int ret = 1;
//        while (b > base) {
//            ret =ret*temp%MOD;
//            temp=temp*temp%MOD;
//            b-=base;
//            base*=2;
//            System.out.println(temp);
//        }
//        // 剩下b指数
//        int pow = pow(a, b);
//        ret=ret*pow%MOD;
//        System.out.println(ret);
//        return ret;
//    }
}
