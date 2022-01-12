package dataStructure.Leetcode.Match273;

/**
 * @author Yawen Cao
 * @data 2021/12/26 10:41
 */
public class Question5964 {
    // 模拟
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int length = s.length();
        int[][] step = new int[length][2];
        int[] base={0,0};
        int[] direction = direction(s.charAt(0));
        base[0]+=direction[0];
        base[1]+=direction[1];
        step[0]=base;

        for (int i = 1; i < length; i++) {
            int[] ints = new int[]{step[i-1][0],step[i-1][1]};
            int[] direction1 = direction(s.charAt(i));
            ints[0]+=direction1[0];
            ints[1]+=direction1[1];
            step[i]=ints;
        }
        int[] ret = new int[length];
        int baseX = startPos[0];
        int baseY = startPos[1];
        // 从指令i开始
        for(int i=0;i<length;i++){
            int j=i;
            for(;j<length;j++){
                if(i==0){
                    int x = step[j][0];
                    int y = step[j][1];
                    boolean condition = condition(n, baseX + x, baseY + y);
                    if(!condition){
                        ret[i] = j;
                        break;
                    }
                }else{
                    int bx = step[i - 1][0];
                    int by = step[i - 1][1];
                    int i1 = step[j][0]-bx;
                    int i2 = step[j][1]-by;
                    boolean condition = condition(n, baseX+i1, baseY+i2);
                    if(!condition){
                        ret[i] = j - i;break;
                    }
                }
            }
            if(j==length) ret[i]=j-i;
        }
        return ret;
    }
    public int[] direction(char c){
        if(c=='R') return new int[]{0,1};
        if(c=='L') return new int[]{0,-1};
        if(c=='U') return new int[]{-1,0};
        if(c=='D') return new int[]{1,0};
        return null;
    }

    public boolean condition(int n, int i, int j) {
        return i < n && j < n && i>=0 && j>=0;
    }
//    int n;
//    public int[] executeInstructions(int n, int[] startPos, String s) {
//        int length = s.length();
//        this.n = n;
//        int[] ret=new int[length];
//        for(int i=0;i<length;i++){
//            int idx = dfs(i, startPos, s);
//            int num=idx-i;
//            ret[i]=num;
//        }
//        return ret;
//    }
//
//    public int dfs(int idx, int[] startPos, String s) {
//        // 指令走完
//        if (idx == s.length()) return idx;
//        char[] chars = s.toCharArray();
//        char c = s.charAt(idx);
//        int x = startPos[0];
//        int y = startPos[1];
//        if(c=='R') y++;
//        else if(c=='L') y--;
//        else if(c=='U') x--;
//        else x++;
//        if (condition(n,x,y)) return dfs(idx + 1, new int[]{x, y}, s);
//        // 下标越界 直接返回当前的指令下标
//        else return idx;
//    }
//
}
