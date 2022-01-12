package dataStructure.Leetcode.Match274;

/**
 * @author Yawen Cao
 * @data 2022/1/2 10:36
 */
public class Question5968 {
    public int numberOfBeams(String[] bank) {
        int length = bank.length;
        int[] newBank=new int[length];
        for(int i=0;i<length;i++){
            int num = num(bank[i]);
            newBank[i]=num;
        }
        //
        int i=0,j=1;
        int ret=0;
        while(i<=j && j<length){
            if(i==j) {
                j++;
                continue;
            }
            if(newBank[i]!=0 && newBank[j]!=0){
                ret+=newBank[i]*newBank[j];
                i=j;
                j++;
            }
            else if(newBank[i]==0){
                i++;
            }
            else if(newBank[j]==0){
                j++;
            }
        }
        return ret;
    }
    public int num(String s){
        int length = s.length();
        int sum=0;
        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            if(c=='1') sum++;
        }
        return sum;
    }
}
