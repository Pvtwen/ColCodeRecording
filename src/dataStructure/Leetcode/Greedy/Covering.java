package dataStructure.Leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2022/2/2 11:23
 */
public class Covering {
    // 给定区间的长度length
    public static void solution(int[][] arr,int length){
        // 左端点从小到大排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        // 设置一个变量来标记覆盖的区间 只存储右端点
        int b=arr[0][1];
        int ret=1;
        int temp=-1;
        int j;
        for(int i=1;i<arr.length;i=j-1){
            j=i+1;
            if(arr[j][0]>b) {
                System.out.println("区间不连续");
                return;
            }
            temp=arr[j][1];
            // 找最大值
            while(j<arr.length){
                int a1 = arr[j][0];
                int b1 = arr[j][1];
                if(a1<=b){
                    temp=Math.max(temp,b1);
                    j++;
                }else{
                    if(temp-arr[0][0]+1>=length){
                        ret++;
                        System.out.println("区间的个数为:"+ret);
                        return;
                    }
                    b=temp;
                    ret++;
                    break;
                }
            }
        }
        if(temp-arr[0][0]+1>=length){
            System.out.println("最小的区间个数为:"+ret);
        }else{
            System.out.println("长度不满足");
        }
    }
}
