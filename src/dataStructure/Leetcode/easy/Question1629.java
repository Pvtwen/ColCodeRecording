package dataStructure.Leetcode.easy;

/**
 * @author Yawen Cao
 * @data 2022/1/9 9:49
 */
public class Question1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] alpha=new int[30];
        char[] chars = keysPressed.toCharArray();
        int maxTime=Integer.MIN_VALUE;
        for(int i=0;i<chars.length;i++){
            int i1 = chars[i] - 'a';
            int time;
            if(i==0){
                time=releaseTimes[0];
            }else time=releaseTimes[i]-releaseTimes[i-1];
            alpha[i1]=Math.max(alpha[i1],time);
            maxTime=Math.max(maxTime,time);
        }
        char ret='a';
        for(int i=0;i<alpha.length;i++){
            if(maxTime==alpha[i]){
                if(ret-'a'<i) ret= (char) ('a'+i);
            }
        }
        return ret;
    }
}
