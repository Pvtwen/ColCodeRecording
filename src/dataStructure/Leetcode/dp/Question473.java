package dataStructure.Leetcode.dp;

import java.util.HashSet;

/**
 * @author Yawen Cao
 * @data 2021/12/14 10:54
 */
public class Question473 {
    static int average;
    static  int point=0;
    public static boolean makesquare(int[] matchsticks) {
        int length = matchsticks.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += matchsticks[i];
        }
        if(sum%4!=0) return false;
        average = sum / 4;
        int[] result=new int[4];
        return dfs(matchsticks,0,result,0);
    }
    public static boolean dfs(int[] sticks,int dix,int[] result,int cur){
        if(dix==sticks.length){
            boolean check = check(result);
            if(!check) return false;
            return true;
        }
        System.out.println("第"+point+"次递归");
        point++;

        int i1=result[cur]+sticks[dix];
        if(i1>average) return false;
        result[cur]=i1;
        for(int i=0;i<=3;i++){
//            System.out.println(point + ":result数组的下标为" + i + ",stick数组的下标为:" + (dix+1) + ",result数组的值为:" + result[0] + "," + result[1] + "," + result[2] + "," + result[3]);
//            point++;
            boolean dfs = dfs(sticks, dix + 1, result, i);
            if(dfs) return true;
        }
        result[cur]-=sticks[dix];
        return false;
    }
//    public static boolean dfs(int[] sticks, int idx, int[] result, int cur) {
//        if (idx == sticks.length) {
//            boolean check = check(result);
//            if(!check) return false;
//            else return true;
//        }
//
//        for(int i=0;i<4;i++){
//            int i1 = result[i] + sticks[idx];
//            // 大于平均值 回溯
//            if (i1 > average) {
//                continue;
//            }
//            result[i]=i1;
//            System.out.println(point + ":result数组的下标为" + i + ",stick数组的下标为:" + (idx+1) + ",result数组的值为:" + result[0] + "," + result[1] + "," + result[2] + "," + result[3]);
//            point++;
//            boolean dfs = dfs(sticks, idx + 1, result, i);
//            if(dfs) return true;
//            result[i]-=sticks[idx];
//        }
//        return false;
//    }
    public static boolean check(int[] result) {
        for (int i : result) {
            if(i!=average) return false;
        }
        return true;
    }
//    public boolean makesquare(int[] matchsticks) {
//        HashSet<Integer> set=new HashSet<>();
//        int length = matchsticks.length;
//        int sum = 0;
//        for (int i = 0; i < length; i++) {
//            sum += matchsticks[i];
//        }
//        if (sum % 4 != 0) return false;
//        int maxSize = (int) (Math.pow(2, length));
//        int idx=0;
//        for(int i=1;i<maxSize;i++){
//            int ret = add(matchsticks, i);
//            if(ret==sum/4){
//                boolean covered = isCovered(i, set);
//                if(!covered){
//                    set.add(i);
//                    idx++;
//                }
//                if(idx==4) break;
//            }
//        }
//        // 检查是否全部的元素都用完了
//        int base=0;
//        for (Integer integer : set) {
//            base|=integer;
//        }
//        if(base==maxSize-1) return true;
//        return false;
//    }
//    public int add(int[] arr,int i){
//        int length = arr.length;
//        int sum=0;
//        int idx=length-1;
//        while(i!=0){
//            int i1 = i & 1;
//            if(i1==1){
//                sum+=arr[idx];
//            }
//            i>>=1;
//            idx--;
//        }
//        return sum;
//    }
//    //判断是否重叠
//    public boolean isCovered(int a,HashSet<Integer> set){
//        for (Integer integer : set) {
//            if((integer&a)!=0) return true;
//        }
//        return false;
//    }
}
