package dataStructure.luogu.MonthlyMatch1;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/21 15:24
 */
public class Q2 {
    static int[] prefixSum;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.next();
        prefixSum=new int[n+1];
        int sum=0;
        for(int i=1;i<=n;i++){
            char c = s.charAt(i);
            if(c=='0') sum-=1;
            else sum+=1;
            prefixSum[i]=sum;
        }

        while(q>0){
            int[] arr=new int[3];
            arr[0]=sc.nextInt();
            arr[1]=sc.nextInt();
            arr[2]=sc.nextInt();
            solution(s,arr);
            q--;
        }
    }
    static int N= (int) (1e9+7);
    public static void solution(String s,int[] arr){
        // 如果2^a形式
        if(Integer.bitCount(arr[2])==1){
            System.out.println((arr[2]<<(arr[1]-arr[0]+1))%(1e9+7));
            return;
        }
        int sub = check(arr[2]);
        int l = arr[0]+1;
        int r = arr[1]+1;
        // 在l-r内找大于l的第一次出现的sub+prefix[l]-1
        int find=sub+prefixSum[l]-1;
        int idx=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(l==r || l==r-1) break;
            else if(prefixSum[mid]<=find) l=mid;
            else if(prefixSum[mid]>find) r=mid-1;
        }
        if(prefixSum[l]==find) idx=l;
        else if(prefixSum[r]==find) idx=r;
        // 如果没找到
        if(idx==-1){

        }
        //如果找到了
        else{
            int number1=0;
            for(int i=l-1;i<=idx-1;i++){
                if(s.charAt(i)==number1){
                    number1++;
                }
            }
        }
    }
    // b-a
    public static int check(int x){
        int a=-1,b=-1;
        int flag=-1;
        int idx=0;
        while(x!=0){
            int bit = x & 1;
            if(bit==1 && flag==-1){
                flag=1;
                a=idx;
            }
            if(bit==1) x-=1;
            else x/=2;
            if(x==0) {
                b=idx;
            }
            idx++;
            if(bit==1) idx--;
        }
        return b-a;
    }
}
