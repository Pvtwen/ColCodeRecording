//package dataStructure.luogu;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Scanner;
//
///**
// * @author Yawen Cao
// * @data 2022/1/26 8:31
// */
//public class P7521 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr=new int[n];
//        int idx=0;
//        while(n>0){
//            arr[idx]=sc.nextInt();
//            idx++;
//            n--;
//        }
//        solution(arr);
//    }
//    public static void solution(int[] arr){
//        Arrays.sort(arr);
//        int ret=0;
//        for(int i=arr.length-1;i>=0 && ret<arr[i];i--){
//            int j=i-1,k=i-2;
//            while(j>=0){
//                if(k<0) {
//                    j--;
//                    k=j-1;
//                }
//                if(j<0 || k==-1) break;
//                if(arr[j]+arr[k]<arr[i]) {
//                    ret=Math.max(ret,arr[j]+arr[k]);
//                    break;
//                }else if(arr[j]+arr[k]>=arr[i]){
//                    ret=Math.max((arr[j]+arr[k])%arr[i],ret);
//                    k--;
//                }
//            }
//        }
//        System.out.println(ret);
//    }
//}
