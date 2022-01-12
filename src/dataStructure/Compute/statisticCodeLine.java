package dataStructure.Compute;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/6 10:06
 *  统计代码行数 8855
 */
public class statisticCodeLine {
    static String path="D:\\EclipiseWorkspace\\Arithmatics";
    static String path1="D:\\EclipiseWorkspace\\Arithmatics\\src\\dataStructure\\Compute\\CodeLine";
    static String pythonPath="D:\\Pycharm\\oneHundredThousandCodePlanning";
    static int res=0;
//    static List<File> list=new ArrayList<>();
    static List<File> list=new ArrayList<>();
    public static void main(String[] args) {
        // python
        File f1 = new File(pythonPath);
        dfs(f1);
        File f=new File(path);
        dfs(f);
        for (File file : list) {
            int flag1=-1,flag2=-1;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String sLine = reader.readLine();
                while(sLine!=null){
                    if(file.getName().endsWith(".java")){
                        String trim = sLine.trim();
                        if(trim.startsWith("public")||trim.startsWith("class")){
                            flag1=1;
//                        res--;
                        }
                        if(flag1==1 && condtion(trim)) res++;
                        sLine = reader.readLine();
                    }
                    // 如果是python文件
                    if(file.getName().endsWith(".py")){
                        String trim = sLine.trim();
                        if(trim.startsWith("def")){
                            flag2=1;
//                        res--;
                        }
                        if(flag2==1 && condition1(trim)) res++;
                        sLine = reader.readLine();
                    }
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File f2=new File(path1);
        SimpleDateFormat s=new SimpleDateFormat();
        s.applyPattern("yyyy-MM-dd HH:mm:ss a");
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f2,true));
            bfw.write(s.format(new Date())+":"+res+"\n");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean condtion(String trim){
        if(trim.length()==0) return false;
        if(trim.startsWith("{") && trim.length()<2) return false;
        if(trim.startsWith("}") && trim.length()<2) return false;
        return true;
    }
    public static  boolean condition1(String trim){
        if(trim.length()<=3) return false;
        return true;
    }
//     .java
    public static void dfs(File file){
        File[] files = file.listFiles();
        if(files==null) return;
        for (File f : files) {
            if(f.isDirectory()){
                dfs(f);
            }else if(f.isFile()){
                if(f.getName().endsWith(".java") || f.getName().endsWith(".py"))
//                    System.out.println(f.getName());
                    list.add(f);
            }
        }
    }
//
//    public static void dfs(File file){
//        File[] files = file.listFiles();
//        if(files==null) return;
//        for (File f : files) {
//            if(f.isDirectory()){
//                dfs(f);
//            }else if(f.isFile()){
//                if(f.getName().endsWith(".cpp") || f.getName().endsWith(".c"))
//                    list.add(f);
//            }
//        }
//    }
}
