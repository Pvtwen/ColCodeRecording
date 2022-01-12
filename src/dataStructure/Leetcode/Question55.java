package dataStructure.Leetcode;

/**
 * @author 86153
 * @data 2021/8/18 15:17
 * 动态规划
 */
public class Question55 {
//    public boolean canJump(int[] nums) {
//        // 能否到达某一个元素取决于上一个元素的值  t为到达下一个不为0的元素所需要的最小跨距
//        int i=nums.length-1,t=1;
//        // 一直循环到下标为0的元素为止
//        while(i-1>=0){
//            // 只要该元素的值大于等于最小跨距  将最小跨距置为1
//            if(nums[i-1]>=t) t=1;
//            // 只要小于最小跨距 跨距+1
//            else t++;
//            i--;
//        }
//        // 只要下标为0的元素大于等于最小跨距 则跳跃成功
//        return t==1;
//    }

//    public boolean canJump(int[] nums) {
//    int rightmost=0;
//    for(int i=0;i<nums.length;i++){
//        if(i<=rightmost){
//            rightmost= Math.max(rightmost, (i + nums[i]));
//            if(rightmost>=nums.length-1) return true;
//        }
//    }
//    return false;
//}

    // 递归
//    boolean[] visited;
//
//    public boolean canJump(int[] nums) {
//        if (nums.length == 1) return true;
//
//        visited = new boolean[nums.length];
//        return getMost(nums, 0, nums[0]);
//    }
//
//    public boolean getMost(int[] nums, int i, int max) {
//        if (max >= nums.length - 1) return true;
//        for (int j = i + 1; j <= max; j++) {
//            if (!visited[j]) {
//                visited[j] = true;
//                if (getMost(nums, j, j + nums[j])) return true;
//            }
//        }
//        return false;
//    }

    // 递归求最大路径
    static boolean[] visited;

    public static int canJump(int[] nums) {
        visited = new boolean[nums.length];
        return getMost(nums, 0, nums[0]);
    }

    public static int getMost(int[] nums, int i, int max2) {
        int maxLength=Math.min(max2,nums.length-1);
        for (int j = i + 1; j <=maxLength; j++) {
            if (!visited[j]) {
                visited[j] = true;
                int max1 = getMost(nums, j, j + nums[j]);
                max2 = Math.max(max1, max2);
            }
        }
        return max2;
    }
}