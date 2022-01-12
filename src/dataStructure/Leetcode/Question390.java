package dataStructure.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/2 10:02
 */
public class Question390 {
    public int lastRemaining(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int cur=0;
        int direct=1;
        while(list.size()!=1){
            // 反向
            if(cur>list.size()-1) {
                cur=list.size()-1;
                direct=-direct;
            }
            if(cur<0){
                cur=0;
                direct=-direct;
            }
            list.remove(cur);
            if(direct==1){
                cur=cur+1;
            }else{
                cur=cur-2;
            }
        }
        return list.get(0);
    }
}
