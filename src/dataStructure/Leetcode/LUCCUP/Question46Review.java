package dataStructure.Leetcode.LUCCUP;

import java.util.ArrayList;

/**
 * @author Yawen Cao
 * @data 2021/10/21 16:29
 */
public class Question46Review {
    public static int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int length=edges.length;
        int gndNum=finalCnt.length+1;
        int planNum= plans.length;

        int[] param=new int[gndNum];
        int[] cnt=new int[gndNum];

        ArrayList<Integer>[] list=new ArrayList[gndNum];

        for(int i=0;i<gndNum;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<length;i++){
            int num1 = edges[i][0];
            int num2 = edges[i][1];
            list[num1].add(num2);
            list[num2].add(num1);
        }

        param[0]=1;
        for(int i=1;i<gndNum;i++){
            cnt[i]=finalCnt[i-1];
        }

        for(int i=planNum-1;i>=0;i--){
            int num=plans[i][0];
            int idx = plans[i][1];
            planning(num,idx,list,param,cnt);
        }

        long cntSum=0;
        long paramSum=0;
        for(int i=0;i<gndNum;i++){
            cntSum+=cnt[i];
            paramSum+=param[i];
        }

        int x= (int) ((totalNum-cntSum)/paramSum);
        int[] res=new int[gndNum];

        for(int i=0;i<gndNum;i++){
            res[i]=param[i]*x+cnt[i];
        }

        return res;
    }

    public static void planning(int num,int idx,ArrayList<Integer>[] list,int[] param,int[] cnt){
        if(num==1){
            param[idx]*=2;
            cnt[idx]*=2;
        }
        else{
            for (Integer side : list[idx]) {
                if(num==2) {
                    cnt[side]-=cnt[idx];
                    param[side]-=param[idx];
                }
                else{
                    cnt[side]+=cnt[idx];
                    param[side]+=param[idx];
                }
            }
        }
    }
}
