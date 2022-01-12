package dataStructure.Leetcode.Match262;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/10/10 10:37
 */
public class Question5894 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        Set<Integer> set3=new HashSet<>();
        Set<Integer> resSet=new HashSet<>();

        List<Integer> res=new ArrayList<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : nums3) {
            set3.add(i);
        }

        for (Integer integer : set1) {
            if(set2.contains(integer) || set3.contains(integer)){
                if(!resSet.contains(integer)) {
                    res.add(integer);
                    resSet.add(integer);
                }
            }
        }

        for (Integer integer : set2) {
            if(set3.contains(integer)){
                if(!resSet.contains(integer)){
                    res.add(integer);
                    resSet.add(integer);
                }
            }
        }
        return res;
    }
}
