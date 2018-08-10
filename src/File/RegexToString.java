package File;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by edxiao.zeng on 2017/7/24.
 */
public class RegexToString {
    public static void main(String[] args) throws IOException {
        new RegexToString().getURL();
    }

    public static int getServerPort(String path) throws IOException {
        String filePath = "server.xml";
        StringBuffer temp = getContent(filePath);

        Pattern p = Pattern.compile("<Connector port=\"\\d{1,5}\"");
        Matcher m = p.matcher(temp);
        while (m.find()) {
            String host = m.group();
            System.out.println(host);
            return Integer.parseInt(host.split("\"")[1]);
        }
        return -1;
    }

    public static String getURL() throws IOException {
        String filePath = "application.properties";
        StringBuffer temp = getContent(filePath);

        Pattern p = Pattern.compile("jdbc:mysql:[^\n]*\n?");
        Matcher m = p.matcher(temp);
        while (m.find()) {
            String url = m.group();
            String s1 = url.split("//")[1];
            String address = s1.split("/")[0].split(":")[0];
            String port = s1.split("/")[0].split(":")[1];
            String name = s1.split("/")[1].split("\\?")[0];
            System.out.println(address + "@" + port + "@" + name);
            return address + "@" + port + "@" + name;
        }
        return null;
    }

    public static StringBuffer getContent(String filePath) throws IOException {
        InputStreamReader is = new InputStreamReader(new FileInputStream(filePath));
        BufferedReader bis = new BufferedReader(is);
        String s;
        StringBuffer temp = new StringBuffer("");
        while ((s = bis.readLine()) != null) {
            temp.append(s + "\n");
        }
        bis.close();
        is.close();
        //System.out.println(temp);

        return temp;
    }
}
