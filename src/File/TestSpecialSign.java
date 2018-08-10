package File;

import java.io.*;

/**
 * Created by edxiao.zeng on 2017/7/19.
 */
public class TestSpecialSign {
    public static void main(String[] args) throws Exception {
        File file = new File("1.txt");
        String path = file.getAbsolutePath();
        System.out.println(path);

        int lastIndex = path.lastIndexOf("\\");
        if (lastIndex > 0) {
            path = path.substring(0, lastIndex);
            int index = path.indexOf(":");
            if (index > 0) {
                path = path.substring(index + 1);
            }
            path = path.replace("\\", "/");
            path = new String(path.getBytes("GB2312"),"iso-8859-1");

            System.out.println(path);
        } else {
            System.out.println("null");
        }

    }
}
