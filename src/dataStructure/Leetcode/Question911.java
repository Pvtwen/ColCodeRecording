package dataStructure.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/12/11 10:07
 */
public class Question911 {
    List<int[]> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] times;

    public Question911(int[] persons, int[] times) {
        int length = times.length;
        this.times = times;
        int val = 0;
        for (int i = 0; i < length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            Integer num = map.get(persons[i]);
            if (num >= val) {
                val = num;
                list.add(new int[]{times[i], persons[i]});
            }
        }
    }

    public int q(int t) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (l == r || l==r-1) break;
            else if (list.get(mid)[0] <= t) l = mid;
            else if (list.get(mid)[0] > t) r = mid - 1;
        }
        int idx;
        if(list.get(r)[0]<=t) idx=r;
        else idx=l;
        return list.get(idx)[1];
    }
//    int[] dp; // 对应每个时刻赢得候选人
//    int[] times;
//    HashMap<Integer,Integer> map=new HashMap<>(); //动态存储 每个候选人的票数
//    public Question911(int[] persons, int[] times) {
//        this.times=times;
//        int length = times.length;
//        dp=new int[length];
//        dp[0]=persons[0];
//        int maxNum=1;   // 当前最大票数
//        int maxCan = persons[0];  // 当前最大票数对应的候选人
//        map.put(persons[0],1);
//        for (int i = 1; i < length; i++) {
//            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
//            // 如果当前的票就是投给最大候选人
//            if(persons[i]==maxCan){
//                dp[i]=persons[i];
//                maxNum++;
//            }else{
//                Integer num = map.get(persons[i]);
//                if(num>=maxNum) {
//                    maxCan=persons[i];
//                    maxNum=num;
//                    dp[i]=persons[i];
//                }else{
//                    dp[i]=dp[i-1];
//                }
//            }
//        }
//    }

//    public int q(int t) {
//        int length = times.length;
        // 二分查找 查找第一个小于等于t的时刻
//        int l = 0, r = length - 1;
//        while (l <= r) {
//            int mid = (l + r) / 2;
//            if (l == r || l == r - 1) break;
//            else if (times[mid] <= t) l = mid;
//            else if (times[mid] > t) r = mid - 1;
//        }
//        int tim;
//        if (times[r] <= t) tim = r;
//        else tim = l;

//        int l=0,r=length-1;
//        while(l<=r){
//            int mid=(l+r)/2;
//            if(l==r || l==r-1) break;
//            else if(times[mid]>=t) l=mid;
//            else if(times[mid]<t) r=mid-1;
//        }
//        if(times[r]==t){
//            tim=r;
//        }else tim=l;
//        return dp[tim];
}
