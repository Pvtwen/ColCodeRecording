package dataStructure.luogu;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/12 16:07
 * 八数码问题
 */
public class P1379 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr=new int[9];
        for(int i=0;i<s.length();i++){
            arr[i]=Integer.parseInt(s.charAt(i)+"");
        }
        solution(arr,new int[]{2,0,4,1,6,7,5,3,8});
//        solution(arr,new int[]{1,2,3,8,0,4,7,6,5});
    }
    // arr:九宫格 有一格为空 用0表示
    static long M= (long) (1e9+3);
    // 存状态哈希
    static HashSet<Long> s=new HashSet<>();
    // 村方案 一维: 步数  二维：0的位置 三维：怎么走 up down left right
    static char[][][] solute=new char[10000][9][10000];
    public static void solution(int[] arr,int[] obj){
        Deque<Set<int[]>> queue=new ArrayDeque<>();
        // 初始化queue
        HashSet<int[]> set=new HashSet<>();
        set.add(arr);
        queue.offer(set);
        int iniIdx;
        for(iniIdx=0;iniIdx<9;iniIdx++){
            if(arr[iniIdx]==0) break;
        }
        // 把初始值的hash记录
        long hash1 = hash(arr);
        s.add(hash1);
        int step=0;
        // 目标哈希
        long hash3 = hash(obj);
        if(hash3==hash1) {
            System.out.print(0);
            return;
        }

        while(!queue.isEmpty()){
            Set<int[]> set1 = queue.poll();
            step++;
            HashSet<int[]> coll=new HashSet<>();
            for (int[] val : set1) {
                long hash = hash(val);
                // find 0
                int idx=0;
                for(int i=0;i<9;i++){
                    if(val[i]==0){
                        idx=i;
                        break;
                    }
                }
                // row col
                int x = idx / 3;
                int y = idx % 3;
                int z=x*3+y;

                int directionPointer=0;
                for (int[] d : direction) {
                    int newX = d[0] + x;
                    int newY = d[1] + y;
                    int newZ=newX*3+newY;
                    if(condition(newX,newY)){
                        // s.contains
                        // swap
                        int[] copy = Arrays.copyOf(val, val.length);
                        copy[newZ]=0;
                        copy[z]=val[newZ];
                        long hash2 = hash(copy);
                        if(s.contains(hash2)) continue;
                        if(directionPointer==0){
                            for(int i=0;i<step-1;i++){
                                solute[step][newZ][i]=solute[step-1][z][i];
                            }
                            solute[step][newZ][step-1]='u';
                        }else if(directionPointer==1){
                            for(int i=0;i<step-1;i++){
                                solute[step][newZ][i]=solute[step-1][z][i];
                            }
                            solute[step][newZ][step-1]='d';
                        }else if(directionPointer==2){
                            for(int i=0;i<step-1;i++){
                                solute[step][newZ][i]=solute[step-1][z][i];
                            }
                            solute[step][newZ][step-1]='r';
                        }else {
                            for(int i=0;i<step-1;i++){
                                solute[step][newZ][i]=solute[step-1][z][i];
                            }
                            solute[step][newZ][step-1]='l';
                        }
                        if(hash2==hash3) {
                            // 打印路径
                            for(int i=0;i<=step-1;i++){
                                System.out.print(solute[step][newZ][i]+" ");
                            }
                            System.out.println();
                            System.out.print(step);
                            return;
                        }
                        s.add(hash2);
                        coll.add(copy);
                    }
                    directionPointer++;
                }
            }
            // 收集完毕
            // 等set的所有值遍历完再收集
            queue.offer(coll);
            // !!!!一定要清空 否则下次循环的时候依然遍历之前的值
            set1.clear();
        }
        return ;
    }
//    public static void solution(int[] arr,int[] obj){
//        Deque<Set<int[]>> queue=new ArrayDeque<>();
//        // 初始化queue
//        HashSet<int[]> set=new HashSet<>();
//        set.add(arr);
//        queue.offer(set);
//
//        // 把初始值的hash记录
//        long hash1 = hash(arr);
//        s.add(hash1);
//        int step=0;
//        // 目标哈希
//        long hash3 = hash(obj);
//        if(hash3==hash1) {
//            System.out.print(0);
//            return;
//        }
//
//        while(!queue.isEmpty()){
//            Set<int[]> set1 = queue.poll();
//            step++;
//            HashSet<int[]> coll=new HashSet<>();
//            for (int[] val : set1) {
//                long hash = hash(val);
//                // find 0
//                int idx=0;
//                for(int i=0;i<9;i++){
//                    if(val[i]==0){
//                        idx=i;
//                        break;
//                    }
//                }
//                // row col
//                int x = idx / 3;
//                int y = idx % 3;
//                int z=x*3+y;
//                for (int[] d : direction) {
//                    int newX = d[0] + x;
//                    int newY = d[1] + y;
//                    int newZ=newX*3+newY;
//                    if(condition(newX,newY)){
//                        // s.contains
//                        // swap
//                        int[] copy = Arrays.copyOf(val, val.length);
//                        copy[newZ]=0;
//                        copy[z]=val[newZ];
//                        long hash2 = hash(copy);
//                        if(s.contains(hash2)) continue;
//                        if(hash2==hash3) {
//                            System.out.print(step);
//                            return;
//                        }
//                        s.add(hash2);
//                        coll.add(copy);
//                    }
//                }
//            }
//            // 收集完毕
//            // 等set的所有值遍历完再收集
//            queue.offer(coll);
//            // !!!!一定要清空 否则下次循环的时候依然遍历之前的值
//            set1.clear();
//        }
//        return ;
//    }
    static int[][] direction={{-1,0},{1,0},{0,1},{0,-1}};
    public static boolean condition(int x,int y){
        return x>=0 && x<3 && y>=0 && y<3;
    }
    public static long hash(int[] st){
        long base=0;
        for (int i : st) {
            base=base*10+i;
        }
        return base%M;
    }
}
