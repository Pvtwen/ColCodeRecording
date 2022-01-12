package dataStructure.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Yawen Cao
 * @data 2021/11/17 10:36
 */
public class readFile {
    static String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\dataStructure\\Test\\TestReadFile.java";

    public static void main(String[] args) {
        File f=new File(path);
        int row=0;
        int flag=-1;
        String[] lines=new String[100];
        int idx=0;
        try {
            BufferedReader reader=new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while(line!=null){
                line = line.trim();
                if(line.startsWith("public")||line.startsWith("class")){
                    flag=1;
                    row--;
                }
                if(flag==1 && line.length()>1) {
                    lines[idx]=line;
                    row++;
                    idx++;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(row);
        for(int i=0;i<idx;i++){
            System.out.println(lines[i]+" "+lines[i].length());
        }
    }

}
