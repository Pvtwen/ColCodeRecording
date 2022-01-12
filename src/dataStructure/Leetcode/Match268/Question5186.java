package dataStructure.Leetcode.Match268;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * @author Yawen Cao
 * @data 2021/11/21 11:16
 */
public class Question5186 {
    // 哈希表+二分查找
    HashMap<Integer, List<Integer>> map=new HashMap<>();
    int length;
    int[] arr;
    public Question5186(int[] arr) {
        this.arr=arr;
        int length = arr.length;
        this.length=length;
        for(int i=0;i<length;i++){
            if(!map.containsKey(arr[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i],list);
            }else{
                List<Integer> list = map.get(arr[i]);
                list.add(i);
            }
        }
    }

    public int query(int left, int right, int value) {
        // 两次二分
        if(!map.containsKey(value)) return 0;
        List<Integer> list = map.get(value);
        if(left>list.get(list.size()-1)) return 0;
        if(right<list.get(0)) return 0;
        int size = list.size();
        // 第一次二分找第一次出现的下标
        int l=0,r=size-1;
        int leftIdx=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(l==r) break;
            else if(list.get(mid)<left) l=mid+1;
            else if(list.get(mid)>=left) r=mid;
        }
        leftIdx=l;
        l=0;r=size-1;
        int rightIdx=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(l==r || l+1==r) break;
            else if(list.get(mid)<=right) l=mid;
            else if(list.get(mid)>right) r=mid-1;
        }
        if(list.get(r)<=right) rightIdx=r;
        else rightIdx=l;
        return (rightIdx-leftIdx+1);
    }
//    int[] arr;
//    HashMap<Map.Entry<Integer,Integer>,Integer> map;
//    public Question5186(int[] arr) {
//        this.arr=arr;
//        int length = arr.length;
//        map=new HashMap<>();
//        Map.Entry<Integer, Integer> entry = Map.entry(0, arr[0]);
//        map.put(entry,1);
//        for(int i=1;i<length;i++){
//            int flag=-1;
//            Map.Entry<Integer, Integer> entry1 = Map.entry(i, arr[i]);
//            map.put(entry1,1);
//            for(int j=i-1;j>=0;j--){
//                if(arr[j]==arr[i]){
//                    if(flag==-1){
//                        flag=1;
//                        Map.Entry<Integer, Integer> entry2 = Map.entry(j, arr[i]);
//                        Integer total = map.get(entry2);
//                        Map.Entry<Integer, Integer> entry3 = Map.entry(i, arr[i]);
//                        map.put(entry3,total+1);
//                    }
//                }else{
//                    Map.Entry<Integer, Integer> entry2 = Map.entry(j, arr[j]);
//                    if(!map.containsKey(entry2)){
//                        Integer integer = map.get(entry2);
//                        Map.Entry<Integer, Integer> entry3 = Map.entry(i, arr[j]);
//                        map.put(entry3,integer);
//                    }
//                }
//            }
//        }
//        int length = arr.length;
//        int value= (int) Math.pow(10,4);
//        dp=new int[length][value+1];
//        dp[0][arr[0]]=1;
//        for(int i=1;i<length;i++){
//            int flag=-1;
//            dp[i][arr[i]]=1;
//            for(int j=i-1;j>=0;j--){
//                if(arr[j]==arr[i]){
//                    if(flag!=1){
//                        flag=1;
//                        dp[i][arr[j]]=dp[j][arr[j]]+1;
//                    }
//                }else{
//                    if(dp[i][arr[j]]!=0) dp[i][arr[j]]=dp[j][arr[j]];
//                }
//            }
//        }
//    }

//    public int query(int left, int right, int value) {
//        if(left==0){
//            Map.Entry<Integer, Integer> entry = Map.entry(right, value);
//            if(!map.containsKey(entry)) return 0;
//            Integer integer = map.get(entry);
//            return integer;
//        }
//        Map.Entry<Integer, Integer> entry = Map.entry(right, value);
//        Map.Entry<Integer, Integer> entry1 = Map.entry(left - 1, value);
//        Integer integer=0;
//        Integer integer1=0;
//        if(map.containsKey(entry)) integer = map.get(entry);
//        if(map.containsKey(entry1)) integer1 = map.get(entry1);
//        return integer-integer1;
//    }
}
