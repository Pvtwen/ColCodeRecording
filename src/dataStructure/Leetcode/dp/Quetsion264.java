package dataStructure.Leetcode.dp;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/13 11:18
 */
public class Quetsion264 {
//    public static int nthUglyNumber(int n) {
//        int[] dp=new int[n+1];
//        dp[1]=1;
//        int p2=1,p3=1,p5=1;
//        for(int i=2;i<=n;i++){
//            int num1=p2*2,num2=p3*3,num3=p5*5;
//            int min = Math.min(Math.min(num1, num2), num3);
//            dp[i]=min;
//            // 2*3 3*2 会出现重复元素 三个if可以有效避免
//            if(min==num1){
//                p2++;
//            }
//            if(min==num2){
//                p3++;
//            }
//            if(min==num3){
//                p5++;
//            }
//        }
//        return dp[n];
//    }

    public int nthUglyNumber(int n) {
        int idx=0;
        Set<Long> set=new HashSet<>();
        PriorityQueue<Long> queue=new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return  (o1-o2)>0?1:-1;
            }
        });
        queue.offer((long)1);
        int ans=0;
        while(idx<n){
            long temp=queue.poll();
            ans= (int) temp;
            if(set.add(temp*2)){
                queue.offer(temp*2);
            }
            if(set.add(temp*3)){
                queue.offer(temp*3);
            }
            if(set.add(temp*5)){
                queue.offer(temp*5);
            }
            idx++;
        }
        return ans;
    }
}
