package dataStructure.Leetcode.Match62;

/**
 * @author Yawen Cao
 * @data 2021/10/2 22:56
 */
public class Question5872 {
    public int numOfPairs(String[] nums, String target) {
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((nums[i]+nums[j]).equals(target)) res++;
                if((nums[j]+nums[i]).equals(target)) res++;
            }
        }
        return res;
    }
}
