package URL;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Kevin.Z on 2017/10/26.
 */
public class GetURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.douban.com/group/topic/108652796/");
            System.out.println(url.getUserInfo());
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while(data != null){
                //System.out.println(data);
                data = br.readLine();
            }

        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
