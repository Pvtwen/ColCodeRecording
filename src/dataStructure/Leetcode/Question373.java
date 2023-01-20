package dataStructure.Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Yawen Cao
 * @data 2022/1/14 9:31
 */
public class Question373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]+o1[1]-o2[1]-o2[0];
            }
        });
        // 这里i<k j<k是防止MLE 因为最多只需要k*k次就可以选出前k个最小的和  不需要全部入队列  其次i<nums1.length是防止出现示例3的情况
        for(int i=0;i<k && i<nums1.length;i++){
            for(int j=0;j<k && j<nums2.length;j++){
                int[] arr={nums1[i],nums2[j]};
                queue.offer(arr);
            }
        }
        List<List<Integer>> ret=new ArrayList<>();
        while(!queue.isEmpty() && k>0){
            int[] arr = queue.poll();
            List<Integer> list=new ArrayList<>();
            list.add(arr[0]);
            list.add(arr[1]);
            ret.add(list);
        }
        return ret;
    }
}
