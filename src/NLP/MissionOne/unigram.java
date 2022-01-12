package NLP.MissionOne;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/11/21 19:24
 */
public class unigram {
    String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\MissionOne\\test";
    String path1="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\MissionOne\\unigram";
    HashMap<String,Integer> map=new HashMap<>();
    public void unigramReader() {
        File f=new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            while(line!=null){
                map.put("<BOS>",map.getOrDefault("<BOS>",0)+1);
                map.put("<EOS>",map.getOrDefault("<EOS>",0)+1);
                String[] strs = line.split(" ");
                for (String str : strs) {
                    map.put(str,map.getOrDefault(str,0)+1);
                }
                line=bfr.readLine();
            }
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void unigramWriter(){
        File f=new File(path1);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            writeHash(bfw);
            bfw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeHash(BufferedWriter bfw){
        try {
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                String str = entry.getKey();
                Integer count = entry.getValue();
                bfw.write(str+"\t"+count+"\n");
            }
            System.out.println("done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}