package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Kevin.Z on 2017/9/7.
 */
public class T1 {
    public static void main(String[] args) throws Exception {
            Socket socket;

            socket = new Socket("192.168.88.105", 12224);
            StringBuilder time = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tempString;
            if ((tempString = reader.readLine()) != null) {
                System.out.println(tempString);
                time.append(tempString);
            }

            Thread.sleep(15000);

            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            String end = "\r\n";
            String s = "I'm finished~";
            writer.write(s + end);
            writer.flush();

            socket.close();
        }
}
