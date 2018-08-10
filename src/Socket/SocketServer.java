package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Kevin.Z on 2017/9/4.
 */
// work!
public class SocketServer {
    private static final int PORT = 12224;
    private ExecutorService es = Executors.newFixedThreadPool(50);
    private ExecutorService esListenInput = Executors.newCachedThreadPool();
    private ExecutorService esListenOutput = Executors.newCachedThreadPool();
    private ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);

    private Map<String,Socket> m = new LinkedHashMap<>();
    private List<String> list = new ArrayList<>();
    private static volatile boolean downloading = false;

    public static void main(String[] args) {
        new SocketServer().init();
    }

    public void init(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            check();

            while (true){
                Socket client = serverSocket.accept();
                System.out.println(client.toString());
                m.put(client.toString(),client);
                list.add(client.toString());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void check() {
        ses.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    System.out.println("-----------" + list.size() + "-----------------" + downloading);
                    if (!downloading) {
                        if (list.size() > 0) {
                            String threadName = list.get(0);

                            Socket sckt = m.get(threadName);
                            downloading = true;
                            list.remove(0);
                            m.remove(threadName);

                            es.execute(new FeedBack(sckt));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0,1, TimeUnit.SECONDS);
    }


    class FeedBack implements Runnable{
        Socket sckt = null;
        public FeedBack(Socket sckt){
            this.sckt = sckt;
        }

        @Override
        public void run(){
            try {
                /*Writer writer = new OutputStreamWriter(sckt.getOutputStream());
                String s;
                String end = "\r\n";
                s = "you can download!";
                writer.write(s+end);
                writer.flush();*/

                Thread.sleep(3000);
                System.out.println("wake up~");

                /*StringBuilder time = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(sckt.getInputStream()));
                String tempString;
                if((tempString = reader.readLine())!=null){
                    System.out.println(tempString);
                    time.append(tempString);
                }*/

            } catch(Exception e){
                e.printStackTrace();
            }finally {
                if(sckt != null){
                    try {
                        downloading = false;
                        sckt.close();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class ListenInputStream implements Runnable{
        Socket socket = null;
        public ListenInputStream(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run(){
            try {
                while(true) {
                    StringBuilder time = new StringBuilder();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String tempString;
                    if ((tempString = reader.readLine()) != null) {
                        System.out.println(tempString);
                        time.append(tempString);
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }finally {
                if(socket != null){
                    try {
                        socket.close();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
