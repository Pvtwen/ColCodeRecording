package dataStructure.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yawen Cao
 * @data 2021/10/30 9:46
 */
public class Question260 {
    public static int[] singleNumber(int[] nums) {
//        HashMap<Integer,Integer> map=new HashMap<>();
//        int length=nums.length;
//
//        for (int num : nums) {
//            map.put(num,map.getOrDefault(num,0)+1);
//        }
//
//        int[] res=new int[2];
//        int t=0;
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
//            Integer value = integerIntegerEntry.getValue();
//            if(value==1){
//                res[t]=integerIntegerEntry.getKey();
//                t++;
//            }
//        }
//        return res;

//        Arrays.sort(nums);
//        int[] res=new int[2];
//        int length=nums.length;
//        int i=0;
//        int t=0;
//        while(i<length){
//            if(i+1==length){
//                res[t]=nums[i];
//                t++;
//                i++;
//            }else if(nums[i]==nums[i+1]){
//                i+=2;
//            }else{
//                res[t]=nums[i];
//                i+=1;
//                t++;
//            }
//        }
//        return res;

        // 位运算
        int bit=0;
        for (int num : nums) {
            bit=bit^num;
        }
        //得到最低位的1
        int lowBit=bit&-bit;
        int idx=0;
        int b = (lowBit >> idx) & 1;
        while (b!=1){
            idx++;
            b=(lowBit>>idx)&1;
        }

        int zeroSort=0;
        int oneSort=0;
        for (int num : nums) {
            int bi = (num >> idx) & 1;
            if(bi==0) zeroSort=zeroSort^num;
            else oneSort=oneSort^num;
        }
        int[] res=new int[2];
        res[0]=zeroSort;
        res[1]=oneSort;
        return res;
    }

}
