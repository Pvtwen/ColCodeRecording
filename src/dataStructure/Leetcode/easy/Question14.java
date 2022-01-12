package dataStructure.Leetcode.easy;

/**
 * @author 86153
 * @data 2021/8/4 23:41
 */
public class Question14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        int minLength=strs[0].length();
        for (int i=1;i<strs.length;i++) {
            minLength= Math.min(strs[i].length(), minLength);
        }
        char p;
        for(int i=0;i<minLength;i++){
            p=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=p)
                    return stringBuilder.toString();
        }
            stringBuilder.append(p);
    }
        return stringBuilder.toString();
}
}
