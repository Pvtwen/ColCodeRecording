package dataStructure.Leetcode.Match273;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/12/26 11:30
 */
public class Question5965 {
    HashMap<Integer,List<Integer>> map=new HashMap<>();
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
        long[] ret=new long[arr.length];
        for (Integer val : map.keySet()) {
            List<Integer> list = map.get(val);
            long[] prefix=new long[list.size()+1];
            long sum=0;
            for(int i=1;i<=list.size();i++){
                sum+=list.get(i-1);
                prefix[i]=sum;
            }
            sum=0;
            long[] suffix=new long[list.size()+2];
            for(int i=list.size();i>0;i--){
                sum+=list.get(i-1);
                suffix[i]=sum;
            }
            // 计算对应下标的前缀和
            for(int i=1;i<=list.size();i++){
                // 对应下标之后的和
                long back=suffix[i+1]-list.get(i-1)*(list.size()-i);
                // 对应下标之前的和
                long pre=prefix[i-1];
                // 分别相减 去绝对值
                long l1 = Math.abs(pre - list.get(i - 1) * (i - 1));
                // 在求和
                ret[list.get(i-1)]=back+l1;
            }
        }
        return ret;
    }
//    HashMap<Integer, List<Integer>> map=new HashMap<>();
//
//    public long[] getDistances(int[] arr) {
//        for(int i=0;i<arr.length;i++){
//            int i1 = arr[i];
//            List<Integer> list = map.getOrDefault(i1, new ArrayList<>());
//            list.add(i);
//            map.put(i1,list);
//        }
//        long[] ret= new long[arr.length];
//        for(int i=0;i<arr.length;i++){
//            List<Integer> list = map.get(arr[i]);
//            long subSum=0;
//            for (Integer integer : list) {
//                subSum+=Math.abs(integer-i);
//            }
//            ret[i]=subSum;
//        }
//        return ret;
//    }
}
