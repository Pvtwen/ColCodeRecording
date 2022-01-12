package NLP.exp2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/22 19:55
 */
public class Partion {
    static String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\dataset";
    static String path1="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\training";
    static String path2="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\test";

    static List<String> res=new ArrayList<>();

    public static void main(String[] args) {
        partion();
    }
    public static void partion(){
        File f=new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            int  count=0;
            while(line!=null){
                count++;
                res.add(line);
                line=bfr.readLine();
            }
            int sevenPercent=count*7/10;
            int threePercent=count-sevenPercent;
            String[] sevenPer=new String[sevenPercent];
            String[] threePer=new String[threePercent];
            int j=0;
            for(int i=1;i<=sevenPercent;i++){
                sevenPer[i-1]=res.get(j);
                j++;
            }
            for(int i=1;i<=threePercent;i++){
                threePer[i-1]=res.get(j);
                j++;
            }
            writeToFile(path1,sevenPer);
            writeToFile(path2,threePer);
            bfr.close();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(String path,String[] strs){
        File f=new File(path);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            for (String line : strs) {
                bfw.write(line+"\n");
            }
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
