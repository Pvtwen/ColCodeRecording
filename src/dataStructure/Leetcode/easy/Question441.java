package dataStructure.Leetcode.easy;

/**
 * @author Yawen Cao
 * @data 2021/10/10 16:08
 */
public class Question441 {
    public static int arrangeCoins(int n) {
        long l=1,r=n;
        while(l<=r){
            long mid=(long)((l+r)>>1);
            long sum=mid*(mid+1)/2;
            if(sum==n) return (int)mid;
            else if(sum>n) r=mid-1;
            else l=mid+1;
        }
        return (int)r;
    }
}
