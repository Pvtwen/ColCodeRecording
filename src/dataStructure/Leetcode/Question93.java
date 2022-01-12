package dataStructure.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86153
 * @data 2021/8/10 15:51
 */
public class Question93 {
    static final int SETMENT=4;
    static int[] segments=new int[SETMENT];
    static List<String> ans=new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        if (s.length()<4 || s.length()>12){
            return null;
        }
        dfs(s,0,0);
        return ans;
    }
    public static void dfs(String s,int seg,int start){
        if(seg==SETMENT){
            if(start==s.length()){
                StringBuilder stringBuilder=new StringBuilder();
                for(int i=0;i<4;i++){
                    stringBuilder.append(segments[i]);
                    if(i!=3){
                        stringBuilder.append('.');
                    }
                }
                ans.add(stringBuilder.toString());
            }
            return;
        }

        if(start==s.length()) return;
        if(s.charAt(start)=='0'){
            segments[seg]=0;
            dfs(s,seg+1,start+1);
        }

        int num=0;
        for(int end=start;end<s.length();end++){
            num=num*10+Integer.parseInt(Character.toString(s.charAt(end)));
            if(num>0 && num<256){
                segments[seg]=num;
                dfs(s,seg+1,end+1);
            }else{
                return;
            }
        }
    }
}
