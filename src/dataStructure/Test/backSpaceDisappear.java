package dataStructure.Test;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2023/1/4 19:47
 */
public class backSpaceDisappear {
    public static void main(String[] args) {
        String s="当用户认为\n" +
                "圉中的 VO信息不够完备时．便可以参照该 VO 的\n" +
                "规格说明。当某一个VO午分复杂，即使用说明文件\n" +
                "也不能描述清楚时．使可以将其分解为若干子 VO．\n" +
                "并 用 VOBA．梳图对这些子 VO进行描述 ，以便 获得";
        int len = s.length();
        char[] arr=new char[len];
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ' && s.charAt(i)!='\n') {
                arr[j]=s.charAt(i);
                j++;
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(arr);
        String string = stringBuilder.toString();
        System.out.println(string);
    }
}
