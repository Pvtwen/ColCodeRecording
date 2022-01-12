package dataStructure.Leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yawen Cao
 * @data 2021/12/3 9:36
 */
public class Question1005 {
    // 2. 优化优先队列
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 采用计数数组 值域映射
        int[] cnt=new int[210];
        for (int num : nums) {
            cnt[num+100]++;
        }
        for(int i=-100;i<0 && k>0;i++){
            while(cnt[i+100]!=0 && k>0){
                cnt[i+100]--;cnt[-i+100]++;
                k--;
            }
        }
        if (cnt[100] == 0 && k > 0 && k % 2 != 0) {
            int i=0;
            while (cnt[i + 100] == 0) {
                i++;
            }
            cnt[i+100]--;cnt[-i+100]++;
        }
        int sum=0;
        for(int i=0;i<cnt.length;i++){
            sum+=cnt[i]*(i-100);
        }
        return sum;
    }
    // 1. 优先队列
//    public int largestSumAfterKNegations(int[] nums, int k) {
//        // 存负数下标
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (nums[a] - nums[b]));
//        int minIdx = 0;
//        int length = nums.length;
//        boolean hasZero = false;
//        for (int i = 0; i < length; i++) {
//            if (nums[i] < 0) priorityQueue.offer(i);
//            if (nums[i] == 0) hasZero = true;
//            if (Math.abs(nums[i]) < Math.abs(nums[minIdx])) minIdx = i;
//        }
//        if (k <= priorityQueue.size()) {
//            while (!priorityQueue.isEmpty() && k>0) {
//                Integer peek = priorityQueue.peek();
//                nums[peek] = -nums[peek];
//                priorityQueue.poll();
//            }
//        } else {
//            while (!priorityQueue.isEmpty()) {
//                Integer peek = priorityQueue.peek();
//                nums[peek] = -nums[peek];
//                priorityQueue.poll();
//                k--;
//            }
//            if(!hasZero && k%2==1){
//                nums[minIdx] = -nums[minIdx];
//            }
//        }
//        int sum=0;
//        for(int i=0;i<nums.length;i++){
//            sum+=nums[i];
//        }
//        return sum;
//    }

//    public int largestSumAfterKNegations(int[] nums, int k) {
//        int length = nums.length;
//        Arrays.sort(nums);
//        int minusNum=0;
//        int minusMax=Integer.MIN_VALUE;
//        int positMin=Integer.MAX_VALUE;
//        boolean hasZero=false;
//        for(int i=0;i<length;i++){
//            if (nums[i] < 0) {
//                minusNum++;
//                minusMax = Math.max(minusMax, nums[i]);
//            } else if (nums[i] == 0) hasZero = true;
//            else{
//                positMin = nums[i];
//                break;
//            }
//        }
//        if(minusNum==0){
//            for(int i=1;i<=k;i++){
//                nums[0]=-nums[0];
//            }
//        }
//        // 负数的个数大于等于k
//        else if(k<=minusNum){
//            for(int i=0;i<k;i++){
//                nums[i]=-nums[i];
//            }
//        }else{
//            if(hasZero){
//                for(int i=0;i<minusNum;i++){
//                    nums[i]=-nums[i];
//                }
//            }else{
//                // 如果正数的最小值大于负数最大值的绝对值 全程只对负数进行操作
//                if(positMin>=-minusMax){
//                    for(int i=0;i<minusNum;i++,k--){
//                        nums[i]=-nums[i];
//                    }
//                    for(int i=1;i<=k;i++){
//                        nums[minusNum-1]=-nums[minusNum-1];
//                    }
//                }
//                // 如果
//                else if(positMin<-minusMax){
//                    for(int i=0;i<minusNum;i++,k--){
//                        nums[i]=-nums[i];
//                    }
//                    for(int i=1;i<=k;i++){
//                        nums[minusNum]=-nums[minusNum];
//                    }
//                }
//            }
//        }
//        int sum=0;
//        for(int i=0;i<length;i++){
//            sum+=nums[i];
//        }
//        return sum;
//    }
}
