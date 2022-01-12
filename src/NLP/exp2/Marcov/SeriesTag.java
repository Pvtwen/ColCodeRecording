package NLP.exp2.Marcov;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/23 19:30
 */
public class SeriesTag {
    static String s="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\marcovs";
    static String s1="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\test";

    public static void main(String[] args) {
        readMarcovFile();
        readTestFile();
        dealWithRes();
        writeListToResult();
        System.out.println("done");
    }
    static HashMap<String,Integer> map=new HashMap<>();
    public static void readMarcovFile(){
        File f=new File(s);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            while(line!=null){
                String[] strs = line.split("\t");
                String str = strs[0];
                int count=Integer.parseInt(strs[1]);
                map.put(str,count);
                line=bfr.readLine();
            }
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static List<String> res=new ArrayList<>();
    public static void readTestFile(){
        File f=new File(s1);
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
    static String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\Marcov\\result";
    public static void writeListToResult(){
        File f=new File(path);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            for (String s : list) {
                bfw.write(s+"\n");
            }
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static List<String> list=new ArrayList<>();
    public static void dealWithRes(){
        for (String strings : res) {
            String[] s = strings.split(" ");
            String ret = combineAllStrings(s);
            for(int j=0;j+1<ret.length();j++){
                    String fir_b=ret.charAt(j)+"-B";
                    String fir_i=ret.charAt(j)+"-I";
                    String sec_I=ret.charAt(j+1)+"-I";
                    String sec_E=ret.charAt(j+1)+"-E";
                    String key = findMax(fir_b, fir_i, sec_I, sec_E);
                    list.add(key);
                }
                char c = ret.charAt(ret.length() - 1);
                list.add(c+"\tE");
                list.add("");
        }
    }
    public static String combineAllStrings(String[] s){
        String ret="";
        for (String s1 : s) {
            ret+=s1;
        }
        return ret;
    }
    public static String findMax(String fir_b,String fir_i,String sec_I,String sec_E){
        Integer firb = map.getOrDefault(fir_b, 0);
        Integer firi = map.getOrDefault(fir_i, 0);
        Integer seci = map.getOrDefault(sec_I, 0);
        Integer sece = map.getOrDefault(sec_E, 0);
        int bi=firb*seci;
        int be=firb*sece;
        int ii=firb*seci;
        int ie=firi*sece;
        int max = Math.max(Math.max(bi, be), Math.max(ii, ie));
        char c = fir_b.charAt(0);
        if(max==bi){
            return c+"\tB";
        }
        if(max==be){
            return c+"\tB";
        }
        if(max==ii){
            return c+"\tI";
        }
        if(max==ie){
            return c+"\tI";
        }
        return "";
    }
}
