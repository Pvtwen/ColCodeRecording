package NLP.exp2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/22 19:35
 */
public class PreDeal {
    static String path="C:\\Users\\86153\\Desktop\\马原\\segmented\\segmented";
    static String path1="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\exp2\\dataset";
    static List<String> res=new ArrayList<>();
    public static void main(String[] args) {
//        File doc=new File(path);
//        File[] files = doc.listFiles();

        readMultiFile();
        writeToFile();
    }
    public static void readMultiFile(){
        File doc=new File(path);
        File[] files = doc.listFiles();
        int count=1;
        for (File f : files) {
            System.out.println("正在读取文件"+count);
            try {
                BufferedReader bfr = new BufferedReader(new FileReader(f));
                String line = bfr.readLine();
                int flag=-1;
                while(line!=null){
                    if(line.startsWith("<S ID=")){
                        flag=1;
                        line=bfr.readLine();
                        continue;
                    }
                    if(flag==1){
                        System.out.println(line);
                        res.add(line);
                        flag=-1;
                    }
                    line=bfr.readLine();
                }
                bfr.close();
                System.out.println("读取文件结束"+count);
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void readFile(){
        File f=new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            int flag=-1;
            while(line!=null){
                if(line.startsWith("<S ID=")){
                    flag=1;
                    line=bfr.readLine();
                    continue;
                }
                if(flag==1){
                    System.out.println(line);
                    res.add(line);
                    flag=-1;
                }
                line=bfr.readLine();
            }
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(){
        File f=new File(path1);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            for (String str : res) {
                bfw.write(str+"\n");
            }
            bfw.close();
            System.out.println("donw");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
