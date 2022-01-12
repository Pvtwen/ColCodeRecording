package dataStructure.Leetcode;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/7/21 10:19
 */
public class SortArray912 {
    static int[] temp;
    public static int[] sortArray(int[] global){
        temp=new int[global.length];
        return fen(global,0,global.length-1);
    }
    //分而治之中的 分函数
    public static int[] fen(int[] global,int l,int r){
        if(l<r){
            int mid=(l+r)/2;
            fen(global,l,mid);
            fen(global,mid+1,r);
            zhi(global,l,r,mid+1);
            return global;
        }
        return null;
    }
    //分而治之中的 治函数
    public static void zhi(int[] global, int l, int r, int mid){
        if(global==null){
            return ;
        }
        //p是temp的下标 ,i是左边部分的开始，j是右边部分的开始
        int i,j,p;
        i=l;j=mid;p=l;
        while(i<mid && j<=r){
            if(global[i]<global[j]){
                temp[p++]=global[i++];
            }
            else{
                temp[p++]=global[j++];
            }
        }

        while(i<mid){
            temp[p++]=global[i++];
        }
        while(j<=r){
            temp[p++]=global[j++];
        }
        i=l;
        while(i<=r){
            global[i]=temp[i];
            i++;
        }
    }
}
