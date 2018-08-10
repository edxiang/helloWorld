package File.ByteToFile;

import java.io.*;

/**
 * Created by Kevin.Z on 2017/7/27.
 */
public class ByteToFile {

    public static void main(String[] args) throws IOException{
        new ByteToFile().byteTest();
    }

    public void byteTest() throws IOException{
        String s = "hello world!";

        File file = new File("1.txt");
        OutputStream os = new FileOutputStream(file);
        byte[] bytes = s.getBytes();
        os.write(bytes);
        os.close();
    }

}
