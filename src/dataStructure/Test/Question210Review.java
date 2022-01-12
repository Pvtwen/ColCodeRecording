package dataStructure.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Yawen Cao
 * @data 2021/11/27 15:36
 */
public class Question210Review {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int length=numCourses;
        int[] indegrees=new int[length];
        int length1 = prerequisites.length;
        ArrayList<Integer>[] list=new ArrayList[length];
        for(int i=0;i<length;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<length1;i++){
            int cour1 = prerequisites[i][0];
            int cour2 = prerequisites[i][1];
            list[cour2].add(cour1);
            indegrees[cour1]+=1;    // 1<-2
        }
        Stack<Integer> stack=new Stack<>();
        int count=0;
        int[] res=new int[length];
        for(int i=0;i<length;i++){
            if(indegrees[i]==0) {
                stack.push(i);
                res[count]=i;
                count++;
            }
        }
        while(!stack.isEmpty()){
            Integer cour = stack.pop();
            for (Integer neigh : list[cour]) {
                indegrees[neigh]-=1;
                if(indegrees[neigh]==0){
                    stack.push(neigh);
                    res[count]=neigh;
                    count++;
                }
            }
        }
        if(count!=length) return new int[]{};
        return res;
    }
}
