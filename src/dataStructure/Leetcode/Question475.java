package dataStructure.Leetcode;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/12/20 10:02
 * 跟acm校赛的路由器的问题一样
 *
 */
public class Question475 {
    public int findRadius(int[] houses, int[] heaters) {
        // 1. 排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        // 2. 找房子的最大值
        int maxLoc= (int) 1e9;
//        for (int heater : heaters) {
//            int i = Math.abs(heater - houses[houses.length - 1]);
//            int j = Math.abs(heater - houses[0]);
//            maxLoc=Math.max(maxLoc,Math.max(i,j));
//        }
        // 3. 划分二分区间
        int l=0,r=maxLoc;

        while(l<r){
            int mid=(l+r)/2;
            if(check(houses,heaters,mid)) r=mid;
            else l=mid+1;
        }
        return l;
    }

    // x: 此时判断的距离
    public boolean check(int[] houses, int[] heaters, int x) {
        int n = houses.length;
        int m = heaters.length;
        for (int i = 0, j = 0;i<n && j<m ;i++){
            while(j<m && heaters[j]+x<houses[i]) j++;
            if(heaters[j]+x>=houses[i] && heaters[j]-x<=houses[i]) continue;
            return false;
        }
        return true;
    }
}
