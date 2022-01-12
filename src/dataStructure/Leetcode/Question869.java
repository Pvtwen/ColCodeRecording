package dataStructure.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Yawen Cao
 * @data 2021/10/28 18:54
 */
public class Question869 {
    static int length;
    static HashSet<Integer> set=new HashSet<>();
    static {
        for(int i=0;i<=30;i++){
            set.add(1<<i);
        }
    }
    public static boolean reorderedPowerOf2(int n) {
        String s = String.valueOf(n);
        length=s.length();
        char[] arr = s.toCharArray();
        boolean[] visited=new boolean[length];
        return dfs(arr,new StringBuilder(),0,visited);
    }
    public static boolean dfs(char[] arr,StringBuilder str,int depth,boolean[] visited){
        if(depth==length){
            return set.contains(Integer.parseInt(str.toString()));
        }

        for(int i=0;i<length;i++){
            char c = arr[i];
            if(str.length()==0 && c=='0') continue;
            if(visited[i]!=true){
                StringBuilder newStr=new StringBuilder(str);
                boolean[] newArr = Arrays.copyOf(visited, length);
                newArr[i]=true;
                newStr.append(c);
                boolean b = dfs(arr, newStr, depth + 1, newArr);
                if(b) return true;
            }
        }
        return false;
    }
}
