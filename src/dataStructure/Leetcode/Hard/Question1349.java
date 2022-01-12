package dataStructure.Leetcode.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/9/15 19:55
 */
public class Question1349 {
    public static int maxStudents(char[][] seats) {
        int m=seats.length;
        int n=seats[0].length;
        int[] maxSize=new int[m];
        int max=1<<n;
        int res=0;
        int[][] dp=new int[m][max];
        ArrayList<Integer>[] lists=new ArrayList[m];

        for(int i=0;i<m;i++){
            lists[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxSize[i]=(maxSize[i]<<1)+(seats[i][j]=='.'?1:0);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=maxSize[i];j>0;j=(j-1)&maxSize[i]){
                lists[i].add(j);
            }
        }

//        for(int i=0;i<m;i++){
//            for(int j=0;j<max;j++){
//                //能做座位并且能够左右无人
//                if(((maxSize[i] & j)==j) && ((j>>1) & j)==0){
//                    if(i==0) dp[i][j]=Integer.bitCount(j);
//                    else{
//                        for (Integer integer : lists[i - 1]) {
//                            if((((integer>>1)&j)==0) && ((integer & (j>>1))==0)){
//                                dp[i][j]=Math.max(dp[i][j],Integer.bitCount(j)+dp[i-1][integer]);
//                            }
//                        }
//                    }
//                }
//                res=Math.max(res,dp[i][j]);
//            }
//        }
        for(int i=0;i<m;i++){
            for (Integer j : lists[i]) {
                // 左右无人
                if(((j>>1) & j)==0){
                    if(i==0) dp[i][j]=Integer.bitCount(j);
                    else{
                        for (Integer integer : lists[i - 1]) {
                            if((((integer>>1)&j)==0) && ((integer & (j>>1))==0)){
                                dp[i][j]=Math.max(dp[i][j],Integer.bitCount(j)+dp[i-1][integer]);
                            }
                        }
                    }
                    }
                res=Math.max(res,dp[i][j]);
                }
            }
        return res;
    }
}
//                        for(int k=0;k<max;k++){
//                            //左上右上无人  且能做人
//                            if(((maxSize[i-1] & k)==k && ((k>>1)&j)==0) && ((k & (j>>1))==0)){
//                                dp[i][j]=Math.max(dp[i][j],Integer.bitCount(j)+dp[i-1][k]);
//                            }
//                        }