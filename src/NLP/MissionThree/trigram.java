package NLP.MissionThree;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/11/21 19:58
 */
public class trigram {
    String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\MissionThree\\test";
    String path1="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\MissionThree\\trigram";
    HashMap<String,Integer> map=new HashMap<>();
    public void trigramReader() {
        File f=new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            while(line!=null){
                String[] strs = line.split(" ");
                statisticTrigram(strs);
                line=bfr.readLine();
            }
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void statisticTrigram(String[] strs){
        int length = strs.length;
        String s1 = strs[0];
        String s2 = strs[1];
        String s3 = strs[length - 2];
        String s4 = strs[length - 1];
        String prefix="<BOS>_"+s1+"_"+s2;
        String suffix=s3+"_"+s4+"_"+"<EOS>";
        map.put(prefix,map.getOrDefault(prefix,0)+1);
        map.put(suffix,map.getOrDefault(suffix,0)+1);
        for(int i=0;i<length-2;i++){
            String str1 = strs[i];
            String str2 = strs[i + 1];
            String str3 = strs[i + 2];
            String combine=str1+"_"+str2+"_"+str3;
            map.put(combine,map.getOrDefault(combine,0)+1);
        }
    }
    public void trigramWriter(){
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
                String strs = entry.getKey();
                Integer count = entry.getValue();
                bfw.write(strs+"\t"+count+"\n");
            }
            System.out.println("done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
