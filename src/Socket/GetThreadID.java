package Socket;

import org.apache.pdfbox.ExportXFDF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Kevin.Z on 2017/9/7.
 */
public class GetThreadID {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("192.168.88.105", 12224);

        StringBuilder time = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String tempString;
        if ((tempString = reader.readLine()) != null) {
            System.out.println(tempString);
            time.append(tempString);
        }
        System.out.println(time);


        Writer writer = new OutputStreamWriter(socket.getOutputStream());
        String s;
        String end = "\r\n";
        s = new Scanner(System.in).nextLine();
        writer.write(s+end);
        writer.flush();
        System.out.println("I'm finished");

        socket.close();
    }
}
