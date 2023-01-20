package dataStructure.Leetcode.easy;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/31 10:07
 */
public class Question1342 {
    public int numberOfSteps(int num) {
        int step=0;
        while(num!=0){
            if(num%2==0){
                step++;
                num/=2;
            }else{
                step++;
                num--;
            }
        }
        return step;
    }
}
