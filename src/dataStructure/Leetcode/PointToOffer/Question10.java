package dataStructure.Leetcode.PointToOffer;

/**
 * @author Yawen Cao
 * @data 2021/11/7 18:32
 */
public class Question10 {
    public int fib(int n) {
//        long[] dp=new long[n+1];
//        dp[0]=0;dp[1]=1;
//        for(int i=2;i<=n;i++){
//            dp[i]=dp[i-1]+dp[i-2];
//        }
        if(n==0) return 0;
        int mod= (int) (Math.pow(10,9)+7);
//        return (int) (dp[n]%mod);
        long q=0,p=1,r=0;
        for(int i=2;i<=n;i++){
            r=(q+p)%mod;
            q=p;
            p=r;
        }
        return (int) p;
    }
}
