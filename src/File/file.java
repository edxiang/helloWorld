package File;

import java.io.*;

/**
 * Created by edxiao.zeng on 2017/6/22.
 */
public class file {
    public static void main(String[] args) {
        File file = new File("1.txt");
        System.out.println(file.getAbsolutePath());
        if (file.exists()) ;
        else {
            try {
                file.createNewFile();
                InputStream is = new FileInputStream(file);
                OutputStream os = new FileOutputStream(file);
                String text = "this is a text;\nthis is another text";
                int i;
                byte[] bytes = new byte[1024];
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getAbsoluteFile());
    }
}
