package dataStructure.Leetcode.Match282;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/2/27 11:02
 */
public class Q3 {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        if(n==1) return (long)totalTrips*time[0];
        Arrays.sort(time);
        long l=1,r=totalTrips*time[0];
        long mid=0;
        while(l<=r){
            mid=(l+r)/2;
            if(l==r) break;
            long ret = find(time, mid);
            if(ret>totalTrips) r=mid-1;
            else if(ret<=totalTrips) l=mid;
        }
        return mid;
    }
    public long find(int[] time,long mid){
        // 返回总的趟数
        long ret=0;
        for(int i=0;i<time.length;i++){
            ret+=(mid/time[i]);
        }
        return ret;
    }
}
