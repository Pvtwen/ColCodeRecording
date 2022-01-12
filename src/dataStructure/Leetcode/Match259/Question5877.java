package dataStructure.Leetcode.Match259;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/9/20 10:07
 * 枚举
 */
public class Question5877 {
    HashMap<String,Integer> map;
    int ans;
    public Question5877() {
        map=new HashMap<>();
        ans=0;
    }

    public void add(int[] point) {
        String str=point[0]+","+point[1];
        map.put(str,map.getOrDefault(str,0)+1);
    }

    public int count(int[] point) {
        ans=0;
        for (String s : map.keySet()) {
            Integer prex=Integer.parseInt(s.split(",")[0]);
            Integer prey=Integer.parseInt(s.split(",")[1]);
            int pointx=point[0];
            int pointy=point[1];
            if(prex==pointx || prey==pointy) continue;
            if(Math.abs(prex-pointx) == Math.abs(prey-pointy)){
                String str1=pointx+","+prey;
                String str2=prex+","+pointy;
                if(!map.containsKey(str1) || !map.containsKey(str2)) continue;
                else ans+=map.get(s)*map.get(str1)*map.get(str2);
            }
        }
        return ans;
    }
}
