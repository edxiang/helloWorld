package Socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Kevin.Z on 2017/9/12.
 */
public class ServerCommunicate {
    private static final int PORT = 12225;

    public static void main(String[] args) {
        new ServerCommunicate().init();
    }

    public void init(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while(true){
                Socket client = serverSocket.accept();
                System.out.println("accept one:"+client.toString());
                new Thread(new Communicate(client)).start();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    class Communicate implements Runnable{
        Socket socket = null;
        CountDownLatch latch = null;
        ExecutorService es = Executors.newFixedThreadPool(20);

        JFrame jf;
        JPanel msgPanel;
        JPanel typePanel;
        JTextArea msgArea;
        JTextArea typeArea;
        JButton sendBtn;

        public Communicate(Socket socket){
            this.socket = socket;
            latch = new CountDownLatch(2);

            jf = new JFrame();
            jf.setLayout(new BorderLayout());
            jf.setSize(400,500);
            jf.setLocationRelativeTo(null);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setTitle(socket.getRemoteSocketAddress().toString() + " : "+socket.getPort());

            msgArea = new JTextArea(20,30);
            msgArea.setEditable(false);
            msgArea.setBackground(Color.GRAY);
            typeArea = new JTextArea(10,30);

            msgPanel = new JPanel();
            msgPanel.add(new JScrollPane(msgArea));
            typePanel = new JPanel();
            typePanel.add(new JScrollPane(typeArea));

            sendBtn = new JButton("send");

            jf.add(msgPanel,BorderLayout.NORTH);
            jf.add(typePanel,BorderLayout.CENTER);
            jf.add(sendBtn,BorderLayout.SOUTH);


            jf.setVisible(true);

            sendBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sendMsg();
                }
            });
            typeArea.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                    if(e.getKeyCode() == 10) {
                        System.out.println("work!");
                        sendMsg();
                    }
                }
            });
        }

        @Override
        public void run(){
            /*es.execute(new Runnable() {
                @Override
                public void run() {
                    sendMsg();
                }
            });*/

            es.execute(new Runnable() {
                @Override
                public void run() {
                    receiveMsg();
                }
            });

            try {
                latch.await();
                socket.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }

        public void receiveMsg(){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String tempString;
                while((tempString = reader.readLine())!=null){
                    msgArea.append(tempString.trim() +"\n");
                    if(tempString.equals("OK"))
                        break;
                }
                System.out.println("end of receive thread.");
                latch.countDown();
            } catch(Exception e){
                e.printStackTrace();
                latch.countDown();
            }
        }

        public void sendMsg(){
            try {
                Writer writer = new OutputStreamWriter(socket.getOutputStream());
                String s;
                String end = "\r\n";
                /*while(true){
                    s = new Scanner(System.in).nextLine();
                    writer.write(s+end);
                    writer.flush();
                    if(s.equals("OK"))
                        break;
                }
                System.out.println("end of send thread.");*/
                //writer.close();

                s = typeArea.getText();
                if (s.equals("OK")) {
                    System.out.println("end of send thread.");
                    latch.countDown();
                } else {
                    //s += end;
                    writer.write(s.trim()+"\n");
                    writer.flush();
                    msgArea.append(s);
                    typeArea.setText("");
                }
            } catch(Exception e){
                e.printStackTrace();
                latch.countDown();
            }
        }
    }
}
