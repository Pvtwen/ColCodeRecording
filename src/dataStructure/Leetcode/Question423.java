package dataStructure.Leetcode;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/11/24 11:25
 */
public class Question423 {
    //["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"]
    static HashMap<Character,Integer> map=new HashMap<>();
    static int countE,countG,countF,countI,countH,countO,countN,countS,countr,countu,countT,countW,countV,countX,countZ;
    public static String originalDigits(String s) {
        int length = s.length();
        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        countE=map.getOrDefault('e',0);
        countG=map.getOrDefault('g',0);
        countF=map.getOrDefault('f',0);
        countI=map.getOrDefault('i',0);
        countH=map.getOrDefault('h',0);
        countO=map.getOrDefault('o',0);
        countN=map.getOrDefault('n',0);
        countS=map.getOrDefault('s',0);
        countr=map.getOrDefault('r',0);
        countu=map.getOrDefault('u',0);
        countT=map.getOrDefault('t',0);
        countW=map.getOrDefault('w',0);
        countV=map.getOrDefault('v',0);
        countX=map.getOrDefault('x',0);
        countZ=map.getOrDefault('z',0);
        String str="";
        int[] count=new int[10];
        count[0]=countZ;
        count[6]=countX;
        count[2]=countW;
        count[4]=countu;
        count[8]=countG;
        count[5]=countF-count[4];
        count[7]=countV-count[5];
        count[3]=countH-count[8];
        count[1]=countO-count[0]-count[2]-count[4];//0 2 4
        count[9]=countI-count[5]-count[6]-count[8];
        for(int i=0;i<10;i++){
            for(int j=1;j<=count[i];j++){
                str+=i;
            }
        }
        return str;
    }

}
