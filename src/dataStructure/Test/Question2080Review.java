package dataStructure.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/12/2 15:31
 */
public class Question2080Review {
    HashMap<Integer, List<Integer>> map;
    public Question2080Review(int[] arr) {
        map=new HashMap<>();
        int length = arr.length;
        for(int i=0;i<length;i++){
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
    }

    public int query(int left, int right, int value) {
        if(!map.containsKey(value)) return 0;
        List<Integer> list = map.get(value);
        if(right<list.get(0)) return 0;
        if(left>list.get(list.size()-1)) return 0;
        // 查找第一个大于等于left的值
        int l=0,r=list.size()-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(l==r) break;
            if(list.get(mid)<left) l=mid+1;
            else if(list.get(mid)>=left) r=mid;
        }
        int leftIdx=l;
        l=0;r=list.size()-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(l==r || l==r-1) break;
            if(list.get(mid)<=right) l=mid;
            else if(list.get(mid)>right) r=mid-1;
        }
        int rightIdx=-1;
        if(list.get(r)<=right) rightIdx=r;
        else rightIdx=l;
        return rightIdx-leftIdx+1;
    }
}
