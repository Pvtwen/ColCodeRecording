package dataStructure.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author Yawen Cao
 * @data 2021/10/20 20:34
 */
public class Question210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses];
        Queue<Integer> queue=new ArrayDeque<>();
        int[] indegrees=new int[numCourses];
        ArrayList<Integer>[] list=new ArrayList[numCourses];

        int length=prerequisites.length;
        for(int i=0;i<numCourses;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<length;i++){
            int ai = prerequisites[i][0];
            int bi = prerequisites[i][1];
            indegrees[ai]++;
            list[bi].add(ai);
        }

        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0) queue.add(i);
        }

        int t=0;
        while(!queue.isEmpty()){
            Integer courseNum = queue.poll();
            res[t]=courseNum;
            t++;
            numCourses--;

            for (Integer num : list[courseNum]) {
                indegrees[num]--;
                if(indegrees[num]==0) queue.offer(num);
            }
        }
        return numCourses==0?res:new int[]{};
    }
}
