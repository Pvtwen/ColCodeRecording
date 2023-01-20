package dataStructure.Leetcode.Match279;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/2/6 10:44
 */
public class Q2 {
    public long smallestNumber(long num) {
        List<Integer>list=new ArrayList<>();
        int num0=0;
        String s = String.valueOf(num);
        int i=0;
        if(num>0) i=0;
        else if(num<0) i=1;
        for(;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='0'){
                num0++;
                continue;
            }
            list.add(Integer.parseInt(c+""));
        }

        if(num>0){
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            while(num0>0){
                list.add(1,0);
                num0--;
            }
        }else{
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            while(num0>0){
                list.add(list.size(),0);
                num0--;
            }
        }
        Integer[] ret= new Integer[list.size()];
        ret=list.toArray(ret);
        long r=0;
        long base=1;
        for(i=ret.length-1;i>=0;i--){
            r+=ret[i]*base;
            base*=10;
        }
        if(num<0) r=-r;
        return r;
    }
//    public long smallestNumber(long num) {
//        HashMap<Character,Integer> map=new HashMap<>();
//        String s = String.valueOf(num);
//        for(int i=0;i<s.length();i++){
//            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
//        }
//        String ret="";
//        if(num>0){
//            int idx=0;
//            for(char c='1';c<='9';c++){
//                if(idx==1){
//                    while(map.containsKey('0')){
//                        ret+='0';
//                        map.put('0',map.get('0')-1);
//                        if(map.get('0')==0) map.remove('0');
//                    }
//                }
//                while(map.containsKey(c)){
//                    if(idx==1){
//                        while(map.containsKey('0')){
//                            ret+='0';
//                            map.put('0',map.get('0')-1);
//                            if(map.get('0')==0) map.remove('0');
//                        }
//                    }
//                    ret+=c;
//                    map.put(c,map.get(c)-1);
//                    if(map.get(c)==0) map.remove(c);
//                    idx++;
//                }
//            }
//        }
//        else{
//            for(char c='9';c>='0';c--){
//                while(map.containsKey(c)){
//                    ret+=c;
//                    map.put(c,map.get(c)-1);
//                    if(map.get(c)==0) map.remove(c);
//                }
//            }
//        }
//        long r=Long.parseLong(ret);
//        if(num<0) r=-r;
//        return r;
//    }
}
