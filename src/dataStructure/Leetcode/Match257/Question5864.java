package dataStructure.Leetcode.Match257;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 86153
 * @data 2021/9/5 11:47
 * 对于这种有两个维度的问题，一个常见的方法就是对其中一个维度进行排序
 */
public class Question5864 {
    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]) return o2[0]-o1[0];
                else return o1[1]-o2[1];
            }
        });
        int maxDef=properties[0][1],res=0;
        for(int i=1;i<properties.length;i++){
            if(maxDef<properties[i][1]) maxDef=properties[i][1];
            else if(maxDef>properties[i][1]) res++;
        }
        return res;
    }
}
