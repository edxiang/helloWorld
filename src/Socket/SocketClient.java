package Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Kevin.Z on 2017/9/4.
 */
// done!
public class SocketClient {
    public static final String IP_ADDR = "192.168.88.105";
    public static final int PORT = 12224;
    private static volatile boolean close = false;
    static Socket socket = null;
    static CountDownLatch latch = new CountDownLatch(2);


    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        try {
            socket = new Socket(IP_ADDR, PORT);

            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Writer writer = new OutputStreamWriter(socket.getOutputStream());
                        String s;
                        String end = "\r\n";
                        while(true) {
                            s = new Scanner(System.in).nextLine();
                            writer.write(s + end);
                            writer.flush();
                            if(s.equals("ok"))
                                break;
                        }
                        System.out.println("client: latch.countDown in receive");
                        //writer.close();
                        latch.countDown();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });

            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        StringBuilder time = new StringBuilder();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String tempString;
                        while(!close){
                        //while((tempString = reader.readLine())!=null){
                            tempString = reader.readLine();
                            System.out.println(tempString);
                            if(tempString.equals("OK"))
                                break;
                            time.append(tempString);
                        }
                        System.out.println("client: latch.countDown in send");
                        latch.countDown();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });

            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                    System.out.println("in client: close");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getFreeSpace() {
        try {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket socket = new Socket(IP_ADDR, PORT);
                        DataInputStream input = new DataInputStream(socket.getInputStream());

                        String ret = input.readUTF();
                        System.out.println(ret);
                            /*long tempLong = Long.parseLong(ret);
                            System.out.println("from server: " + (tempLong / (1024 * 1024 * 1024)));*/

                            /*input.close();
                            socket.close();*/
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
