package dataStructure.Leetcode.Match280;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/2/13 10:37
 */
public class Q2 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        // 奇数
        HashMap<Integer,Integer> even=new HashMap<>();
        for(int i=0;i<n;i+=2){
            even.put(nums[i],even.getOrDefault(nums[i],0)+1);
        }
        List<Integer> evenList=new ArrayList<>();
        for (Map.Entry<Integer, Integer> en : even.entrySet()) {
            evenList.add(en.getKey());
        }
        Collections.sort(evenList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return even.get(o2)-even.get(o1);
            }
        });
        if(evenList.size()==1){
            evenList.add(0);
            even.put(0,0);
        }

        // 偶数
        HashMap<Integer,Integer> odd=new HashMap<>();
        for(int i=1;i<n;i+=2){
            odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
        }
        List<Integer> oddList=new ArrayList<>();
        for (Map.Entry<Integer, Integer> en : odd.entrySet()) {
            oddList.add(en.getKey());
        }
        Collections.sort(oddList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return odd.get(o2)-odd.get(o1);
            }
        });
        if(oddList.size()==1) {
            oddList.add(0);
            odd.put(0,0);
        }

        if(!evenList.get(0).equals(oddList.get(0))){
            return n-even.get(evenList.get(0))-odd.get(oddList.get(0));
        }else{
            int oddNum=n/2;
            int evenNum=n-oddNum;
            evenList.set(0,evenNum-even.get(evenList.get(0)));
            evenList.set(1,evenNum-even.get(evenList.get(1)));
            oddList.set(0,oddNum-odd.get(oddList.get(0)));
            oddList.set(1,oddNum-odd.get(oddList.get(1)));
            return Math.min(evenList.get(0)+oddList.get(1),evenList.get(1)+oddList.get(0));
        }
    }
}
