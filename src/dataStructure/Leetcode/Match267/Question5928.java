package dataStructure.Leetcode.Match267;

/**
 * @author Yawen Cao
 * @data 2021/11/14 11:28
 */
public class Question5928 {
    public String decodeCiphertext(String encodedText, int rows) {
        int length = encodedText.length();
        int col=length/rows;
        char[][] matrix= new char[rows][col];
        int k=0;
        int ch=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(encodedText.charAt(k)>='a' && encodedText.charAt(k)<='z') ch++;
                matrix[i][j]=encodedText.charAt(k);
            }
        }
        StringBuilder str=new StringBuilder();
        int chNum=0,inity=0,i=0,j=0;
        while(chNum<ch && i<rows && j<col){
            str.append(matrix[i][j]);
            if(matrix[i][j]>='a' && matrix[i][j]<='z'){
                chNum++;
            }
            if(i+1==rows){
                i=0;j=inity+1;inity++;
                continue;
            }
            i++;j++;
        }
        return str.toString();
    }
}
