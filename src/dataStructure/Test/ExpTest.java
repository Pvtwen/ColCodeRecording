package dataStructure.Test;
import dataStructure.luogu.P1379;

import java.io.*;
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
        P1379 q=new P1379();
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










