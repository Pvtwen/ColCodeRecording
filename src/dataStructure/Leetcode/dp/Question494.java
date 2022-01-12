package dataStructure.Leetcode.dp;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/12/17 14:47
 */
public class Question494 {
    // 使用二维数组定义map
    int[][] map;
    // HashMap<String ,Integer> map = new HashMap<>();  // k:下标  v:该下标计算之后出现过的值
    public int findTargetSumWays(int[] nums, int target) {
        map=new int[nums.length][10000000];
        for (int[] ints : map) {
            Arrays.fill(ints,10000000);
        }
        return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int idx, int sum) {
        // String key=idx+"+"+sum;
        if(map[idx][sum]!=10000000) return map[idx][sum];
        if (idx == nums.length) {
            map[idx][sum]=(sum==target)?1:0;
            return sum==target?1:0;
        }
        // + -
        int left = dfs(nums, target, idx + 1, sum + nums[idx]);
        int right = dfs(nums, target, idx + 1, sum - nums[idx]);
        // map.put(key,left+right);
        map[idx][sum]=left+right;
        return left+right;
    }

    // BFS
//    public int findTargetSumWays(int[] nums, int target) {
//        int length = nums.length;
//        int ret=0;
//        int sum=0;
//        for (int num : nums) {
//            sum+=num;
//        }
//        if(target>sum) return 0;
//        if(target<-sum) return 0;
//        if(length==1) return target==nums[0]||target==-nums[0]?1:0;
//        Deque<int[]> queue=new ArrayDeque<>();
//        queue.offer(new int[]{0,nums[0]});
//        queue.offer(new int[]{0,-nums[0]});
//        while(!queue.isEmpty()){
//            int[] poll = queue.poll();
//            int curIdx = poll[0];
//            int curSum = poll[1];
//            if(curIdx==length-2){
//                int i = curSum + nums[length - 1];
//                int i1 = curSum - nums[length - 1];
//                if(i==target) ret++;
//                if(i1==target) ret++;
//                continue;
//            }else{
//                int i = curSum + nums[curIdx + 1];
//                int i1 = curSum - nums[curIdx + 1];
//                queue.offer(new int[]{curIdx+1,i});
//                queue.offer(new int[]{curIdx+1,i1});
//            }
//        }
//        return ret;
//}
    // 动态规划
//    public int findTargetSumWays(int[] nums, int target) {
//        int length = nums.length;
//        int sum=0;
//        for (int num : nums) {
//            sum+=num;
//        }
//        if(target>sum) return 0;
//        int[][] dp=new int[length+1][2*sum+1];
//        dp[0][sum] = 1;
//        for(int i=1;i<=length;i++){
//            for(int j=0;j<=2*sum;j++){
//                if(j-nums[i-1]>=0) dp[i][j]+=dp[i-1][j-nums[i-1]];
//                if(j+nums[i-1]<=2*sum) dp[i][j]+=dp[i-1][j+nums[i-1]];
//            }
//        }
////        for(int i=1;i<=length;i++){
////            for(int j=-sum;j<=sum;j++){
////                if(j-nums[i-1]+sum>=0) dp[i][j+sum]+=dp[i-1][j-nums[i-1]+sum];
////                if(j+nums[i-1]+sum<=2*sum) dp[i][j+sum]+=dp[i-1][j+nums[i-1]+sum];
////            }
////        }
//        return dp[length][target+sum];
//    }

    // 记忆化递归
//    HashMap<String ,Integer> map = new HashMap<>();  // k:下标  v:该下标计算之后出现过的值
//    public int findTargetSumWays(int[] nums, int target) {
//        return dfs(nums, target, 0, 0);
//    }
//
//    public int dfs(int[] nums, int target, int idx, int sum) {
//        String key=idx+"+"+sum;
//        if (idx == nums.length) {
//            map.put(key,sum==target?1:0);
//            return sum==target?1:0;
//        }
//        if(map.containsKey(key)) return map.get(key);
//        // + -
//        int left = dfs(nums, target, idx + 1, sum + nums[idx]);
//        int right = dfs(nums, target, idx + 1, sum - nums[idx]);
//            map.put(key,left+right);
//        return left+right;
//    }

    // 朴素递归
//    int s=0;
//    public int findTargetSumWays(int[] nums, int target) {
//        int length = nums.length;
//        dfs(nums,target,0,0);
//        return s;
//    }
//
//    public void dfs(int[] nums, int target, int idx, int sum) {
//        if(idx==nums.length){
//            if(sum==target) s++;
//            return;
//        }
//        // + -
//        dfs(nums,target,idx+1,sum+nums[idx]);
//        dfs(nums, target, idx+1,sum-nums[idx]);
//    }
}
