package dataStructure.Leetcode.Greedy;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2022/2/2 18:51
 */
public class Question1024 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        if(clips[0][0]>0){
            return -1;
        }
        int ret=1;
        int start=0;
        int end=0;
        for(int i=0;i<clips.length;){
            if(clips[i][0]>start) {
                break;
            }
            while(i<clips.length){
                int a = clips[i][0];
                int b = clips[i][1];
                if(a<=start) {
                    end = Math.max(end, b);
                    i++;
                }else{
                    start=end;
                    ret++;
                    break;
                }
                // 当前轮次找到 否则又要轮到下一轮次的ret++
                if(end>=time) break;
            }
//            if(end>=time) break;
        }
        if(end>=time){
            return ret;
        }else return -1;
    }
}
