package dataStructure.Test;
import dataStructure.Leetcode.Greedy.Question1024;
import dataStructure.Leetcode.Match276.Question5194;
import dataStructure.Leetcode.Match276.Question5980;
import dataStructure.Leetcode.Match276.Question5982;
import dataStructure.Leetcode.Match279.Q1;
import dataStructure.Leetcode.Match282.Q4;
import dataStructure.Leetcode.Match283.Q2;
import dataStructure.Leetcode.Match283.Q3;
import dataStructure.Leetcode.NiuKe.NC145;
import dataStructure.Leetcode.NiuKe.NC153;
import dataStructure.Leetcode.Q43;
import dataStructure.Leetcode.Question743;
import dataStructure.Leetcode.dp.Easy.Question53;
import dataStructure.Leetcode.dp1.Q2140;
import dataStructure.Leetcode.dp1.Q279;
import dataStructure.Leetcode.dp1.Q322;
import dataStructure.Leetcode.dp1.Q354;
import dataStructure.luogu.P1379;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ExpTest {
//    static String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\dataStructure";

//    static int res=0;
//    static List<File> list=new ArrayList<>();

    public static void main(String[] args) throws UnsupportedEncodingException {
//        double pi = Math.PI;
//        System.out.println(Math.atan(1));
//        System.out.println(Math.atan(-1));
////        System.out.println(Math.atan2(1, 1));
//        System.out.println(Math.atan2(-1, 1));
//        System.out.println(Math.atan2(1, -1));
//        System.out.println(Math.atan2(-1,-1));
//
//        // ×Ô¼ºÐ´µÄatan2
////        dataStructure.Compute.TaylerExpression.Math.atan2(-1,1);
//        System.out.println();
//        System.out.println(        dataStructure.Compute.TaylerExpression.Math.atan2(-1,1));
//        System.out.println(        dataStructure.Compute.TaylerExpression.Math.atan2(1,-1));
//        System.out.println(        dataStructure.Compute.TaylerExpression.Math.atan2(-1,-1));
//        Question5982 q=new Question5982();
//        q.mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}});

//        Q2 q=new Q2();
//        q.minimumOperations(new int[]{2,2});
        String s="¡Ì1+x^x";
        int b=8730;
        char i= (char) b;
        System.out.println(i);
//        double x=0.000000011;
//        System.out.println(x);
//        double x=0.000000001;
        int count=0;
//        while(count<1000000){
//            double square=x*x;
//            double a = Math.log(1 + x + 0.5 * square);
//            double tes1 = 1 / a;
//            BigDecimal a1=new BigDecimal(a);
//            BigDecimal common=new BigDecimal(1);
//            BigDecimal x1 = common.divide(a1, 10, RoundingMode.HALF_UP);
//            double b = Math.log(1 + x);
//            double tes2 = 1 / b;
//            System.out.println(a==b);
//            System.out.println(tes1==tes2);
//            BigDecimal b1 = new BigDecimal(b);
//            BigDecimal common1 = new BigDecimal(1);
//            BigDecimal y = common1.divide(b1, 10, RoundingMode.HALF_UP);
//            BigDecimal ret = x1.subtract(y);
//            x-=0.000000000000001;
//            System.out.println(ret);
//            count++;
//        }
//        while(count<1000000){
//            double square=x*x;
//            double root=Math.pow(1+square,0.5);
//            double f1 = Math.log(x + root);
//            double le=1/f1;
//            double f2=Math.log(1+x);
//            double ri=1/f2;
//            count++;
//            x-=0.0000000000001;
//            System.out.println(le-ri);
//        }
    }
    public static void com(int val){
        int base=1;
        while (val > base) {
            System.out.println(base);
            val -= base;
            base *= 2;
        }
        System.out.println(val);
    }
    public static void dfs(int idx,Deque<String> queue){
        if(idx==1){
            queue.offer("sss");
            return;
        }
        queue.offer("str");
        dfs(1,queue);
        dfs(1,queue);
    }

    public static void ds(boolean[] visited,int i){
        visited[i]=true;
        if(i==2) return;
        ds(visited,i+1);
        for (boolean b : visited) {
            System.out.println("??"+i+"??:"+b);
        }
    }
}










