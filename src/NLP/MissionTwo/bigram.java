package NLP.MissionTwo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/11/21 19:45
 */
public class bigram {
    String path = "D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\MissionTwo\\test";
    String path1 = "D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\MissionTwo\\trigram";
    HashMap<String, Integer> map = new HashMap<>();
    public void bigramReader() {
        File f = new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            while (line != null) {
                String[] strs = line.split(" ");
                statisticBigram(strs);
                line = bfr.readLine();
            }
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void statisticBigram(String[] strs) {
        int length = strs.length;
        String prefix = strs[0];
        String suffix = strs[length - 1];
        prefix = "<BOS>_" + prefix;
        suffix += "_<EOS>";
        map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        map.put(suffix, map.getOrDefault(suffix, 0) + 1);
        for (int i = 0; i < length - 1; i++) {
            String s1 = strs[i];
            String s2 = strs[i + 1];
            String combine = s1 + "_" + s2;
            map.put(combine, map.getOrDefault(combine, 0) + 1);
        }
    }
    public void bigramWriter() {
        File f = new File(path1);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            writer(bfw);
            bfw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writer(BufferedWriter bfw) {
        try {
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                String str = entry.getKey();
                Integer count = entry.getValue();
                bfw.write(str + "\t" + count+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
