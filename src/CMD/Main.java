package CMD;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Kevin.Z on 2017/9/4.
 */
public class Main {
    public static void main(String[] args) {
        InputStream ins = null;
        String[] cmd = new String[]{"cmd.exe","/C","wmic LogicalDisk where \"Caption='C:'\" get FreeSpace"};
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            ins = process.getInputStream();  // 获取执行cmd命令后的信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            String line = null;
            String s = "";
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);  // 输出
                s += line.trim();
            }
            System.out.println(s.split("FreeSpace")[1]);
            int exitValue = process.waitFor();
            System.out.println("返回值：" + exitValue);
            process.getOutputStream().close();  // 不要忘记了一定要关
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
