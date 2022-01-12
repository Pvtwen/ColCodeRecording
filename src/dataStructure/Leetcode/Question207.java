package dataStructure.Leetcode;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/10/20 19:04
 */
public class Question207 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegrees=new int[numCourses];
            Queue<Integer> queue=new ArrayDeque<>();
            ArrayList<Integer>[] list=new ArrayList[numCourses];

            for(int i=0;i<numCourses;i++){
                list[i]=new ArrayList<>();
            }

            int length=prerequisites.length;
            for(int i=0;i<length;i++){
                int ai = prerequisites[i][0];
                int bi = prerequisites[i][1];
                indegrees[ai]++;
                list[bi].add(ai);
            }

            for(int i=0;i<numCourses;i++){
                if(indegrees[i]==0) queue.offer(i);
            }

            while(!queue.isEmpty()){
                Integer num = queue.poll();
                numCourses--;

                for (Integer courseNum : list[num]) {
                    indegrees[courseNum]--;
                    if(indegrees[courseNum]==0) queue.offer(courseNum);
                }
            }

            return numCourses==0;
        }
}
