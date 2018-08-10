package File;

import java.io.*;

/**
 * Created by edxiao.zeng on 2017/7/6.
 */
public class GetAllFileFromDirectory {
    public static void main(String[] args) {
        new GetAllFileFromDirectory().getAllFile("D:\\CloudMusic");
    }

    public void getAllFile(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFile(f.getAbsolutePath());
            } else
                System.out.println(f.getAbsoluteFile() + "-" + (f.length()));
        }
    }

}
