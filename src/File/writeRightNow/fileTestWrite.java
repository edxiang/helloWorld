package File.writeRightNow;

import java.io.*;

/**
 * Created by edxiao.zeng on 2017/7/24.
 */
public class fileTestWrite {

    public static void main(String[] args) throws IOException{
        File file = new File("TDDownload.zip");
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream("E:/whatever.zip",true);

        int len = 0;
        byte[] bytes = new byte[1024*8];
        System.out.println("begin:");
        while ((len = is.read(bytes)) != -1) {
            try {
                Thread.sleep(30);
            }catch (Exception e){
                e.printStackTrace();
            }
            os.write(bytes, 0, len);
        }
        os.flush();
        os.close();
        is.close();
        System.out.println("end:");
    }
}
