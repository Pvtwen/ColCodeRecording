package NLP.MissionOne;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Yawen Cao
 * @data 2021/11/21 19:32
 */
public class writeFile {
    public static void main(String[] args) {
        String path="D:\\EclipiseWorkspace\\Arithmatics\\src\\NLP\\MissionOne\\unigram";
        File f=new File(path);
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
            bfw.write("ok\n");
            bfw.write("ok\n");
            bfw.close();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
