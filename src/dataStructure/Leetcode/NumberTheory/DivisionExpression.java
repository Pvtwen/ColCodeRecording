package dataStructure.Leetcode.NumberTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/20 15:23
 * x1/x2/x3/x4/x5....xk
 */
public class DivisionExpression {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int x = sc.nextInt();
        while(x!=0){
            list.add(x);
            x=sc.nextInt();
        }
        solution(list);
    }
    public static void solution1(List<Integer> list){
        Integer x2 = list.get(1);
        int max = Math.max(list.get(0), list.get(1));
        int min = Math.min(list.get(0), list.get(1));
        int gcd = gcd(max, min);
        x2/=gcd;
        for(int i=2;i<list.size();i++){
            max=Math.max(list.get(i),list.get(1));
            min=Math.min(list.get(i),list.get(1));
        }
        if(x2==1) System.out.println("true");
        else System.out.println("false");
    }
    // x>y
    public static int gcd(int x,int y){
        while(y!=0){
            x=y;
            y=x%y;
        }
        return x;
    }
    static HashMap<Integer,Integer> x2=new HashMap<>();
    static HashMap<Integer,Integer> xOther=new HashMap<>();
    public static void solution(List<Integer> list){
        compute(list.get(1),1);
        for(int i=0;i<list.size();i++){
            if(i==1) continue;
            compute(list.get(i),0);
        }
        for (Integer div : x2.keySet()) {
            if(!xOther.containsKey(div)) {
                System.out.println("no");
                return;
            };
            if(xOther.get(div)<x2.get(div)){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
    public static void compute(int x,int isX2){
        int temp=x;
        if(isX2==1){
            for(int i=2;i<=temp;i++){
                while(temp%i==0){
                    x2.put(i,x2.getOrDefault(i,0)+1);
                    temp/=i;
                }
            }
        }else{
            for(int i=2;i<=temp;i++){
                while(temp%i==0){
                    xOther.put(i,xOther.getOrDefault(i,0)+1);
                    temp/=i;
                }
            }
        }
    }
}
