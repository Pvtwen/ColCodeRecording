package dataStructure.Leetcode.easy;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/10/21 18:53
 */
public class Question66 {
    public static int[] plusOne(int[] digits) {
        int length=digits.length;
        int idx=length-1;
        return dfs(digits,idx);
    }
    public static int[]  dfs(int[] digits,int idx){
        if(idx==-1){
            int[] res=new int[digits.length+1];
            res[0]=1;
            return res;
        }
        int i = digits[idx] + 1;
        if(i==10) {
            digits[idx]=0;
            return dfs(digits,idx-1);
        }else{
            digits[idx]+=1;
            return digits;
        }
    }
}
