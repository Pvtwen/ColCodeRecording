package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/11/13 18:58
 */
public class Question152 {
//    public int maxProduct(int[] nums) {
//        int length = nums.length;
//        int[][] dp=new int[length][length];
//        int res=Integer.MIN_VALUE;
//        for(int i=0;i<length;i++){
//            for(int j=i;j>=0;j--){
//                if(j==i){
//                    dp[i][i]=nums[i];
//                    res=Math.max(res,dp[i][i]);
//                    continue;
//                }
//                dp[j][i]=dp[j+1][i]*nums[j];
//                res=Math.max(dp[j][i],res);
//            }
//        }
//        return res;
//    }

    // 与337题打家劫舍思想类似 都是设置两个变量
    // 337题 维护两个哈希表 一个存储选择，另一个存储不选择   该题 维护两个数组 一个存储最大值 一个存储最小值
    // 总的说来就是涉及到状态改变时(要么是最大变最小，要么是不能选连续的元素）
    // 但是有的例题，例如一维数组的股票，也是涉及到状态改变，但是并没有维护两个变量，而是用一个二维数组去存储状态
    // 其实思想类似，只不过二维数组的第二维变量用0和1来表示罢了。与单独设置两个变量相同。
//    public int maxProduct(int[] nums) {
//        int length = nums.length;
//        int[] Min=new int[length];
//        int[] Max=new int[length];
//        int res=Integer.MIN_VALUE;
//        Max[0]=nums[0];
//        Min[0]=nums[0];
//        res=Max[0];
//        for(int i=1;i<length;i++){
//            if (nums[i] >= 0) {
//                Max[i]=Math.max(nums[i],nums[i]*Max[i-1]);
//                Min[i]=Math.min(Min[i],nums[i]*Min[i-1]);
//            }else{
//                Max[i]=Math.max(nums[i],Min[i-1]*nums[i]);
//                Min[i]=Math.min(nums[i],Max[i-1]*nums[i]);
//            }
//            res=Math.max(res,Max[i]);
//        }
//        return res;
//    }

    // 二维数组
    public int maxProduct(int[] nums){
        int length = nums.length;
        int[][] dp=new int[length][2];
        dp[0][0]=nums[0];dp[0][1]=nums[0];
        int res=Integer.MIN_VALUE;
        for(int i=1;i<length;i++){
            if(nums[i]>=0){
                dp[i][0]=Math.max(nums[i],dp[i-1][0]*nums[i]);
                dp[i][1]=Math.min(nums[i],dp[i-1][1]*nums[i]);
            }else{
                dp[i][0]=Math.max(nums[i],dp[i-1][1]*nums[i]);
                dp[i][1]=Math.min(nums[i],dp[i-1][0]*nums[i]);
            }
            res=Math.max(res,dp[i][0]);
        }
        return res;
    }
}
