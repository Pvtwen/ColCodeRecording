package dataStructure.Leetcode;

/**
 * @author 86153
 * @data 2021/8/19 10:16
 * 贪心
 */
public class Question45 {
    public int jump(int[] nums) {
        int max=0;
        int time=0;
        int temp=max;
        for(int j=0;j<nums.length-1;j++){
            temp=Math.max(temp,j+nums[j]);
            // 一旦能够到达最后一个元素 立即返回
            if(temp>=nums.length-1) return time+1;
            // 到达边界 进入下一次跳跃 max更新
            if(j==max){
                max=temp;
                time++;
            }
        }
        //  应对只有一个元素的情况
        return time;
    }
}
