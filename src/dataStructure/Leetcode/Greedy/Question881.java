package dataStructure.Leetcode.Greedy;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/2/1 11:24
 */
public class Question881 {
    public int numRescueBoats(int[] people, int limit) {
        int num=0;
        int length = people.length;
        Arrays.sort(people);
        int i=0,j=length-1;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;j--;
                num++;
            }else if(people[i]+people[j]>limit){
                j--;
                num++;
            }
        }
        return num;
    }
}
