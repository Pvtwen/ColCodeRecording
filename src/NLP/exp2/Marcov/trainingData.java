package NLP.exp2.Marcov;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yawen Cao
 * @data 2021/11/22 20:46
 */
public class trainingData {
    static String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\training";
    static String path1="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\series";
    static String path2="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\marcovs";
    static List<String> res=new ArrayList<>();
    static List<String[]> list=new ArrayList<>();
    static HashMap<String,Integer> map=new HashMap<>();

    public static void main(String[] args) {
        readFile();
        System.out.println("readFileDown");
        splitDown();
        System.out.println("splitDown");
        writeResToFile();
        System.out.println("writeresDown");
        writeMapToFile();
        System.out.println("all done");
    }
    public static void readFile(){
        File f=new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            while(line!=null){
                res.add(line);
                line=bfr.readLine();
            }
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeMapToFile(){
        File f=new File(path2);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            for (Map.Entry<String, Integer> entries : map.entrySet()) {
                String key = entries.getKey();
                Integer count = entries.getValue();
                String combine=key+"\t"+count;
                bfw.write(combine+"\n");
            }
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeResToFile(){
        File f=new File(path1);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            for (String[] strs : list) {
                String ch = strs[0];
                String series = strs[1];
                bfw.write(ch+"\t"+series+"\n");
            }
            bfw.close();
            System.out.println("writeDown");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void splitDown(){
        int size = res.size();
        for (String string : res) {
            String[] s = string.split(" ");
            for(int i=0;i<s.length;i++){
                int length = s[i].length();
                for(int j=0;j<length;j++){
                    char c = s[i].charAt(j);
                    String[] str=new String[2];
                    str[0]=""+c+"";
                    if(j==0){
                        str[1]="B";
                    }else if(j==length-1){
                        str[1]="E";
                    }else{
                        str[1]="I";
                    }
                    list.add(str);
                    String combine=str[0]+"-"+str[1];
                    map.put(combine,map.getOrDefault(combine,0)+1);
                }
            }
        }
        System.out.println("splitdown over");
    }
}
