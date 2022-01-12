package dataStructure.Leetcode;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/6 10:09
 */
public class Question71 {
    public String simplifyPath(String path) {
        // 第一遍去掉重复的/
        int length = path.length();
        int i=0;
        String newS="";
        int flag=-1;
        while(i<length){
            char c = path.charAt(i);
            newS+=c;
            while(c=='/'&&i+1<length){
                flag=1;
               i++;
               c = path.charAt(i);
            }
            if(flag==1){
                flag=-1;
                if(c!='/')newS+=c;
            }
            i++;
        }
        String[] arr = splitUp(newS);
        newS="";
        Deque<String> stack=new ArrayDeque<>();
        for (String s : arr) {
            if(s.equals("...")) stack.offer(s);
            else if(s.equals("..")){
                if(!stack.isEmpty()) stack.removeLast();
            }else if(s.equals("."));
            else{
                stack.offer(s);
            }
        }
        newS+="/";
        while(!stack.isEmpty()){
            String s = stack.removeFirst();
            newS+=s+"/";
        }
        if(newS.length()==1) return "/";
        return newS.substring(0,newS.length()-1);
    }
    public String[] splitUp(String s){
        int length = s.length();
        int i=0;
        List<String> list=new ArrayList<>();
        while(i+1<length){
            char c = s.charAt(i);
            if(c=='/'){
                String s1="";
                while(i+1<length){
                    i++;
                    c=s.charAt(i);
                    if(c=='/') break;
                    s1+=c;
                }
                list.add(s1);
            }
        }
        String[] arr=new String[list.size()];
        arr = list.toArray(arr);
        return arr;
    }
}
