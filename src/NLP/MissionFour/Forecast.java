package NLP.MissionFour;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/21 20:17
 */
public class Forecast {
    HashMap<String,Integer> unigramMap;
    HashMap<String,Integer> bigramMap;
    public Forecast(HashMap<String,Integer> map1,HashMap<String,Integer> map2){
        unigramMap=map1;
        bigramMap=map2;
    }
    public void forecastStrs(String[] lines){
        List<Float> list=new ArrayList<>();
        for (String line : lines) {
            String[] strs = line.split(" ");
            String pre = strs[0];String suf=strs[strs.length-1];
            // <BOS>
            float mul=1;
            Integer preCount = unigramMap.get("<BOS>");
            Integer preCountM = bigramMap.get("<BOS>" + "pre");
            mul*=(preCountM/(float)preCount);
            //<EOS>
            Integer sufCount = unigramMap.get(suf);
            Integer sufCountM = bigramMap.get(suf + "<EOS>");
            mul*=(sufCount/(float)sufCountM);
            int length = line.length();
            for(int i=0;i<length-1;i++){
                String fir = strs[i];
                String sec = strs[i + 1];
                //分母
                if(!unigramMap.containsKey(fir)) {
                    mul=0;
                    break;
                }
                Integer countZ = unigramMap.get(fir);
                Integer countM = bigramMap.get(fir + "_" + sec);
                mul*=(countZ/(float)countM);
            }
            list.add(mul);
        }
    }
    public void forecast(String line){
        String[] strs = line.split(" ");
        String pre = strs[0];String suf=strs[strs.length-1];
        // <BOS>
        float mul=1;
        Integer preCount = unigramMap.get("<BOS>");
        Integer preCountM = bigramMap.get("<BOS>" + "pre");
        mul*=(preCountM/(float)preCount);
        //<EOS>
        Integer sufCount = unigramMap.get(suf);
        Integer sufCountM = bigramMap.get(suf + "<EOS>");
        mul*=(sufCount/(float)sufCountM);
        int length = line.length();
        for(int i=0;i<length-1;i++){
            String fir = strs[i];
            String sec = strs[i + 1];
            //分母
            Integer countZ = unigramMap.get(fir);
            Integer countM = bigramMap.get(fir + "_" + sec);
            mul*=(countZ/(float)countM);
        }
    }
    String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\MissionFour\\lang_model";
    public void write(List<Float> list){
        File f=new File(path);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            for (Float flo : list) {
                bfw.write(flo+"\n");
            }
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 加一平滑
    public void additiveSmooth(String[] lines){
        int V = unigramMap.keySet().size();
        List<Float> list=new ArrayList<>();
        for (String line : lines) {
            String[] strs = line.split(" ");
            String pre = strs[0];String suf=strs[strs.length-1];
            // <BOS>
            float mul=1;
            Integer preCount = unigramMap.get("<BOS>");
            preCount+=V;
            Integer countZ = bigramMap.getOrDefault("<BOS>" + pre, 0);
            mul*=(countZ/(float)preCount);
            //<EOS>
            Integer sufCount = unigramMap.getOrDefault(suf, 0);
            sufCount+=V;
            Integer sufCountM = bigramMap.getOrDefault(suf + "<EOS>", 0);
            sufCountM++;
            mul*=(sufCountM/(float)sufCount);
            int length = line.length();
            for(int i=0;i<length-1;i++){
                String fir = strs[i];
                String sec = strs[i + 1];
                String fz=fir+"_"+sec;
                countZ = unigramMap.getOrDefault(fz, 0);
                countZ++;
                Integer countM = unigramMap.getOrDefault(fir, 0);
                countM+=unigramMap.size();
                mul*=(countZ/(float)countM);
            }
            list.add(mul);
        }
    }
}
