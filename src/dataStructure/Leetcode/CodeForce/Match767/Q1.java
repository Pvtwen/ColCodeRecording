package dataStructure.Leetcode.CodeForce.Match767;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/22 22:44
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0){
            int len = sc.nextInt();
            int init = sc.nextInt();
            int idx=0;
            int[] need=new int[len];
            int[] adder=new int[len];
            while(idx<len){
                need[idx]=sc.nextInt();
                idx++;
            }
            idx=0;
            while(idx<len){
                adder[idx]=sc.nextInt();
                idx++;
            }
            solution(need,adder,init);
            n--;
        }
    }
    public static void solution(int[] need,int[] adder,int init){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<adder.length;i++){
            map.put(need[i],map.getOrDefault(need[i],0)+adder[i]);
        }
        Arrays.sort(need);
        for(int i=0;i<need.length;i++){
            if(init>=need[i]){
                if(map.containsKey(need[i])){
                    init+=map.get(need[i]);
                    map.remove(need[i]);
                }else continue;
            }else break;
        }
        System.out.println(init);
    }
}
