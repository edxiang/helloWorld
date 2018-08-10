package File;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by edxiao.zeng on 2017/7/17.
 */
public class ChangeContentAndWriteBack {


    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(new FileInputStream("license"));
        BufferedReader bis = new BufferedReader(is);
        String s;
        StringBuffer temp = new StringBuffer("");
        while ((s = bis.readLine()) != null) {
            temp.append(s + "\n");
        }
        //System.out.println(temp);
        bis.close();
        is.close();

        String[] ss = temp.toString().split("@");
        System.out.println("this:"+ss[3]);
        //new ChangeContentAndWriteBack().changePort(3306);
    }

    //更改Tomcat的默认端口
    public void testMatch(int port) throws IOException {
        InputStreamReader is = new InputStreamReader(new FileInputStream("server.xml"));
        BufferedReader bis = new BufferedReader(is);
        String s;
        StringBuffer temp = new StringBuffer("");
        while ((s = bis.readLine()) != null) {
            temp.append(s + "\n");
        }
        System.out.println(temp);
        bis.close();
        is.close();

        Pattern p = Pattern.compile("<Connector port=\"....\" protocol=\"HTTP");
        Matcher m = p.matcher(temp);
        String s1 = "<Connector port=\"" + port + "\" protocol=\"HTTP";
        String writeBack = m.replaceAll(s1);

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("server.xml"));
        osw.write(writeBack);
        osw.close();
    }

    public void testLine(String baseDir, String dataDir) throws IOException {
        InputStreamReader is = new InputStreamReader(new FileInputStream("my.ini"));
        BufferedReader bis = new BufferedReader(is);
        String s;
        StringBuffer temp = new StringBuffer("");
        while ((s = bis.readLine()) != null) {
            temp.append(s + "\n");
        }
        System.out.println(temp);
        bis.close();
        is.close();

        Pattern pBase = Pattern.compile("basedir[^\n]*\n?");
        Matcher mBase = pBase.matcher(temp);
        String base = ChangeContentAndWriteBack.class.getProtectionDomain().getCodeSource().getLocation().toString();
        String bas2 = ChangeContentAndWriteBack.class.getClass().getResource("/").getPath();
        System.out.print(bas2);
        String s1 = base + "\n";
        String writeBack1 = mBase.replaceAll(s1);

        Pattern pData = Pattern.compile("datadir[^\n]*\n?");
        Matcher mData = pData.matcher(writeBack1);
        String s2 = base + "\n";
        String writeBack = mData.replaceAll(s2);

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("my.ini"));
        osw.write(writeBack);
        osw.close();
    }

    public void absolutePath() {
        String path = "F:\\TRIP\\marcTEST.txt";
        File file = new File(path);
        System.out.println(file.getAbsolutePath());

        String p = "F:/TRIP/marcTEST.txt";
        File f = new File(p);
        System.out.print(f.getAbsolutePath());
    }

    public void prop(String address, int port) throws IOException {
        InputStreamReader is = new InputStreamReader(new FileInputStream("application.properties"));
        BufferedReader bis = new BufferedReader(is);
        String s;
        StringBuffer temp = new StringBuffer("");
        while ((s = bis.readLine()) != null) {
            temp.append(s + "\n");
        }
        System.out.print(temp);
        bis.close();
        is.close();

        Pattern p = Pattern.compile("jdbc:mysql:[^\n]*\n?");
        Matcher m = p.matcher(temp);
        String s2 = "jdbc:mysql://" + address + ":" + port + "/seamtest?useUnicode=true&characterEncoding=UTF-8\n";
        String writeBack = m.replaceAll(s2);

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("application.properties"));
        osw.write(writeBack);
        osw.close();
    }

    public void changePort(int port) throws IOException {
        InputStreamReader is = new InputStreamReader(new FileInputStream("my.ini"));
        BufferedReader bis = new BufferedReader(is);
        String s;
        StringBuffer temp = new StringBuffer("");
        while ((s = bis.readLine()) != null) {
            temp.append(s + "\n");
        }
        System.out.println(temp);
        bis.close();
        is.close();

        Pattern pPort = Pattern.compile("port\\s*= \\d{1,5}");
        Matcher mPort = pPort.matcher(temp);
        String sPort = "port    = " + port;
        String back = mPort.replaceAll(sPort);

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("my.ini"));
        osw.write(back);
        osw.close();
    }

}
