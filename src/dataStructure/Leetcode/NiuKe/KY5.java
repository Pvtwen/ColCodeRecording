package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/2 9:18
 */
public class KY5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String next = sc.next();
            System.out.println(new StringBuilder(next).reverse().toString());
        }
    }
}
