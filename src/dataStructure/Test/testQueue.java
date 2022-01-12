package dataStructure.Test;

import dataStructure.Queue.SeqQueue;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/6/10 19:17
 */
public class testQueue {
    public static void main(String[] args) throws Exception {
        int[] arr={1,2,3,4,5};
        int[] arr1={1,2,3,4,5};
        int[] c = Arrays.copyOf(arr, 3);
        for (int i : c) {
            System.out.print(i+" ");
        }

        System.out.println(        Arrays.equals(arr,arr1));
    }
}
