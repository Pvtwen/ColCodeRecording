package dataStructure.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/12/26 10:00
 */
public class Question1078 {
    // KMP  卡在测试用例 ["we","we","we","we","a"]  ["we"] ["we"]
//    public String[] findOcurrences(String text, String first, String second) {
//        String[] s = text.split(" ");
//        int n = s.length;
//        int[] next = getNext(first, second);
//        String[] model=new String[3];
//        model[0]=" ";
//        model[1]=first;
//        model[2]=second;
//        List<String> ret=new ArrayList<>();
//        int i=0,j=1;
//        while(i<n){
//            if(j==0 || model[j].equals(s[i])){
//                i++;
//                j++;
//            }else j=next[j];
//            if(j==3 && i<n) {
//                ret.add(s[i]);
//                j=1;
//            }
//        }
//        String[] re=new String[ret.size()];
//        re=ret.toArray(re);
//        return re;
//    }
//    public int[] getNext(String first,String second){
//        int[] next=new int[3];
//        next[0] = -1;next[1]=0;
//        next[2]=1;
//        return next;
//    }

//    public String[] findOcurrences(String text, String first, String second) {
//        String[] s = text.split(" ");
//        int length = s.length;
//        List<String> ret=new ArrayList<>();
//        for(int i=0;i+2<length;i++){
//            if(s[i].equals(first) && s[i+1].equals(second)){
//                ret.add(s[i+2]);
//            }
//        }
//        String[] re=new String[ret.size()];
//        re=ret.toArray(re);
//        return re;
//    }
}
