package String;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kevin.Z on 2017/12/26.
 */
public class String2Date {
    public static void main(String[] args) {
        try {
            String s = "Mon Dec 25 00:00:00 CST 2017";
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            Date d = sdf.parse(s);
            System.out.println(d);
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
