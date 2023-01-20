package dataStructure.Leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2022/2/2 10:03
 */
public class SelectPoint {
    public void solution(int[][] arr){
        // 右端点从小到大排序 左端点从大到小排序(前提是右端点一样)
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else {
                    return o2[0]-o2[1];
                }
            }
        });
        // 选首区间的右端点 b1
        int num=1;
        int r=arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(r>=arr[i][0]) {
                continue;
            }else{
                num++;
                r=arr[i][1];
            }
        }
        System.out.println(num);
    }
}
