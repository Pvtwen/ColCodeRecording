package dataStructure.Leetcode.DecodeAndEncode;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/1/27 10:00
 */
public class encodingAndDecoding {
    public static void main(String[] args) {
//        encode("aabc","caba");
        String s="aabc";
        int[] arr=new int[30];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            arr[c-'a']++;
        }
        String en="baac";
//        dfs(arr,0,en);
//        System.out.println(res);
        dfs(arr,7,0,"");
    }
    // decoding
    // cur:当前已经凑的值
    public static void dfs(int[] arr,int target,int cur,String s){
        // 如果cur<target 递归
        // 如果cur>target 继续搜索
        if(cur==target) {
            for(int i=0;i<arr.length;i++){
                for(int j=1;j<=arr[i];j++){
                    s+=(char)(i+'a');
                }
            }
            System.out.println(s);
            return;
        }
        for(int i=0;i<arr.length;i++){
            int[] copy = Arrays.copyOf(arr, arr.length);
            if(copy[i]==0) continue;
            copy[i]-=1;
            int permutation = permutation(copy);
            // 继续迭代 加上当前的值
            if(cur+permutation<target) {
                cur+=permutation;
                continue;
            }
            if(permutation>1 && cur+permutation>=target){
                s+=(char)(i+'a');
                dfs(copy,target,cur,s);
                return;
            }
            if(permutation==1 && cur+permutation==target){
                s+=(char)(i+'a');
                dfs(copy,target,cur+permutation,s);
                return;
            }
        }
    }

//    static int res=0;
    // cur: 当前确定的字符串的下标
//    public static void dfs(int[] arr,int cur,String en){
//        if(cur==en.length()) return;
//        char c = en.charAt(cur);
//        for(int i='a';i<=c;i++){
//            int[] copy = Arrays.copyOf(arr, arr.length);
//            if(copy[i-'a']==0) continue;
//            if(i<c) {
//                copy[i-'a']-=1;
//                int permutation = permutation(copy);
//                res+=permutation;
//            }
//            if(i==c){
//                arr[i-'a']--;
//                dfs(arr,cur+1,en);
//            }
//        }
//    }

//    public static void encode(String s,String en){
//        int[] arr=new int[30];
//        for(int i=0;i<s.length();i++){
//            char c = s.charAt(i);
//            arr[c-'a']+=1;;
//        }
//        int res=0;
//        for(int i=0;i<s.length();i++){
//            char c = en.charAt(i);
//            for(int j='a';j<=c;j++){
//                int[] copy = Arrays.copyOf(arr, arr.length);
//                if(copy[j-'a']==0) continue;
//                if(j<c){
//                    copy[j-'a']-=1;
//                    int ret = permutation(copy);
//                    res+=ret;
//                }
//                if(j==c){
//                    arr[j-'a']-=1;
//                    break;
//                }
//            }
//        }
//        System.out.println(res);
//    }
    public static int permutation(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int fz=1;
        int temp=sum;
        while(temp>0){
            fz*=temp;
            temp--;
        }
        int fm=1;
        for(int i=0;i<arr.length;i++) {
            int temp1=arr[i];
            int base=1;
            while(temp1>0){
                base*=temp1;
                temp1--;
            }
            fm*=base;
        }
        return fz/fm;
    }
}
