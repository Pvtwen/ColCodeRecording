package dataStructure.Leetcode.Hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;

/**
 * @author Yawen Cao
 * @data 2022/1/11 9:46
 */
public class Question1036 {
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int length = blocked.length;
        // 等差求和
        int maxinum=length*(length-1)/2;
        Deque<int[]> queue=new ArrayDeque<>();
        queue.offer(source);
        HashSet<Long> obst=new HashSet<>();
        for (int[] b : blocked) {
            obst.add(hash(b[0],b[1]));
        }
        HashSet<Long> set=new HashSet<>();
        set.add(hash(source[0],source[1]));
        int flag=-1;
        while(set.size()<=maxinum && !queue.isEmpty()){
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            for (int[] direction : directions) {
                int cX = direction[0] + x;
                int cY = direction[1] + y;
                if(condition(cX,cY)){
                    if(cX==target[0] && cY==target[1]) return true;
                    if(!obst.contains(hash(cX,cY)) && !set.contains(hash(cX,cY))){
                        set.add(hash(cX,cY));
                        queue.offer(new int[]{cX,cY});
                    }
                }
            }
        }
        if(set.size()>maxinum){
            flag=1;
        }
        if(flag==-1) return false;
        set.clear();
        queue.clear();
        queue.offer(target);
        set.add(hash(target[0],target[1]));
        int flag1=-1;
        while(set.size()<=maxinum && !queue.isEmpty()){
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            for (int[] direction : directions) {
                int cX = x + direction[0];
                int cY = y + direction[1];
                if(condition(cX,cY)){
                    if(!set.contains(hash(cX,cY))&&!obst.contains(hash(cX,cY))){
                        queue.offer(new int[]{cX,cY});
                        set.add(hash(cX,cY));
                    }
                }
            }
        }
        if(set.size()>maxinum){
            flag1=1;
        }
        if(flag1==1) return true;
        return false;
    }
    public long hash(int x,int y){
        return x*1000000L+y;
    }
    public boolean condition(int x,int y){
        return x>=0 && x<Math.pow(10,6) && y>=0 && y<Math.pow(10,6);
    }
//    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
//        if(blocked.length==0){
//            return true;
//        }
//        int m = blocked.length;
//        int v = (int) Math.pow(10, 6);
//        HashSet<Long> step=new HashSet<>();
//        // 不能通过的点
//        HashSet<Long> set=new HashSet<>();
//        for(int i=0;i<m;i++){
//            int x = blocked[i][0];
//            int y = blocked[i][1];
//            long hash = hash(x, y);
//            set.add(hash);
//        }
//        Deque<int[]> queue=new ArrayDeque<>();
//        queue.offer(source);
//        set.add(hash(source[0],source[1]));
//        while(!queue.isEmpty()){
//            int[] path = queue.poll();
//            int x = path[0];
//            int y = path[1];
//            for (int[] direction : directions) {
//                int cX = direction[0] + x;
//                int cY = direction[1] + y;
//                if(cX==target[0] && cY==target[1]){
//                    return true;
//                }
//                if(condition(cX,cY)){
//                    if(!set.contains(hash(cX,cY)) || !set.contains(hash(cX,cY))){
//                        queue.offer(new int[]{cX,cY});
//                        set.add(hash(cX,cY));
//                    }
//                }
//            }
//        }
//        return false;
//    }
}
