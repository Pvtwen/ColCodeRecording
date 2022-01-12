package dataStructure.Leetcode.Match257;

/**
 * @author 86153
 * @data 2021/9/5 10:57
 */
public class Question5863 {
    static int count=0;
    public static int countQuadruplets(int[] nums) {
        dfs(nums,0,0,0);
        return count;
    }

    public static void dfs(int[] nums,int depth,int begin,int sum){
        if(depth==3){
            for(int i=begin;i<nums.length;i++){
                if(sum==nums[i]) {
                    count++;
                }
            }
            return;
        }
            for(int j=begin;j<nums.length-1;j++){
                sum+=nums[j];
                dfs(nums,depth+1,j+1,sum);
                sum-=nums[j];
            }
    }
}
