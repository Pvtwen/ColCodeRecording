package dataStructure.Leetcode.UVa;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/28 15:34
 */
public class Uva580 {
    public static void main(String[] args) {
        int[] arr={0,
                0,
                0,
                1,
                3,
                8,
                20,
                47,
                107,
                238,
                520,
                1121,
                2391,
                5056,
                10616,
                22159,
                46023,
                95182,
                196132,
                402873,
                825259,
                1686408,
                3438828,
                6999071,
                14221459,
                28853662,
                58462800,
                118315137,
                239186031,
                483072832,
                974791728};
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        while(i!=0){
            System.out.println(arr[i]);
            i=sc.nextInt();
        }
    }
//    public static void main(String[] args) {
//        int[] arr=new int[31];
//        arr[0]=arr[1]=arr[2]=0;
//        for(int n=3;n<=30;n++){
//            double sum=0;
//            for(int i=2;i<=n-2;i++){
//                double v = (int) ((Math.pow(2, i - 2) - arr[i - 2]) * Math.pow(2, n - i - 2));
//                sum+=v;
//            }
//            arr[n]= (int) (sum+Math.pow(2,n-3));
//        }
//        for (int i : arr) {
//            System.out.println(i);
//        }
//    }
}
