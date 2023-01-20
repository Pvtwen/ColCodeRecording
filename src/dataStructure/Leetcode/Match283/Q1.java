package dataStructure.Leetcode.Match283;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/3/6 10:31
 */
public class Q1 {
    public List<String> cellsInRange(String s) {
        String[] arr = s.split(":");
        String s1 = arr[0];
        String s2 = arr[1];
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        char r1 = s1.charAt(1);
        char r2 = s2.charAt(1);
        List<String> lists=new ArrayList<>();
        for(char col=c1;col<=c2;col++){
            for(char row=r1;row<=r2;row++){
                lists.add(col+""+row);
            }
        }
        return lists;
    }
}
