package dataStructure.Leetcode.easy;

/**
 * @author 86153
 * @data 2021/8/7 9:47
 */
public class Question70 {
//    public static int climbStairs(int n) {
//        //最多可以分为多少个2
//        int num=n/2;
//        //之和
//        int sum=0;
//        //分子分母的基数 mul1:分子 mul2:分母
//        int mul1=1,mul2=1;
//        for(int i=1;i<=num;i++){
//            //组合 的 分母
//            int temp1=n-2*i+i;
//            int temp2=i;
//            for(int j=1;j<=i;j++){
//                mul1=mul1*temp1;
//                mul2=mul2*temp2;
//                temp1--;
//                temp2--;
//            }
//            sum+=mul1/mul2;
//            mul1=1;
//            mul2=1;
//        }
//        return sum+1;
//    }

    //动态规划
//    public static int climbStairs(int n) {
//        int q=0,p=0,sum=1;
//        for(int i=1;i<=n;i++){
//            q=p;
//            p=sum;
//            sum=p+q;
//        }
//        return sum;
//    }

    //递归
    public static int climbStairs(int n){
        if(n==0 || n==1){
            return 1;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
}