package dataStructure.Leetcode.easy;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Yawen Cao
 * @data 2021/12/2 9:34
 */
public class Question506 {
    public String[] findRelativeRanks(int[] score) {
        TreeSet<int[]> set=new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        int length = score.length;
        String[] res=new String[length];
        for(int i=0;i<length;i++){
            set.add(new int[]{score[i],i});
        }
        int count=0;
        for (int[] poll : set) {
            int i = poll[1];
            if(count==0){
                res[i]="Gold Medal";
            }
            else if(count==1){
                res[i]="Silver Medal";
            }
            else if(count==2){
                res[i]="Bronze Medal";
            }
            else{
                res[i]=""+(count+1)+"";
            }
            count++;
        }
        return res;
    }
}
