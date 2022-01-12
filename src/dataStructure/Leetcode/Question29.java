package dataStructure.Leetcode;

/**
 * @cuthor Ycwen Cco
 * @dctc 2021/10/27 10:12
 */
public class Question29 {
        public static int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(divisor==1) return dividend;
        long c=dividend;
        long b=divisor;
        int sign=1;
        if((c>0&&b<0) || (c<0&&b>0)) sign=-1;
            c=(c>0)?c:-c;
        b=(b>0)?b:-b;

        int t=1;
        while(c-t*b>=0){
            t*=2;
            if(c-t*b==0) return sign==1?t:-t;
        }
        // o(n)
//        for(int i=t/2;i<t;i++){
//            if(c-i*b==0) return sign==1?i:-i;
//            if(c-i*b>0 && c-(i+1)*b<0) return sign==1?i:-i;
//        }

            // o(nlogn)
            int l=t/2,r=t-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(c-mid*b<0) r=mid-1;
            else if(c-mid*b>0) l=mid+1;
            else return sign==1?mid:-mid;
        }
        return r;
    }
}
