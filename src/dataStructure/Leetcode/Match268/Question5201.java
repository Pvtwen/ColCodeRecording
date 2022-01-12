package dataStructure.Leetcode.Match268;

/**
 * @author Yawen Cao
 * @data 2021/11/21 10:51
 */
public class Question5201 {
    public int wateringPlants(int[] plants, int capacity) {
        int length = plants.length;
        int temp=capacity;
        int step=0;
        for(int i=0;i<length;i++){
            if(plants[i]<=temp){
                temp-=plants[i];
                step++;
            }else{
                step+=i;
                step+=i+1;
                temp=capacity;
                temp-=plants[i];
            }
        }
        return step;
    }
//    public static int wateringPlants(int[] plants, int capacity) {
//        if(plants.length==1) return 1;
//        int length = plants.length;
//        int[] prefixSumArray=new int[length+1];
//        int sum=0;
//        for(int i=1;i<length+1;i++){
//            sum+=plants[i-1];
//            prefixSumArray[i]=sum;
//        }
//        int step=0;
//        int cur=1;
//        int curSum=0;
//        while(cur!=length){
//            cur = checkFirstNode(prefixSumArray, cur, curSum, capacity);
//            curSum=prefixSumArray[cur];
//            if(cur==length) step+=length;
//            else            step+=(cur)*2;
//        }
//        return step;
//    }
//    public static int checkFirstNode(int[] prefixSumArray,int idx,int sum,int capacity){
//        for(int i=idx;i<prefixSumArray.length;i++){
//            if(prefixSumArray[i]-sum>capacity) return i-1;
//        }
//        return prefixSumArray.length-1;
//    }
}
