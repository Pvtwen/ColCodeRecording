package dataStructure.Leetcode;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/9/21 10:16
 *
 */
public class Question974 {
    // 一次求和
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int n=nums.length;
        int res=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int prefix=(sum%k+k)%k;
            res+=map.getOrDefault(prefix,0);
            map.put(prefix,map.getOrDefault(prefix,0)+1);

        }
        return res;
    }

    // 最后遍历哈希表

//    public int subarraysDivByK(int[] nums, int k) {
//        HashMap<Integer,Integer> map=new HashMap<>();
//        int n=nums.length;
//        int res=0;
//        int sum=0;
//        map.put(0,1);
//        for(int i=0;i<n;i++){
//            sum+=nums[i];
//            int prefix=(sum%k+k)%k;
//            map.put(prefix,map.getOrDefault(prefix,0)+1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int value=entry.getValue();
//            int s=(value*(value-1))/2;
//            res+=s;
//        }
//        return res;
//    }
}
