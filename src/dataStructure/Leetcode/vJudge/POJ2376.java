package dataStructure.Leetcode.vJudge;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/2/2 15:07
 */
public class POJ2376 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr=new int[n][2];
        int T = sc.nextInt();
        int idx=0;
        while(idx<n){
            arr[idx][0]=sc.nextInt();
            arr[idx][1]=sc.nextInt();
            idx++;
        }
        solution1(arr,T);
    }
    public static void solution(int[][] arr,int T){
//        for(int i=0;i<arr.length;i++){
//            int a = arr[i][0];
//            int b = arr[i][1];
//            if(a>=r){
//            }else if(b<=l){
//            }
//            if(a>=l && b>r){
//                arr[i][0]=a;arr[i][1]=r;
//            }
//            if(a>=l && b<=r){
//            }else if(a<l && b>=r){
//                arr[i][0]=l;arr[i][1]=r;
//            }else if(a<l && b<r){
//                arr[i][0]=l;arr[i][1]=b;
//            }
//        }
        // 左端点从小到大 右端点从小到大
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        if(arr[0][0]>1) {
            System.out.println(-1);
            return;
        }
        int ret=1;
        // b说明 b以前已经被覆盖
        int b=1;
//        int j=0;
        int end=arr[0][1];

        for(int i=0;i<arr.length;){
            // 不连续
            if(arr[i][0]>b){
                break;
            }
            while(i<arr.length){
                int a1 = arr[i][0];
                int b1 = arr[i][1];
                if(a1<=b){
                    end=Math.max(end,b1);
                    i++;
                }else{
                    // 更新区间
                    b=end+1;
                    ret++;
                    break;
                }
                // 这里一定要放在while循环内部判断 否则会出现第一个就大于T，但是依然会继续循环的问题
                // [[1,8],[0,6],[5,10],[7,10]]
                if(end>= T){
                    break;
                }
            }
        }
        if(end< T){
            System.out.println(-1);
        }else{
            System.out.println(ret);
        }
    }
    public static void solution1(int[][] arr,int T){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        // 区间的端点  start
        int start=1;
        int end=1;
        int ans=1;
        if(arr[0][0]>1) {
            System.out.println(-1);
            return;
        }
        for(int i=0;i<arr.length;i++){
            int a = arr[i][0];
            int b = arr[i][1];
            if(a<=start){
                end=Math.max(end,b);
            }else{
                start=end+1;
                ans++;
                // 继续利用该区间 防止丢失
                if(a<=start){
                    end=Math.max(end,b);
                }else{
                    break;
                }
            }
            if(end>=T){
                break;
            }
        }
        if(end<T){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }
}
