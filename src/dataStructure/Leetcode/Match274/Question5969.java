package dataStructure.Leetcode.Match274;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/1/2 10:43
 */
public class Question5969 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int length = asteroids.length;
        Arrays.sort(asteroids);
        long sum=mass;
        for (int asteroid : asteroids) {
            if(sum>=asteroid){
                sum+=asteroid;
            }
            else return false;
        }
        return true;
    }
}
