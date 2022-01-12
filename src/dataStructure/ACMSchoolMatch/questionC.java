package dataStructure.ACMSchoolMatch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2021/12/20 10:30
 */
public class questionC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 机房的数量
        int n = sc.nextInt();
        // 路由器的数量
        int m = sc.nextInt();
        int[] houses=new int[n];
        int[] routers=new int[n];
        int idx=0;
        while(n>0){
            houses[idx]=sc.nextInt();
            n--;
            idx++;
        }
        idx=0;
        while(m>0){
            routers[idx]=sc.nextInt();
            m--;
            idx++;
        }
        Arrays.sort(routers);
        Arrays.sort(houses);
        // 1. 划分二分区间
        int l = 0, r = (int) 1e9;
        // 如果此处l<=r 会超时 卡在测试用例 [1,2,3] [2]
        // 可以这么想 因为一定可以在该范围区间内找到一个整数, 与二分查找的模板不同
        // 其次，这道题是已知区间 找未知的值  之前的几道题是在不连续但是递增的区间内找已知的值
        while(l<r){
            int mid=(l+r)/2;
            if(check(houses,routers,mid)) r=mid;
            else l=mid+1;
        }
        System.out.println(l);
    }
    public static boolean check(int[] houses,int[] routers,int x){
        int n = houses.length;
        int m = routers.length;
        for(int i=0,j=0;i<n && j<m;i++){
            while(j<m&&routers[j]+x<houses[i]) j++;
            if(j<m&&routers[j]+x>=houses[i] &&routers[j]-x<=houses[i]) continue;
            return false;
        }
        return true;
    }
}
