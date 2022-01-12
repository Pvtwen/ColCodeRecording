package dataStructure.Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/11/17 9:29
 */
public class Question318 {
// 位运算
    public int maxProduct(String[] words) {
        int length = words.length;
        int res=0;
        int[] newArr=new int[length];
        for(int i=0;i<length;i++){
            int init=0;
            String word = words[i];
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                int sub=c-96;
                init=(init)|(1<<sub);
            }
            newArr[i]=init;
        }
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if((newArr[i]&newArr[j])==0){
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
    //    public static int maxProduct(String[] words) {
//        int length = words.length;
//        HashSet<Character>[] arr=new HashSet[length];
//        for(int i=0;i<length;i++){
//            arr[i]=new HashSet<>();
//        }
//        for(int i=0;i<length;i++){
//            int len = words[i].length();
//            for(int j=0;j<len;j++){
//                char c = words[i].charAt(j);
//                arr[i].add(c);
//            }
//        }
//        //有无交集
//        boolean[][] NoConnected=new boolean[length][length];
//        for(int i=0;i<length;i++){
//            HashSet<Character> Iset = arr[i];
//            for(int j=i+1;j<length;j++){
//                String word = words[j];
//                int flag=1;
//                for(int k=0;k<word.length();k++){
//                    char c = word.charAt(k);
//                    if(Iset.contains(c)){
//                        flag=-1;
//                        break;
//                    }
//                }
//                if(flag==1) NoConnected[i][j]=true;
//            }
//        }
//        int res=0;
//        for(int i=0;i<length;i++){
//            for(int j=i+1;j<length;j++){
//                int length1 = words[i].length();
//                int length2 = words[j].length();
//                if(NoConnected[i][j]){
//                    res=Math.max(res,length1*length2);
//                }
//            }
//        }
//        return res;
//    }
}
