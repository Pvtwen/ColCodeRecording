package dataStructure.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2021/10/31 20:19
 */
class Solution{
    public int minMove(int[] candyNums){
        int length=candyNums.length;

        int mod=candyNums[0]%2;

        //同余定理
        for(int i=1;i<length;i++){
            if(candyNums[i]%2!=mod) return -1;
        }

        Arrays.sort(candyNums);
        int[] prefixSumArray=new int[length+1];
        int sum=0;
        for(int i=1;i<length+1;i++){
            sum+=candyNums[i-1];
            prefixSumArray[i]=sum;
        }

        int res=Integer.MAX_VALUE;
        for(int i=1;i<length+1;i++){
            // 后
            int back=prefixSumArray[length]-prefixSumArray[i]-(candyNums[i-1]*(length-i));
            // 前
            int front=Math.abs(prefixSumArray[i-1]-(candyNums[i-1]*(i-1)));
            int step=(front+back)/2;
            if(step<res) res=step;
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int candyNums_size=0;
        candyNums_size=in.nextInt();
        int[] candyNums=new int[candyNums_size];
        for(int candyNums_i=0;candyNums_i<candyNums_size;candyNums_i++){
            candyNums[candyNums_i]=in.nextInt();
        }

        res=new Solution().minMove(candyNums);
        System.out.println(String.valueOf(res));
    }
}
