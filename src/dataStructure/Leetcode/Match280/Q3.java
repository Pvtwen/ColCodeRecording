package dataStructure.Leetcode.Match280;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/2/14 19:20
 */
public class Q3 {
    public long minimumRemoval(int[] beans) {
        int length = beans.length;
        Arrays.sort(beans);
        long[] prefix= new long[length + 1];
        long sum=0;
        for(int i=1;i<=length;i++){
            sum+=beans[i-1];
            prefix[i]=sum;
        }
        long min=Long.MAX_VALUE;
        for(int i=1;i<=length;i++){
            // 找连续相同的值
            int base=i;
            while(i+1<=length){
                if(beans[i-1]==beans[i]) i++;
                else break;
            }
            // 注意在可能越界的计算中转数据格式
            min=Math.min(min,prefix[base-1]+prefix[length]-prefix[i]-(long)beans[i-1]*(length-i));
        }
        return min;
    }

    // 优化思路 排序过后，数组下标为i的数字，其之后的数字都要保持与下标i一致，所以最大保留(n-i)*arr[i];
//    public long minimumRemoval(int[] beans) {
//        long sum=0;
//        long remain=0;
//        Arrays.sort(beans);
//        for(int i=0;i<beans.length;i++){
//            sum+=beans[i];
//            // 注意比较的两个对象 数据格式保持相似
//            remain=Math.max(remain, (long) (beans.length - i) * beans[i]);
//        }
//        return sum-remain;
//    }
}
