package NLP.exp2.Marcov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/23 20:22
 */
public class DealWithFinalResult {
    String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\Marcov\\final_result";
    List<String[]> res=new ArrayList<>();
    int count=0;
    //3
    public void constructSentence(String[][] array){
        int length = array.length;
        String temp="";
        temp+=array[0][0];
        String[] senteces=new String[count];
        int i=1,j=0;
        while(i<length){
            if(array[i][0].equals("")){
                //写文件
                senteces[j]=temp;
                temp="";
                i++;j++;
                continue;
            }
            if(array[i][1].equals("B")){
                temp+=" "+array[i][0];
            }
        }
    }
    //2
    public void convertListToArray(){
        String[][] array=new String[count][2];
        int i=0;
        for (String[] s : res) {
            if(s==null) continue;
            array[i][0]=s[0];
            array[i][1]=s[1];
            i++;
        }
        constructSentence(array);
    }
    //1
    public void finalResult(){
        File f=new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            while(line!=null){
                if(line.equals("")){
                    count++;
                    res.add(null);
                    line=bfr.readLine();
                    continue;
                }
                String[] split = line.split("\t");
                String s = split[0];
                String tag = split[1];
                res.add(new String[]{s,tag});
                line=bfr.readLine();
            }
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
