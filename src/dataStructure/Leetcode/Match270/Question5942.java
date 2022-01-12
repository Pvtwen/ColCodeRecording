package dataStructure.Leetcode.Match270;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/12/5 10:31
 */
public class Question5942 {
    public int[] findEvenNumbers(int[] digits) {
        int length = digits.length;
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                for(int k=0;k<length;k++){
                    if(j==i || j==k || i==k) continue;
                    else if(digits[i]==0) continue;
                    else if(digits[k]%2==1) continue;
                    else {
                        int res = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if(!set.contains(res)){
                            list.add(res);
                            set.add(res);
                        }
                    }
                }
            }
        }
        Collections.sort(list);
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++){
           res[i]=list.get(i);
        }
        return res;
    }
}
