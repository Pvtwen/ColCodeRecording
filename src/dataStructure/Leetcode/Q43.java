package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2022/3/9 15:00
 */
public class Q43 {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        if(num1=="0" || num2=="0") return "0";
        int[] ret=new int[l1+l2];
        int[] res=new int[l1+l2];
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                int i1 = l1 - i - 1;
                int i2 = l2 - j - 1;
                int i3 = i+j;
                char c = num1.charAt(i1);
                char c1 = num2.charAt(i2);
                int i5 = Integer.parseInt(c + "");
                int i6 = Integer.parseInt(c1 + "");
                ret[i3]+=i5*i6;
                if(j==0 || i==l1-1){
                    // 本位
                    int i4 = ret[i3] % 10;
                    res[i3]=i4;
                    if(ret[i3]/10!=0){
                        ret[i3+1]+=ret[i3]/10;
                        if(i==l1-1 && j==l2-1) res[i3+1]=ret[i3+1];
                    }
                }
            }
        }
        int re = ret[l1 + l2 - 1];
        int len;
        if(re==0)len=l1+l2-1;
        else len=l1+l2;
        String s="";
        for(int i=len-1;i>=0;i--){
            s+=res[i];
        }

        return s;
    }
}
