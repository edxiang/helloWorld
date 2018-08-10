package concurrent;

import java.io.*;

/**
 * Created by Kevin.Z on 2017/9/26.
 */
public class TestCostTime {
    public static void main(String[] args) {
        System.out.println(System.nanoTime());
    }

    public void test(){
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(new File("cost.mp4"));
            os = new FileOutputStream(new File("F:\\cost1.mp4"), true);
            byte[] b = new byte[1024 * 1024];
            int len = 0;
            long begin = System.currentTimeMillis();
            long end = 0L;
            long cost = 0L;
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
                os.flush();
                end = System.currentTimeMillis();
                cost = end - begin;
                System.out.println(cost + "-------------");
                begin = System.currentTimeMillis();
            }
            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
