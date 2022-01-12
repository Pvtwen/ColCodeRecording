package dataStructure.Leetcode.Match;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/8/29 10:46
 */
public class Question5855 {
    public static String kthLargestNumber(String[] nums, int k) {
        BigDecimal[] copy=new BigDecimal[nums.length];
        for(int i=0;i<nums.length;i++){
            copy[i]=new BigDecimal(nums[i]);
        }
        Arrays.sort(copy);
        return String.valueOf(copy[nums.length-k]);
    }
}
