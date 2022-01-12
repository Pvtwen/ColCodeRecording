package dataStructure.Leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/13 10:39
 */
public class Question241 {
    public List<Integer> diffWaysToCompute(String expression) {
        int length = expression.length();
        List<Integer> value=new ArrayList<>();
        List<Character> chars=new ArrayList<>();
        for(int i=0;i<length;i++){
            char c = expression.charAt(i);
            StringBuilder str=new StringBuilder();
            while(c>='0' && c<='9'){
                str.append(c);
                i++;
                if(i==length) break;
                c = expression.charAt(i);
            }
            if(str.length()!=0){
                value.add(Integer.parseInt(str.toString()));
            }
            if(i<length) chars.add(c);
        }
        int size = value.size();
        Integer[] val=new Integer[value.size()];
        val = value.toArray(val);
        Character[] ch=new Character[chars.size()];
        ch = chars.toArray(ch);

        ArrayList<Integer>[][] dp=new ArrayList[size][size];
        for(int i=0;i<size;i++){
            dp[i][i]=new ArrayList<>();
            dp[i][i].add(val[i]);
        }
        for(int i=1;i<size;i++){
            for(int j=i-1;j>=0;j--){
                if(i-j==0){
                    int op = op(val[j], val[i], ch[j]);
                    dp[j][i]=new ArrayList<>();
                    dp[j][i].add(op);
                    continue;
                }
                dp[j][i]=new ArrayList<>();
                for(int k=j;k<i;k++){
                    Character op = ch[k];
                    for (Integer v1 : dp[j][k]) {
                        for (Integer v2 : dp[k + 1][i]) {
                            dp[j][i].add(op(v1,v2,op));
                        }
                    }
                }
            }
        }
        return dp[0][size-1];
    }
    public int op(int a,int b,char operation){
        if(operation=='+'){
            return a+b;
        }else if(operation=='-'){
            return a-b;
        }else{
            return a*b;
        }
    }
}
