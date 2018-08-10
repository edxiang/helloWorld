package utils;

import java.io.File;

/**
 * Created by Kevin.Z on 2018/4/8.
 */
public class Tester {
    public static void main(String[] args) {
        File file = new File("hw.txt");
        try {
            byte[] bs = NIOUtils.getByteByBuffer(file);
            String s = new String(bs);
            System.out.println(s);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
