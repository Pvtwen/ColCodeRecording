package dataStructure.Leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/10/23 11:12
 */
public class Question492 {
    public int[] constructRectangle(int area) {
        int[] res=new int[2];
        res[0]=area;
        res[1]=1;
        for(int i=2;i<area/i;i++){
            if(area%i==0){
                if(area/i-i<res[0]-res[1]){
                    res[1]=i;
                    res[0]=area/i;
                }
            }
        }
        return res;
    }
}
