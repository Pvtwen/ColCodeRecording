package dataStructure.Leetcode.Match261;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/10/3 10:44
 */
public class Questoin5891 {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m=rolls.length;
        int total=m+n;
        int[] res=new int[n];
        int i;
        int sum=0;
        for(int j=0;j<m;j++){
            sum+=rolls[j];
        }
        int totalN=total*mean-sum;

        if(totalN<n || totalN>6*n) return new int[]{};

        int base=totalN/n;
        int remain=totalN%n;
        for(i=0;i<n;i++){
            res[i]=base;
        }

        for(int j=0;j<remain;j++){
            res[j]+=1;
        }
        return res;
    }
}
